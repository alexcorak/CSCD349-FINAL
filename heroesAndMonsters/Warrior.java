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




public class Warrior extends Hero
{
	private String phrase;
	
    public Warrior()
	{
		super("Warrior", 135, 4, .8, 35, 60, .2);
		this.phrase = " swings a mighty sword at ";
    }//end constructor

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
		    System.out.println("2. Crushing Blow on Opponent");
		    System.out.print("Choose an option: ");
		    choice = input.nextInt();
		    input.nextLine();
		    System.out.println();

		    switch (choice)
		    {
			    case 1: atk = that.getAttack("Attack");
			    		atk.attack(this, opponent);
			        break;
			    case 2: atk = that.getAttack("WarriorAttack");
			    		atk.attack(this, opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			setNumTurns(getNumTurns() - 1);
			if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0);

    }//end battleChoices method


	@Override
	public String getPhrase() {
		return this.phrase;
	}


}//end Hero class