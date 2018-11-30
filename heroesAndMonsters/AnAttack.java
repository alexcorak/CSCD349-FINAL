package heroesAndMonsters;

public class AnAttack implements Attack
{
				
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent)
	{
		 System.out.println(attacker.getName() + attacker.getPhrase() +
					opponent.getName() + ":");
		 
		 
		 boolean canAttack;
			int damage;

			canAttack = Math.random() <= attacker.getChanceToHit();

			if (canAttack)
			{
				damage = (int)(Math.random() * (attacker.getDamageMax() - attacker.getDamageMin() + 1))
							+ attacker.getDamageMin() ;
				opponent.subtractHitPoints(damage);



				System.out.println();
			}//end if can attack
			else
			{
				System.out.println(attacker.getName() + "'s attack on " + opponent.getName() +
									" failed!");
				System.out.println();
			}//end else
	}

}
