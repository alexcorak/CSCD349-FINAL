package heroesAndMonsters;
import java.util.Scanner;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Thief extends Hero
{
	
	
	private String phrase;
    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);
		this.phrase = " Slashes a dagger at ";


    }//end constructor


    public void battleChoices(DungeonCharacter opponent)
	{
    	FlyweightAttack that = new FlyweightAttack();
    	Attack atk;
    	
    	Scanner input = new Scanner(System.in);
		super.battleChoices(opponent);
		int choice;


		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
		    System.out.print("Choose an option: ");
		    choice = input.nextInt();
		    System.out.println();

		    switch (choice)
		    {
			    case 1: atk = that.getAttack("Attack");
	    				atk.attack(this, opponent);
			        break;
			    case 2: atk = that.getAttack("ThiefAttack");
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