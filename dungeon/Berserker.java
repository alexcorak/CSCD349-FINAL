package dungeon;

import java.util.Scanner;

public class Berserker extends Hero
{
	private String phrase;
	public Berserker() 
	{
		super("Berserker", 120, 4, .75, 30, 55, .4);
		this.phrase = " swings a great axe at ";
	}
		
	public void battleChoices(DungeonCharacter opponent)
	{
		FlyweightAttack that = new FlyweightAttack();
    	Attack atk;
    	
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
			    case 1: atk = that.getAttack("Attack");
	    				atk.attack(this, opponent);
			        break;
			    case 2: atk = that.getAttack("BerserkerAttack");
	    				atk.attack(this, opponent);
	    				    					    				
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			setNumTurns(getNumTurns() - 1);
			if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0);
	}

	@Override
	public String getPhrase() {
		return this.phrase;
	}
	

}
