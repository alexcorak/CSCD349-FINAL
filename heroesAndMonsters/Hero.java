package heroesAndMonsters;
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
	private int healingPotion;
	private int visionPotion;
	private int pillarsFound;
	private int[] location;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	this.healingPotion = 0;
	this.visionPotion  = 0;
	this.pillarsFound = 0;
	readName();
  }

//------------------------------------------------------------------  
  public void setLocation(int[] coords) 
  {
	  this.location = coords;
  }
  
  public int[] inventory()
  {
	  int[] array = new int[3];
	  array[0] = this.healingPotion;
	  array[1] = this.visionPotion;
	  array[2] = this.pillarsFound;
	  return array;
  }
  public String toString()
  {
	String s = this.getName() + " has "+this.getHitPoints()+" hitpoints remaining, ";
	for(int x = 0;x<2;x++)
	{
		s += this.inventory()[x] + " ";
	}
	s+= "pillars";
		return s;
  }
  public double getChanceToBlock() {
		return chanceToBlock;
	}
  public void setLocation(int[] coords) 
  {
	  this.location = coords;
  }
  
  public int[] inventory()
  {
	  int[] array = new int[3];
	  array[0] = this.healingPotion;
	  array[1] = this.visionPotion;
	  array[2] = this.pillarsFound;
	  return array;
  }
  public String toString()
  {
	String s = this.getName() + " has "+this.getHitPoints()+" hitpoints remaining, ";
	for(int x = 0;x<2;x++)
	{
		s += this.inventory()[x] + " ";
	}
	s+= "pillars";
		return s;
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






