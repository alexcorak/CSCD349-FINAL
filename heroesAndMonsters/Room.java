package heroesAndMonsters;

import java.util.ArrayList;
import java.util.Random;

public class Room
{
	private char[] room;
	private boolean north = true;
	private boolean south = true;
	private boolean east = true;
	private boolean west = true;
	private ArrayList<Character> itemList;
	private char[] contents;
	private char[] contents2;
	private boolean visited;
	
	
	
	public Room(int row, int col, int lengthOfDungeon, char content)
	{
		visited = false;
		contents = new char[2];
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
	
	public boolean hasVisted()
	{
		return this.visited;
	}
	
	public void hideContent()
	{
		/*if (visited)
		{
			room[8] = this.contents[0];
		}*/
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
	/*public void printRoom()
	{
		/*String str = new String(room);
		StringBuilder s = new StringBuilder(str);
		for (int i = 0; i < str.length(); i++)
		{
			if (i % 7 == 0)
				s.insert(i, "\n");
		}
		//System.out.println(s + " Room contains: " + this.contents);
		System.out.print("Your room contains: " + this.contents[0]);
	}*/
	
	
}
