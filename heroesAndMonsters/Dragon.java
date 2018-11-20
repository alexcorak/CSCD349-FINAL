package heroesAndMonsters;

public class Dragon extends Monster
{

	private String phrase;
	private double dropChance;
	
	public Dragon()
	{
		super("The Grey Dragon", 220,4, .7,.25,35,55,30,50);
		this.dropChance = 1.0;
		this.phrase = " breathes superheated blue flame at ";
	}
	
	@Override
	public double getDropChance() 
	{
		return this.dropChance;
	}

	@Override
	public String getPhrase() 
	{
		return this.phrase;
	}

}
