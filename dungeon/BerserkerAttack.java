package dungeon;

public class BerserkerAttack implements Attack {

	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent)
	{
		FlyweightAttack that = new FlyweightAttack();
    	Attack atk;
		
		if(attacker.getHitPoints()<=45) //if your health is around 25 percent. buff to 35 hp or 40 if its a hard point to reach without dying
		{
			System.out.println(attacker.getName() + " enters a furious RAGE!");
			attacker.setAttackSpeed(1); //adds one to attack speed
			attacker.setDamage(12); //increases damage range by 12
			attacker.setHitChance(.15); //increases chance to hit to above the warrior class
			atk = that.getAttack("Attack");
			atk.attack(attacker, opponent);
			
			
			System.out.println(attacker.getName() + " calms down from his berserk rage.");
			attacker.setAttackSpeed(-1);
			attacker.setHitChance(-.15);
			attacker.setDamage(-12);
		}
		else {
			System.out.println("Your health is not low enough to use this ability!");
		}
		
		
		
	}

}
