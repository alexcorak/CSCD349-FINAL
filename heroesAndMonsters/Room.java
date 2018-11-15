package heroesAndMonsters;

public class Room
{
	private char[] room;
	private boolean north = true;
	private boolean south = true;
	private boolean east = true;
	private boolean west = true;
	private char content;
	
	
	public Room(int row, int col, int lengthOfDungeon)
	{
		room = new char[11];
		room[0] = '*';
		room[2] = '*';
		room[3] = '\n';
		room[7] = '\n';
		room[8] = '*';
		
		room[10] = '*';
		room[5] = 'C';
		
		if (row == 0) {			 
			this.north = false;
			room[1] = '*';
			
		}
		if (row == lengthOfDungeon - 1) {
			this.south = false;
			room[9] = '*';
		}
		
		if (col == 0) {
			this.west = false;
			room[4] = '*';
			
		}
		if (col == lengthOfDungeon - 1) {
			this.east = false;
			room[6] = '*';
			
		}
		
		
		if (north)
			room[1] = '-';
		if (south)
			room[9] = '-';
		if (west)
			room[4] = '|';
		if (east)
			room[6] = '|';
			
		
			
	}
	
	
	public String toString()
	{
		
		String str = new String(room);
		return str;
	}
	
	
}
