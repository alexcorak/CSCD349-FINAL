package heroesAndMonsters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Room implements Serializable
{
	private char[] room;
	private boolean north = true;
	private boolean south = true;
	private boolean east = true;
	private boolean west = true;
	private ArrayList<Character> itemList;
	private char[] contents2;
	private boolean visited;
	private boolean vision;
	
	
	
	public Room(int row, int col, int lengthOfDungeon, char content)
	{
		vision = false;
		visited = false;
		contents2 = new char[2];
		room = new char[18];
		itemList = new ArrayList<Character>();
		itemList.add('P'); //Pit
		itemList.add('V'); //Vision
		itemList.add('H'); //Healing
		itemList.add('X'); //Monster
		itemList.add('M'); //Multiple Items
		
				
		
		room[0] = '*';
		room[4] = '*';		
		room[12] = '*';		
		room[16] = '*';
		
		
		if (row == 0) {			 
			this.north = false;
			room[2] = '*';
			
		}
		if (row == lengthOfDungeon - 1) {
			this.south = false;
			room[14] = '*';
		}
		
		if (col == 0) {
			this.west = false;
			room[6] = '*';
			
		}
		if (col == lengthOfDungeon - 1) {
			this.east = false;
			room[10] = '*';
			
		}
		
		if (content == ' ') {
			room[8] = roomContents();
		}
		
		
		room[1] = ' ';
		room[3] = ' ';
		room[5] = ' ';
		room[7] = ' ';
		room[9] = ' ';
		room[11] = ' ';
		room[13] = ' ';
		room[15] = ' ';
		room[17] = ' ';
		
		
		if (north)
			room[2] = '-';
		if (south)
			room[14] = '-';
		if (west)
			room[6] = '|';
		if (east)
			room[10] = '|';
		
		this.contents2[0] = room[8];
		this.contents2[1] = ' ';
					
	}
	
	
	
	public char roomContents()
	{
		double random = Math.random();
		
		if (random <= .2) // 20% chance the room isnt empty
		{
			Random rand = new Random();
			int randomItem = rand.nextInt(itemList.size());
			return itemList.get(randomItem);
		}
		else
		{
			return ' ';
		}				
	}
	
	public char getContents()
	{
		return this.contents2[0];
	}
	
	public void setContents(String s)
	{
		
			room[8] = s.charAt(0);
		
		
		this.contents2[0] = room[8];
		this.contents2[1] = ' ';
		
	}
	
	public char youAreHere()
	{
			
		
		room[8] = '@';
	
		
		this.visited = true;
		return this.contents2[0];
	}
	
	
	public void resetRoom(char c)
	{
		if (c == 'P' || c == 'I' || c == 'O')
		{
			room[8] = c;
			this.contents2[0] = c;
		}
		
		else
		{
			room[8] = '#';
			this.contents2[0] = '#';
		}
		
		
		
		
	}
	
	public void setVision(boolean yesNo)
	{
		this.vision = true;
	}
	
	public void resetVision()
	{
		this.vision = false;
	}
	public boolean hasVision()
	{
		return this.vision;
	}
	
	public boolean hasVisted()
	{
		return this.visited;
	}
	
	public void hideContent()
	{		
		room[8] = this.contents2[1];		
	}
	public void showContent()
	{
		room[8] = this.contents2[0];
	}
	
	public String toString()
	{		
		String str = new String(room);
		return str;
	}
	
	public void printRoom()
	{
		System.out.print("Your room contains: " + this.contents2[0]);
	}
	
	
}
