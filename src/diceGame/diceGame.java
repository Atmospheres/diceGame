package diceGame;
import java.util.List;
import java.util.Scanner;


public class diceGame
{
	public static void main(String[] args)
	{
		int inputInt;
		SetUpGame game = new SetUpGame();
		Scanner scanner = new Scanner(System.in);
		Player player = new Player();
		Dice dice = new Dice();
		//while(game.gameActive ==  true)
		//{
		game.PlayerSetup();
		game.SetPlayerName();
		game.PrintAllStats();

		dice.RollDice();
		
		System.out.println(dice.dFour);
		
		
	/*	for(int i =0; i < 4; i++)
		{
			System.out.println(game.playerList.get(i).currentElement);
			System.out.println(game.playerList.get(i).name);
		}
*/		//}
	}
}

