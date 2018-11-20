package heroesAndMonsters;

import java.util.Scanner;

public class Berserker extends Hero
{
	public Berserker() 
	{
		super("Berserker", 120, 4, .75, 30, 55, .4);
	}
	
	public void rage(DungeonCharacter opponent)
	{
		if(this.getHitPoints()<=29) //if your health is around 25 percent. buff to 35 hp or 40 if its a hard point to reach without dying
		{
			System.out.println(getName() + " enters a furious RAGE!");
			this.setAttackSpeed(1); //adds one to attack speed
			super.setDamage(12); //increases damage range by 12
			super.setHitChance(.15); //increases chance to hit to above the warrior class
			attack(opponent);
			System.out.println(getName() + " calms down from his berserk rage.");
		}
		else {
			System.out.println("Your health is not low enough to use this ability!");
		}
		
		//reset buffs post rage
		super.setAttackSpeed(-1);
		super.setHitChance(-.15);
		super.setDamage(-12);
		
	}
	
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings a great axe at " +
				opponent.getName() + ":");
		super.attack(opponent);
	}
	
	public void battleChoices(DungeonCharacter opponent)
	{
    	Scanner input = new Scanner(System.in);
		int choice;

		super.battleChoices(opponent);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Unleash your Berserker Rage! (requires 50 hp or less remaining)");
		    System.out.print("Choose an option: ");
		    choice = input.nextInt();
		    input.nextLine();
		    System.out.println();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: rage(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			setNumTurns(getNumTurns() - 1);
			if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0);
	}
	

}
