package diceGame;

public class Player
{
	
	String name;
	String currentElement;
	int health;
	int guardLevel;
	int mana;
	boolean isHuman;
	
	Dice dice = new Dice();
	
	public Player()
	{
		health = 1000;
		mana = 50;
		isHuman = true;
	}
	
	public void ViewCurrentStats()
	{
		System.out.println("Name: " + name + "\t Health: " + health + "\t Mana: " + mana + "\t Element: " + currentElement);
	}
	public void ManaRegen()
	{
		int manaIncrease = dice.DFour();
		mana += manaIncrease;
		System.out.println("Amount of mana regenerated:" + manaIncrease + " mana.");
	}
	public void SetPlayerGuard()
	{
		guardLevel = dice.DTwelve();
	}
	public void PlayerRest()
	{
		int manaIncrease = dice.DFour() + dice.DFour() + dice.DFour() + dice.DFour() + dice.DFour();
		mana += manaIncrease;
		System.out.println("After 5 rolls of the four-sided die, your total mana increase is " + manaIncrease + " mana.");
	}
}		