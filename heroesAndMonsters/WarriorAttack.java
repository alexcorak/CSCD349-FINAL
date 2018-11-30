package heroesAndMonsters;

public class WarriorAttack implements Attack
{

	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println();
			System.out.println(attacker.getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(attacker.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed
		
	}

}
