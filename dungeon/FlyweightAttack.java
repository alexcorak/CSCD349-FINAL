package dungeon;

import java.util.HashMap;

public class FlyweightAttack
{
	private static FlyweightAttack singleton;
	private HashMap<String, Attack> pool = new HashMap<>();
	
	private FlyweightAttack() {}
	
	public static FlyweightAttack getInstance()
	{
		if (singleton == null)
			singleton = new FlyweightAttack();
		
		return singleton;
		
	}
	
	public Attack getAttack(String key)
	{
		Attack atk = pool.get(key);
		if (atk == null)
		{
			if (key == "WarriorAttack")
			{
				atk = new WarriorAttack();
				pool.put(key, atk);
			}
			else if (key == "BerserkerAttack")
			{
				atk = new BerserkerAttack();
				pool.put(key, atk);
			}
			else if (key == "ArcherAttack")
			{
				atk = new ArcherAttack();
				pool.put(key, atk);
			}
			else if (key == "SorceressAttack")
			{
				atk = new SorceressAttack();
				pool.put(key, atk);
			}
			else if (key == "ThiefAttack")
			{
				atk = new ThiefAttack();
				pool.put(key, atk);
			}
			else //(key == "Attack")
			{
				atk = new AnAttack();
				pool.put(key, atk);
			}
			
		}
			
		return atk;
	}
}
