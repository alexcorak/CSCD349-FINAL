package heroesAndMonsters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(DungeonCharacter opponent)

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;
	private int[] location;
	private ArrayList<Integer> pillars;
	private HashMap<Character, Integer> lootList;
	

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  Hero(String name, int hitPoints, int attackSpeed,
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
	
	public void accessLoot()
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
					}
				}
				break;
				
				case 3:
					break;
			}
			
			}while (choice < 1 || choice > 3);
		}
		
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
/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
  public void readName()
  {
	  Scanner input = new Scanner(System.in);
		System.out.print("Enter character name: ");
		setName(input.nextLine());
  }//end readName method

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtractHitPoints()
---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

/*-------------------------------------------------------
subtractHitPoints checks to see if hero blocked attack, if so a message
is displayed, otherwise base version of this method is invoked to
perform the subtraction operation.  This method overrides the method
inherited from DungeonCharacter promoting polymorphic behavior

Receives: hit points to subtract
Returns: nothing

This method calls: defend() or base version of method
This method is called by: attack() from base class
---------------------------------------------------------*/
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

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices



	//public abstract void battleChoices(DungeonCharacter opponent);


	
}//end Hero class






