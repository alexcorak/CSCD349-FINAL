package heroesAndMonsters;

import java.util.ArrayList;

public class Room
{
	private char[] room;
	private boolean north = true;
	private boolean south = true;
	private boolean east = true;
	private boolean west = true;
	ArrayList<Character> itemList;
	
	
	public Room(int row, int col, int lengthOfDungeon)
	{
		itemList = new ArrayList<>();
		
		
		room = new char[18];
		room[0] = '*';
		room[4] = '*';		
		room[12] = '*';		
		room[16] = '*';
		room[8] = roomContents();
		
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
					
	}
	
	private char roomContents()
	{
		return ' ';
	}
	
	public String toString()
	{		
		String str = new String(room);
		return str;
	}
	
	public String roomOnly()
	{
		return null;
	}
	
	/*public room(int row, int col, int lengthOfDungeon)
	{
		room = new char[11];
		room[0] = '*';
		room[2] = '*';		
		room[6] = '*';		
		room[8] = '*';
		room[4] = 'C';
		
		if (row == 0) {			 
			this.north = false;
			room[1] = '*';
			
		}
		if (row == lengthOfDungeon - 1) {
			this.south = false;
			room[7] = '*';
		}
		
		if (col == 0) {
			this.west = false;
			room[3] = '*';
			
		}
		if (col == lengthOfDungeon - 1) {
			this.east = false;
			room[5] = '*';
			
		}
		
		
		if (north)
			room[1] = '-';
		if (south)
			room[7] = '-';
		if (west)
			room[3] = '|';
		if (east)
			room[5] = '|';
					
	}*/
	
	
}
