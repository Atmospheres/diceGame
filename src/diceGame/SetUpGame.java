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
		System.out.println("How many Player players? (Max 4)");
		int input = scanner.nextInt();
		if(input > 0)
		{
			Player player1 = new Player();
			playerList.add(player1);
			player1.SetPlayerElement();
			input -= 1;
		}
		else
		{
			AI player1 = new AI();
			playerList.add(player1);
			player1.SetPlayerElement();
		}
		if(input > 0)
		{
			Player player2 = new Player();
			playerList.add(player2);
			input -= 1;
			player2.SetPlayerElement();
		}
		else
		{
			AI player2 = new AI();
			playerList.add(player2);
			player2.SetPlayerElement();
		}
		if(input > 0)
		{
			Player player3 = new Player();
			playerList.add(player3);
			input -= 1;
			player3.SetPlayerElement();
		}
		else
		{
			AI player3 = new AI();
			playerList.add(player3);
			player3.SetPlayerElement();
		}
	
		if(input > 0)
		{
			Player player4 = new Player();
			playerList.add(player4);
			input -= 1;
			player4.SetPlayerElement();
		}
		else
		{
			AI player4 = new AI();
			playerList.add(player4);
			player4.SetPlayerElement();
		}
	}
		
	
	
		public void SetPlayerName()
		{
			scanner.nextLine();
			for(int i = 0; i < 4; i++)
			{	
				int playerNumber = i+1;
				System.out.println("Please enter a name for player " + playerNumber + ":" );
				String name = scanner.nextLine();
				playerList.get(i).name = name;
		
			}
		}  
	
	//public PrintPlayerStats(){
	//	for()// each item in playerlist call ViewCurrentStats on that player
			
	//}
}

	