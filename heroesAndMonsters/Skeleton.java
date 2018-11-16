package heroesAndMonsters;


/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Skeleton extends Monster
{
	private String phrase;
	private double dropChance;
	
    public Skeleton()
	{
		super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
		this.phrase = " slices his rusty blade at ";
		this.dropChance = .4;
    }//end constructor
    
	public String getPhrase()
	{
		return this.phrase;
	}
	
	public double getDropChance()
    {
    	return this.dropChance;
    }

}//end class Skeleton