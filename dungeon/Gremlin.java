package dungeon;


/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Gremlin extends Monster
{
	private String phrase;
	private double dropChance;
	
    public Gremlin()
	{
		super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
		this.phrase = " jabs his kris at ";
		this.dropChance = .3;
    }//end constructor


    public String getPhrase()
	{
		return this.phrase;
	}
    
    public double getDropChance()
    {
    	return dropChance;
    }
}//end class Gremlin