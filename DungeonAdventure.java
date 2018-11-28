import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import heroesAndMonsters.*;

public class DungeonAdventure
{
	
	public static void main(String[] args)
	{
		Hero player = chooseHero();
		Dungeon dun = new Dungeon(player);
		
		StringBuilder map = saveDungeon(dun);
		String s = map.toString();
		boolean useVision = false;
		
		System.out.println("Welcome to the dungeon!\n");
		
		while (true)
		{
						
			int menuOption = menu();
			int option = 0;
			
			if (menuOption == 1) {
				
				while (option != 5)
				{
					dun.printRoom();
					if (useVision)
					{
						dun.vision();
						printDungeon(dun);
						dun.resetVision();
					}
					else						
						printDungeon(dun);
					
					dun.lootRoom();
					dun.resetRoom();
					System.out.println("\nPillars found: " + player.pillarsFound());
					
					if ((dun.atExit() == true) && (player.pillarsFound() == 4))
					{
						System.out.println("Congrats, you've won!");
						System.exit(0);
					}
					useVision = false;
					option = moveHero(dun);
					
				}
				
			}
			else if(menuOption == 2) {
				player.showLoot();
				useVision = player.accessLoot();
			}
				
			else if (menuOption == 3) {
				saveGame(player,dun);
			}
			else if (menuOption == 4){
				StringBuilder str = new StringBuilder(s);
				printWholeDungeon(str);
			}
			else if(menuOption == 6)
			{
				heroOriginator origin = loadGame();
				player = origin.getPlayerState();
				dun = origin.getMapState();
				
				System.out.println(player.toString());
				printDungeon(dun);
				System.out.println("\n");
			}
			
			else {
				break;
			}
			
		}
		
		
	}
	
	public static heroOriginator loadGame() 
	{
		String filename = "Save1.ser";
		heroOriginator origin = new heroOriginator();
		try 
		{
		FileInputStream file = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(file);
		
		LinkedList<heroOriginator.heroMemento> list = new LinkedList<heroOriginator.heroMemento>();
		list = (LinkedList<heroOriginator.heroMemento>) in.readObject(); //this is a problem, replace with two save files??
		origin.restoreFromMemento(list.peek());
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return origin;
		
		
	}

	public static void saveGame(Hero player, Dungeon dun) 
	{
		heroOriginator origin1 = new heroOriginator();
		LinkedList<heroOriginator.heroMemento> list = new LinkedList<heroOriginator.heroMemento>();
		origin1.setMap(dun);
		origin1.setPlay(player);
		list.add(origin1.saveToMemento());
		String filename = "Save1.ser";
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(list);
			file.close();
			out.close();
			System.out.println("Hero has been saved");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
			System.out.println("6) Load");
			
			choice = sc.nextInt();
			
		}while (choice < 0 || choice > 7);
		
		return choice;
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

}//end Dungeon class
