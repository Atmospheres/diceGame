package diceGame;
import java.util.List;
import java.util.Scanner;


public class diceGame
{
	public static void main(String[] args)
	{
		
		SetUpGame game = new SetUpGame();
		game.PlayerSetup();
		game.SetPlayerName();
		game.PrintAllStats();
		game.Match();
	}
}

