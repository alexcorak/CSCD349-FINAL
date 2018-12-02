package dungeon;
import java.util.Scanner;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */



public class Sorceress extends Hero
{
	private String phrase;
	public static final int MIN_ADD = 25;
	public static final int MAX_ADD = 50;

//-----------------------------------------------------------------
    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);
		this.phrase = " casts a spell of fireball at ";

    }//end constructor
    
    public Sorceress(Hero a)
    {
    	super("Sorceress", 75, 5, .7, 25, 50, .3);
    }


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
		    System.out.println("2. Increase Hit Points");
		    System.out.print("Choose an option: ");
		    choice = input.nextInt();
		    input.nextLine();
		    System.out.println();

		    switch (choice)
		    {
			    case 1: atk = that.getAttack("Attack");
	    				atk.attack(this, opponent);
			        break;
			    case 2: atk = that.getAttack("SorceressAttack");
	    				atk.attack(this, opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			setNumTurns(getNumTurns() - 1);
		    if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);

    }//end overridden method

	@Override
	public String getPhrase() {
		return this.phrase;
	}

}//end class