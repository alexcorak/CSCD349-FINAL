package heroesAndMonsters;

public class Lich extends Monster
{

	private String phrase;
	private double dropChance;
	
	public Lich() 
	{
		super("Kel'Thuzad the Lich", 125, 4, .7, .45, 25, 45, 20, 40);
		this.dropChance = .3;
		this.phrase = " hurls a sphere of freezing magic at ";
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
