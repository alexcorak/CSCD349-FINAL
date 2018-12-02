package dungeon;

public class MonsterFactory
{
	public Monster createMonster(int number)
	{
		Monster monster;
		if (number == 1)
			monster = new Ogre();
		else if (number == 2)
			monster = new Gremlin();
		else if (number == 3)
			monster = new Skeleton();
		else if (number == 4)
			monster = new Lich();
		else if (number == 5)
			monster = new Dragon();
		else {
			System.out.println("Invalid choice, returning skeleton");
			monster = new Skeleton();
		}
		
		return monster;
	}
}
