package heroesAndMonsters;

import java.util.Scanner;

public class test
{
	public static void main(String[] args)
	{
		Hero player = chooseHero();
		Monster monster = generateMonster();
		
		battle(player, monster);
	}
	
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
	
	public static Monster generateMonster()
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
		return factory.createMonster(5);
	}
	
	public static void battle(Hero theHero, Monster theMonster)
	{
		Scanner input = new Scanner(System.in);
		char quit = 'p';
		
		FlyweightAttack that = new FlyweightAttack();
    	Attack atk;
		
		
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");
		
		while (theHero.isAlive() && theMonster.isAlive() && quit != 'q')
		{
			theHero.battleChoices(theMonster);
			
			if (theMonster.isAlive())
			{
				atk = that.getAttack("Attack");
	    		atk.attack(theMonster, theHero);
			}
			
			System.out.print("\n-->q to quit, anything else to continue: ");
			quit = input.nextLine().charAt(0);

		}

		if (!theMonster.isAlive()) {
		    System.out.println(theHero.getName() + " was victorious!");
		    if(theMonster.loot(theMonster))//make them all the same drop rate and delete the param?
		    {
		    	System.out.println("You found a potion!");
		    	//add a potion to the inventory
		    }
		}
		else if (!theHero.isAlive()) {
			System.out.println(theHero.getName() + " was defeated :-(");
			System.out.println("\nPillars found: " + theHero.pillarsFound());
			System.exit(0);
		}
		else
			System.out.println("Quitters never win ;-)");
		
		

	}
}
