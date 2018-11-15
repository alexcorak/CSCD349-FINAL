package heroesAndMonsters;

public class Room
{
	private String[][] room = new String[3][3];
	private boolean north = true;
	private boolean south = true;
	private boolean east = true;
	private boolean west = true;
	
	
	public Room(int x, int y, int lengthOfDungeon)
	{
		if (x == 0) {
			this.west = false;
			room[1][0] = "*";
		}
		if (x == lengthOfDungeon - 1) {
			this.east = false;
			room[2][1] = "*";
		}
		
		if (y == 0) {
			this.north = false;
			room[0][1] = "*";
		}
		if (y == lengthOfDungeon - 1) {
			this.south = false;
			room[2][1] = "*";
		}
		
		room[0][0] = "*";
		room[2][0] = "*";
		room[0][2] = "*";
		room[2][2] = "*";
		
		room[1][1] = "C";
		
		
			
	}
	
	public void printRoom()
	{
		if (north)
			room[0][1] = "-";
		if (south)
			room[2][1] = "-";
		if (west)
			room[1][0] = "|";
		if (east)
			room[1][2] = "|";
		
		for (int row = 0; row < room.length; row++)
		{
			for (int col = 0; col < room.length; col++)
			{
				
					
				System.out.print(room[row][col]);
			}
			System.out.println();
		}
	}
	
	
}
