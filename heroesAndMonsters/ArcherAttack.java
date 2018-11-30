package heroesAndMonsters;

public class ArcherAttack implements Attack 
{

	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent)
	{
		if(Math.random()>= .3)//70% chance to hit
		{
			if(attacker.getHitPoints() % 2 == 0)
			{
				System.out.println();
				System.out.println(attacker.getName() + " lands an FLAMING ARROW for a third of " + opponent.getName() + "'s health!");
				float aThird = opponent.getHitPoints()/3;
				int damage = Math.round(aThird);
				opponent.subtractHitPoints(damage);
			}
		}
		else
		{
			System.out.println("The flaming arrow misses!");
		}
		
		
	}
	
}
