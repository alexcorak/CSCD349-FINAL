package heroesAndMonsters;

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
		else
		{
			System.out.println("Invalid choice, returning a Thief");
			hero = new Thief();
		}
		
		return hero;
			
	}
}
