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
				while(game.gameActive ==  true)
		{
			
		
		
		
		for(int i =0; i < 4; i++)
		{
			System.out.println(game.playerList.get(i).currentElement);
		
		}
		}
	}
}

