package dungeon;

public class SorceressAttack implements Attack
{

	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent) 
	{
		int hPoints;

		hPoints = (int)(Math.random() * (Sorceress.MAX_ADD - Sorceress.MIN_ADD + 1)) + Sorceress.MIN_ADD;
		attacker.addHitPoints(hPoints);
		System.out.println();
		System.out.println(attacker.getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ attacker.getHitPoints());
		 System.out.println();
		
	}
	
}
