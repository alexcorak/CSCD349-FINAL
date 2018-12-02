package dungeon;

public class HeroFactory
{
	public Hero createHero(int heroType)
	{
		Hero hero;
		
		if (heroType == 1)
			hero = new Warrior();		
		else if (heroType == 2)
			hero = new Sorceress();
		else if (heroType == 3)
			hero = new Thief();
		else if (heroType == 4)
			hero = new Archer();
		else if (heroType == 5)
			return new Berserker();
		else
		{
			System.out.println("Invalid choice, returning a Thief");
			hero = new Thief();
		}
		
		return hero;
			
	}
}
