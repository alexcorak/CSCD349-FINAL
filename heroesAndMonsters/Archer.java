package heroesAndMonsters;

import java.util.Scanner;

public class Archer extends Hero
{
	private int specialArrow;
	public Archer()
	{		
		super("Archer", 110,5,.9,15,50,.2); //more hp than thief,same speed as mage, more accurate, big damage range, cant block well
		this.specialArrow = 5;
	}
	
	
	public void flamingArrow(DungeonCharacter opponent)
	{
		if(Math.random()>= .3)//70% chance to hit
		{
			if(this.specialArrow!=0)
			{
				System.out.println();
				System.out.println(getName() + " lands an FLAMING ARROW for half of " + opponent.getName() + "'s health!");
				float half = opponent.getHitPoints()/3;
				int damage = Math.round(half);
				opponent.subtractHitPoints(damage);
			}
		}
		else
		{
			System.out.println("The flaming arrow misses!");
		}
		this.specialArrow--;
		System.out.println("You have "+this.specialArrow+ " arrows remaining.");
	}
	
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " shoots an arrow at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method
	
    public void battleChoices(DungeonCharacter opponent)
	{
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
			    case 1: attack(opponent);
			        break;
			    case 2: flamingArrow(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			setNumTurns(getNumTurns() - 1);
			if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0);

    }//end battleChoices method
	
	
}
