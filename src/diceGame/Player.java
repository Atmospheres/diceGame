package diceGame;

public class Player
{
	Dice dice = new Dice();
	
	String name;
	String currentElement = SetPlayerElement();
	int health;
	int guardLevel = SetPlayerGuard();
	int mana;
	int playerNumber;
	int element;
	boolean isHuman;
	int dFour;
	int dSix;
	int dEight;
	int dTen;
	int dTwelve;
	int dTwenty;	
	
	public Player()
	{
		health = 50;
		mana = 20;
		isHuman = true;
		RollDice();	
	}
	
	public void ViewCurrentStats()
	{
		System.out.println("Name: " + name + "\t Health: " + health + "\t Mana: " + mana + "\t Guard: " + SetPlayerGuard() + "\t Element: " + SetPlayerElement());
	}
	public void ManaRegen()
	{
		int manaIncrease = dFour;
		mana += manaIncrease;
		System.out.println("Amount of mana regenerated:" + manaIncrease + " mana.");
	}
	public void PlayerRest()
	{
		int manaIncrease = dice.DFour() + dice.DFour();
		mana += manaIncrease;
		System.out.println("After 2 rolls of the four-sided die, your total mana increase is " + manaIncrease + " mana.");
	}
	public int SetPlayerGuard()
	{
		guardLevel = dTen;
		return guardLevel;
	}
	public String SetPlayerElement()
	{
			element = dSix;
			switch(element)
			{
				case 1:
					currentElement = "Fire";
					break;
				case 2:
					currentElement = "Ice";
					break;
				case 3:
					currentElement = "Wind";
					break;
				case 4:
					currentElement = "Earth";
					break;
				case 5:
					currentElement = "Lightning";
					break;
				case 6:
					currentElement = "Water";
					break;
				default:
					currentElement = "Fire";
					break;
			}
			return currentElement;
	}
	public void RollDice()
	{
		dFour = dice.DFour();
		dSix = dice.DSix();
		dEight = dice.DEight();
		dTen = dice.DTen();
		dTwelve = dice.DTwelve();
		dTwenty = dice.DTwenty();
	}
}	
