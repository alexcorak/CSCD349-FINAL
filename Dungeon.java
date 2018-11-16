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
	
int[] coordinates;
	
	Room[][] dungeon = new Room[5][5];
	
	public Dungeon()
	{
		for (int row = 0; row < dungeon.length; row++)
		{
			
			for (int col = 0; col < dungeon.length; col++)
			{
				dungeon[row][col] = new Room(row, col, dungeon.length);
			}
		}
	}
	
	
	
	public void printDungeon()
	{
		StringBuilder str = new StringBuilder();
		
		
		for (int i = 0; i < dungeon.length; i++) //ROWS
		{
			StringBuilder one = new StringBuilder();
			StringBuilder two = new StringBuilder();
			StringBuilder three = new StringBuilder();
				for (int j = 0; j < 5; j++) //COL
				{			
					one.append(dungeon[i][j].toString().substring(0, 6)); // 0,3
					two.append(dungeon[i][j].toString().substring(6, 12)); //3,6
					three.append(dungeon[i][j].toString().substring(12, 18)); //6,9
										
				}
				str.append(one);
				str.append(two);
				str.append(three);						
		}	
		int length = str.length();
		for (int k = 0; k < length; k++)
		{			
			if (k % 31 == 0) //16
				str.insert(k, "\n");				
		}		
			System.out.print(str);
	}
	
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
