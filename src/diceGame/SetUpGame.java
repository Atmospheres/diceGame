package diceGame;
import java.util.ArrayList;
import java.util.Scanner;
public class SetUpGame
{
	boolean gameActive = true;
	Player player = new Player();
	ArrayList<Player> playerList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	Dice dice = new Dice();

	public SetUpGame()
	{
		
	}
	
	public  void PlayerSetup()
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
			player2.SetPlayerElement();
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
			player3.SetPlayerElement();
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
			player4.SetPlayerElement();
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
				int playerNumber = i + 1;
				System.out.println("Please enter a name for player " + playerNumber + ": ");
				String name = scanner.nextLine();
				playerList.get(i).name = name;
			}
		}  
		public void PrintRules()
		{
			System.out.println("All the Game Rules!!!");
		}
		
		public void PrintAllStats()
		{
			for( int i = 0; i < 4; i++)
			{
			playerList.get(i).ViewCurrentStats();
			}
		}
		public void Match()
		{
			while(playerList.size() > 1)
			{
				this.Turn();
			}
			if(playerList.size() == 1){
				System.out.println("Game Over!");
			}
				
		}
		public void Turn()
		{
			
			for(int i = 0; i < playerList.size(); i++)
			{
				playerList.get(i).dice.RollDice();
				ReportDice(i);				
			}
			
		}
		
		public void ReportDice(int I)
		{
			int i = I;
			System.out.println("Player " + playerList.get(i).name + " rolled:");
			System.out.println("D4: " + dice.dFour);
			System.out.println("D6: " + dice.dSix);
			System.out.println("D8: " + dice.dEight);
			System.out.println("D10: " + dice.dTen);
			System.out.println("D12: " + dice.dTwelve);
			System.out.println("D20: " + dice.dTwenty);
		}

	//public PrintPlayerStats(){
	//	for()// each item in playerlist call ViewCurrentStats on that player
			
	//}
}

	