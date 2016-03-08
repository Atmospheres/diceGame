package diceGame;

public class Human extends Player
{
	
	public static boolean isHuman;

	public Human()
	{
		super("");
	}
	
	public boolean IsHuman(Player player)
	{
		isHuman = true;
		return isHuman;
	}
	
}
