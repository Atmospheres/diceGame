package diceGame;
import java.util.ArrayList;
import java.util.Scanner;
public class SetUpGame
{
	boolean gameActive = true;
	Player player = new Player();
	ArrayList<Player> playerList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	public SetUpGame()
	{
		gameActive = true;
		System.out.println("How many human players? (Max 4)");
		int input = scanner.nextInt();
		if(input > 0)
		{
			Human player1 = new Human();
			playerList.add(player1);
			input -= 1;
		}
		else
		{
			AI player1 = new AI();
			playerList.add(player1);
		}
		if(input > 0)
		{
			Human player2 = new Human();
			playerList.add(player2);
			input -= 1;
		}
		else
		{
			AI player2 = new AI();
			playerList.add(player2);
		}
		if(input > 0)
		{
			Human player3 = new Human();
			playerList.add(player3);
			input -= 1;
		}
		else
		{
			AI player3 = new AI();
			playerList.add(player3);
		}
	
		if(input > 0)
		{
			Human player4 = new Human();
			playerList.add(player4);
			input -= 1;
		}
		else
		{
			AI player4 = new AI();
			playerList.add(player4);
		}

		
	}
	//public PrintPlayerStats(){
	//	for()// each item in playerlist call ViewCurrentStats on that player
			
	//}
}

	