import java.util.Scanner;
import heroesAndMonsters.*;





/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class Dungeon
{
    public static void main(String[] args)
	{ 	
		Hero theHero;
		Monster theMonster;

		do
		{
		    theHero = chooseHero();
		    theMonster = generateMonster();
			battle(theHero, theMonster);

		} while (playAgain());

    }

/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Hero) to accomplish
this task
---------------------------------------------------------------------*/
    
	public static Hero chooseHero()
	{
		Scanner input = new Scanner(System.in);
		int choice;
		HeroFactory factory = new HeroFactory();

		System.out.println("Choose a hero by number:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");
		choice = input.nextInt();
		
		return factory.createHero(choice);
					
		
	}

/*-------------------------------------------------------------------
generateMonster randomly selects a Monster and returns it.  It utilizes
a polymorphic reference (Monster) to accomplish this task.
---------------------------------------------------------------------*/
	
	public static Monster generateMonster()
	{
		int choice;
		MonsterFactory factory = new MonsterFactory();
		choice = (int)(Math.random() * 3) + 1;

		return factory.createMonster(choice);
				
	}

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	
	public static boolean playAgain()
	{
		Scanner input = new Scanner(System.in);		
		char again;

		System.out.println("Play again (y/n)?");		
		again = input.next().charAt(0);
		
		
		return (again == 'Y' || again == 'y');
	}


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	
	public static void battle(Hero theHero, Monster theMonster)
	{
		Scanner input = new Scanner(System.in);
		char quit = 'p';
		
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");
		
		while (theHero.isAlive() && theMonster.isAlive() && quit != 'q')
		{
			theHero.battleChoices(theMonster);
			
			if (theMonster.isAlive())
			    theMonster.attack(theHero);
			
			System.out.print("\n-->q to quit, anything else to continue: ");
			quit = input.nextLine().charAt(0);

		}

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");
		
		

	}


}//end Dungeon class
