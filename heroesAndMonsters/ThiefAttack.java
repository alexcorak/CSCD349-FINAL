package heroesAndMonsters;

public class ThiefAttack implements Attack
{

	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent)
	{
		FlyweightAttack that = new FlyweightAttack();
    	Attack atk = new AnAttack();
    	
		double surprise = Math.random();
		if (surprise <= .4)
		{
			if (attacker instanceof Hero) //Please forgive us
			{			
				System.out.println("Surprise attack was successful!\n" +
						attacker.getName() + " gets an additional turn.");
				int num = ((Hero) attacker).getNumTurns() + 1;
				((Hero) attacker).setNumTurns(num);
				
				atk = that.getAttack("Attack");
				atk.attack(attacker, opponent);
			}
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		{
			atk = that.getAttack("Attack");
			atk.attack(attacker, opponent);
		}
		
	}
	
}
