package heroesAndMonsters;

import java.util.Scanner;

public class Archer extends Hero
{
	private String phrase;
	
	public Archer()
	{
		
		super("Archer", 110,5,.9,15,50,.2);
		
		this.phrase = " shoots an arrow at ";
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
		    System.out.println("2. Flaming Arrow on Opponent");
		    System.out.print("Choose an option: ");
		    choice = input.nextInt();
		    input.nextLine();
		    System.out.println();

		    switch (choice)
		    {
			    case 1: atk = that.getAttack("Attack");
	    				atk.attack(this, opponent);
			        break;
			    case 2: atk = that.getAttack("ArcherAttack");
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
	
	
}
