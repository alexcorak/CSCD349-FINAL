package heroesAndMonsters;

import java.io.Serializable;
import java.util.LinkedList;

public class heroOriginator 
{
	private Hero state;
	private Dungeon state1;
	public void setPlay(Hero player)
	{
		this.state = player;
		System.out.println("Originator: Setting state to " + state.getName());
	}
	
	public void setMap(Dungeon dun)
	{
		this.state1 = dun;
		System.out.println("Originator: Setting state to map" );
	}
	
	public heroMemento saveToMemento()
	{
		System.out.println("Saving to Memento. ");
		return new heroMemento(state,state1);
	}
	
	public void restoreFromMemento(heroMemento memento)
	{
		this.state = memento.getPlayerSavedState();
		this.state1 = memento.getDunSavedState();
	}

	public Hero getPlayerState()
	{
		return this.state;
	}
	
	public Dungeon getMapState() {
		return this.state1;
	}
	
	public static class heroMemento implements Serializable
	{
		private final Hero playerState;
		private final Dungeon dunState;
		
		public heroMemento(Hero player)
		{
			this.playerState = player;
			this.dunState = null;
		}
		public heroMemento(Dungeon dun)
		{
			this.dunState = dun;
			this.playerState = null;
		}
		
		public heroMemento(Hero player, Dungeon dun) 
		{
			this.playerState = player;
			this.dunState = dun;
		}
		
		public Hero getPlayerSavedState()
		{
			if(playerState!=null)
				return this.playerState;
			else
				throw new IllegalArgumentException("playerState is null");
		}
		
		public Dungeon getDunSavedState()
		{
			if(dunState!=null)
				return this.dunState;
			else
				throw new IllegalArgumentException("dunState is null");
		}
	}
	
}
