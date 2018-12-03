package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public abstract class Hero extends DungeonCharacter 
{
	private double chanceToBlock;
	private int numTurns;
	private int[] location;
	private ArrayList<Integer> pillars;
	private HashMap<Character, Integer> lootList;
	

//-----------------------------------------------------------------
  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	readName();
	
	
	pillars = new ArrayList<>();
	lootList = new HashMap<>();
	this.location = new int[2];
	location[0] = 0;
	location[1] = 0;
  }

//------------------------------------------------------------------  
  public abstract String getPhrase();
  
  @Override
  public String toString()
  {
	  return "Name: "+this.getName() + " Current HP: "+ this.getHitPoints() + bagString();
  }
  
  
	public int pillarsFound()
	{
		return pillars.size();
	}
	
	public void showLoot()
	{
		for (Character c : lootList.keySet())
		{
			if (c == 'V')
			{
				System.out.print("Vision Potions left: ");
				System.out.println(lootList.get(c));
			}
			else if (c == 'H')
			{
				System.out.print("Health Potions left: ");
				System.out.println(lootList.get(c));
			}
		}
	}
	
	public String bagString() //toString helper method
	{
		String inventory = " ";
		for (Character c : lootList.keySet())
		{
			if (c == 'V')
			{
				inventory += " Vision Potions left: ";
				inventory += lootList.get(c).toString();
			}
			else if (c == 'H')
			{
				inventory += " Health Potions left: ";
				inventory += lootList.get(c).toString();
			}
		}
		
		inventory += " Pillars of OO found: " + pillars.size();
		
		return inventory;
	}
	
	public boolean accessLoot()
	{
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		if (lootList.containsKey('H') || lootList.containsKey('V'))
		{
		
			do {
			
			System.out.println("1) Use Vision Potion");
			System.out.println("2) Use Health Potion");
			System.out.println("3) Back to main menu");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
				{
					if (lootList.containsKey('V'))
					{
						
						lootList.put('V', lootList.get('V') - 1);
						if (lootList.get('V') == 0)
							lootList.remove('V');
						
						return true;
					}
				}
				break;
				
				case 2:
				{
					if (lootList.containsKey('H'))
					{
						Random rand = new Random();
						super.addHitPoints(rand.nextInt(11) + 5);
						System.out.println("You now have: " + super.getHitPoints() + " hitpoints");
						lootList.put('H', lootList.get('H') - 1);
						if (lootList.get('H') == 0)
							lootList.remove('H');
						
						return false;
					}
				}
				break;
				
				case 3:
					break;
			}
			
			}while (choice < 1 || choice > 3);
		}
		else
		{
			System.out.println("Inventory is empty. ");
		}
		
		return false;
		
	}
	
	public void addLoot(char c)
	{
		if (lootList.containsKey(c))
			lootList.put(c, lootList.get(c) + 1);
		else
			lootList.put(c, 1);
	}
	
	public void addPillar()
	{
		pillars.add(1);
	}
	
	public int[] getLocation()
	{
		return this.location;
	}
	
	public void setLocation(int x, int y)
	{
		this.location[0] += x;
		this.location[1] += y;
	}
	
	public void subtractHP(int value)
	{
		super.subtractHitPoints(value);
		
		if(this.isAlive()==false)
		{
			System.out.println("You collected "+ this.pillars.size()+ " of 4 total. Thanks for playing!");
			System.exit(0);
		}
	}
  
  
  public double getChanceToBlock() {
		return chanceToBlock;
	}
  public void setLocation(int[] coords) 
  {
	  this.location = coords;
  }
  public void setChanceToBlock(double chanceToBlock) {
		this.chanceToBlock = chanceToBlock;
	}

  public int getNumTurns() {
		return numTurns;
	}

  public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}
//-------------------------------------------------------

  public void readName()
  {
	  Scanner input = new Scanner(System.in);
		System.out.print("Enter character name: ");
		setName(input.nextLine());
  }//end readName method

//-------------------------------------------------------
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

//-------------------------------------------------------

public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

//-------------------------------------------------------
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices
	
}//end Hero class






