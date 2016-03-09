package diceGame;

public class Player
{
	
	String name;
	String currentElement;
	int health;
	int mana;
	boolean isHuman;
	
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
	
	
	
}
