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


public class DungeonAdventure
{
	
	public static void main(String[] args)
	{
		Hero player = chooseHero();
		Dungeon dun = new Dungeon(player);
		
		StringBuilder map = saveDungeon(dun);
		int choice = 0;
		
		System.out.println("Welcome to the dungeon!\n");
		
		
		
		while (true)
		{
						
			int menuOption = menu();
			int option = 0;
			
			if (menuOption == 1) {
				
				while (option != 5) {
					printDungeon(dun);
					dun.lootRoom();
					dun.resetRoom();
					System.out.println("\nPillars found: " + player.pillarsFound());
					if ((dun.atExit() == true) && (player.pillarsFound() == 4)) {
						System.out.println("Congrats, you've won!");
						System.exit(0);
					}
					option = moveHero(dun);
				}
				
			}
			else if(menuOption == 2)
				System.out.println("unsupported");
			else if (menuOption == 3)
				System.out.println("Save game...");
			else if (menuOption == 4)
				printWholeDungeon(map);
			else	
				System.exit(0);
			
			
			//dun.printRoom();
			
			
				
			
					
		}
		
		
	}
	
	public static int menu()
	{
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("1) Move hero");
			System.out.println("2) Access Inventory");
			System.out.println("3) Save game");
			System.out.println("5) Quit");
			System.out.println("Any number to ");
			choice = sc.nextInt();
			
		}while (choice < 0 || choice > 5);
		
		return choice;
	}
	
	public static boolean playGame(Dungeon dun)
	{
		//Return true if we collected all four pillars or we died
		//Return false if we havent and are still playing
		return false;
	}
	
	public static void printDungeon(Dungeon dun)
	{			
			StringBuilder s = dun.hideContent(); 	
			int l = s.length();
			for (int k = 0; k < l; k++)
			{			
				if (k % 31 == 0) //16
					s.insert(k, "\n");				
			}		
				System.out.print(s);
	}
	
	public static void printWholeDungeon(StringBuilder str)
	{
		int length = str.length();
		for (int k = 0; k < length; k++)
		{			
			if (k % 31 == 0) //16
				str.insert(k, "\n");				
		}		
			System.out.println(str);
	}
	
	public static StringBuilder saveDungeon(Dungeon dun)
	{
		StringBuilder str = dun.toStringDungeon(); 	
	
		return str;
		
	}
	
	public static int moveHero(Dungeon dun)
	{
		Scanner sc = new Scanner(System.in);
		int move;
		
		
		do {
		
			System.out.println("\n\nWhere would you like to move?");
			System.out.println("1) Up");
			System.out.println("2) Down");
			System.out.println("3) Right");
			System.out.println("4) Left");
			System.out.println("5) Back to main menu");
			System.out.println("");
			move = sc.nextInt();
			
			if (move == 5)
				return move;
			
			if (dun.isValidMove(move) == false)
			{
				System.out.println("You are at the edge of the map, try again!");
			}
			
		}while (!dun.isValidMove(move));
		
		if (move == 1)
			dun.getPlayer().setLocation(-1, 0);
		else if (move == 2)
			dun.getPlayer().setLocation(1, 0);
		else if (move == 3)
			dun.getPlayer().setLocation(0, 1);
		else if (move == 4)
			dun.getPlayer().setLocation(0, -1);
		
		
			
		return 0;
		
	}
	
   /* public static void main(String[] args)
	{ 	
		Hero theHero;
		Monster theMonster;

		do
		{
		    theHero = chooseHero();
		    theMonster = generateMonster();
			battle(theHero, theMonster);

		} while (playAgain());

    }*/

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
						   "3. Thief\n"+
						   "4. Archer\n"+
						   "5. Berserker\n");
		choice = input.nextInt();
		
		return factory.createHero(choice);
					
		
	}

/*-------------------------------------------------------------------
generateMonster randomly selects a Monster and returns it.  It utilizes
a polymorphic reference (Monster) to accomplish this task.
---------------------------------------------------------------------*/
	
	/*public static Monster generateMonster()
	{
		int choice;
		boolean buffer = false;
		MonsterFactory factory = new MonsterFactory();
		choice = (int)(Math.random() * 3) + 1;
		if(choice == 5 && buffer == false)
		{
			if(Math.random() <=.5) 
			{
				choice = (int)(Math.random() * 3) + 1;
				buffer = true;
			}
		}
		return factory.createMonster(choice);
	}*/

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
	
//	public static void battle(Hero theHero, Monster theMonster)
//	{
//		Scanner input = new Scanner(System.in);
//		char quit = 'p';
//		
//		System.out.println(theHero.getName() + " battles " +
//							theMonster.getName());
//		System.out.println("---------------------------------------------");
//		
//		while (theHero.isAlive() && theMonster.isAlive() && quit != 'q')
//		{
//			theHero.battleChoices(theMonster);
//			
//			if (theMonster.isAlive())
//			    theMonster.attack(theHero);
//			
//			System.out.print("\n-->q to quit, anything else to continue: ");
//			quit = input.nextLine().charAt(0);
//
//		}
//
//		if (!theMonster.isAlive()) {
//		    System.out.println(theHero.getName() + " was victorious!");
//		    if(theMonster.loot(theMonster))//make them all the same drop rate and delete the param?
//		    {
//		    	System.out.println("You found a potion!");
//		    	theHero.addHealingPotion();
//		    }
//		}
//		else if (!theHero.isAlive())
//			System.out.println(theHero.getName() + " was defeated :-(");
//		else
//			System.out.println("Quitters never win ;-)");
//		
//		
//
//	}


}//end Dungeon class
