package heroesAndMonsters;


/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Ogre extends Monster
{
	private String phrase;

    public Ogre()
	{
		super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
		this.phrase = " slowly swings a club toward's ";

    }//end constructor

    public String getPhrase()
	{
		return this.phrase;
	}


}//end Monster class