package diceGame;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SetUpGame
{
	boolean gameActive = true;
	int turn;
	int input;
	Player player = new Player();
	ArrayList<Player> playerList = new ArrayList<>();
	ArrayList<Integer> targetList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	public SetUpGame()
	{
		turn = 1;
	}
	
	public  void PlayerSetup()
	{
		System.out.println("How many Human players? (Max 4)");
		input = scanner.nextInt();
		if(input > 0)
		{
			Player player1 = new Player();
			playerList.add(player1);
			SetDiceValue(0);
			input -= 1;
		}
		else
		{
			Player player1 = new Player();
			playerList.add(player1);
			SetDiceValue(0);
			player1.isHuman = false;
		}
		if(input > 0)
		{
			Player player2 = new Player();
			playerList.add(player2);
			SetDiceValue(1);
			input -= 1;
		}
		else
		{
			Player player2 = new Player();
			playerList.add(player2);
			SetDiceValue(1);
			player2.isHuman = false;
		}
		if(input > 0)
		{
			Player player3 = new Player();
			playerList.add(player3);
			SetDiceValue(2);
			input -= 1;
		}
		else
		{
			Player player3 = new Player();
			playerList.add(player3);
			SetDiceValue(2);
			player3.isHuman = false;


		}
	
		if(input > 0)
		{
			Player player4 = new Player();
			playerList.add(player4);
			SetDiceValue(3);
			input -= 1;
		}
		else
		{
			Player player4 = new Player();
			playerList.add(player4);
			SetDiceValue(3);
			player4.isHuman = false;
		}	
		SetPlayerName();
	}

		public void SetPlayerName()
		{
			scanner.nextLine();
			for(int i = 0; i < 4; i++)
			{
				System.out.println("Please enter a name for player " + (i + 1) + ": ");
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
			System.out.println();
			for(int i = 0; i < playerList.size(); i++)
			{
				playerList.get(i).ViewCurrentStats();
			}
			System.out.println();
		}
		public void Match()
		{
			PlayerSetup();
			while(playerList.size() > 1)
			{		
				this.Turn();
			}
			EndMatch();			
		}
		public void Turn()
		{
			for(int i = 0; i < playerList.size(); i++)
			{
				PrintAllStats();
				System.out.println(playerList.get(i).name + "'s turn.");			
				System.out.println("");
				playerList.get(i).RollDice();
				SetDiceValue(i);
                ReportDice(i);
				SetTargetList(i);
				CheckHuman(i);
                EndTurn();
			}
		}	
		public void CheckHuman(int i)
		{
			 if(playerList.get(i).isHuman == true)
             {
                 PlayerChoice(i);                
             }			
             else
             {
             	AIChoice(i);
             }
		}
		public void SetTargetList(int i)
		{
            System.out.println("What would you like to do?");
            System.out.println("1: Rest" );
			
			if(playerList.get(i).mana >= playerList.get(i).dTwelve)
			{
				
				int options = 2;
				for(int j = 0; j < playerList.size(); j++)
				{
					if(i != j)
					{
						System.out.println(options + ": Attack " + playerList.get(j).name);
						targetList.add(j);
						options += 1;
					}    
				}
            }
		}

		public void PlayerChoice(int i)
		{
			if(playerList.get(i).mana >= playerList.get(i).dTwelve)
			{
				int	inputInt = scanner.nextInt();
				switch(inputInt)
				{
	                case 1:
	                    playerList.get(i).PlayerRest();
	                    break;
	                case 2:
	                    Attack(targetList.get(0), i);
	                    break;
	                case 3:
	                    Attack(targetList.get(1), i);
	                    break;
	                case 4:
	                    Attack(targetList.get(2), i);
	                    break;
	                default:
	                    break;
				}
			}
			else
			{
	            int	inputInt = scanner.nextInt();
	            switch(inputInt)
	            {
	               case 1:
	            	   playerList.get(i).PlayerRest();
	            	   break;
	               default:
	            	   break;
	            }				
			}
		}
		public void AIChoice(int i)
		{
			if(playerList.get(i).mana >= playerList.get(i).dTwelve)
			{
				int	inputInt = ThreadLocalRandom.current().nextInt(1, targetList.size() + 2);
				switch(inputInt)
				{
	                case 1:
	                    playerList.get(i).PlayerRest();
	                    break;
	                case 2:
	                    Attack(targetList.get(0), i);
	                    break;
	                case 3:
	                    Attack(targetList.get(1), i);
	                    break;
	                case 4:
	                    Attack(targetList.get(2), i);
	                    break;
	                default:
	                    break;
				}
			}
			else
			{
				playerList.get(i).PlayerRest();
			}
		}
		public void EndTurn()
		{
			turn += 1;
			targetList.removeAll(targetList);
		}	
		public void ReportDice(int I)
		{
			int i = I;
			System.out.println("Turn: " + turn);
			System.out.println("Player " + playerList.get(i).name + " rolled:");
			System.out.println("Mana Regen(D4): " + playerList.get(i).dFour);
			System.out.println("Element(D6): " + playerList.get(i).currentElement + "(" + playerList.get(i).dSix + ")");
			System.out.println("Mulitplier(D8): " + playerList.get(i).dEight);
			System.out.println("Guard(D10): " + playerList.get(i).dTen);
			System.out.println("Attack Cost(D12): " + playerList.get(i).dTwelve);
			System.out.println("Attack Damage(D20): " + playerList.get(i).dTwenty);
		}
		public void Attack(int TargetIndex, int PlayerIndex)
		{
			CalculateCritical(TargetIndex, PlayerIndex);
			CalculateElemental(TargetIndex, PlayerIndex);
			if (playerList.get(TargetIndex).guardLevel > playerList.get(PlayerIndex).dTwenty)
			{
				playerList.get(TargetIndex).guardLevel = playerList.get(PlayerIndex).dTwenty;
			}
			playerList.get(TargetIndex).health -= playerList.get(PlayerIndex).dTwenty - playerList.get(TargetIndex).guardLevel;
			playerList.get(PlayerIndex).mana -= playerList.get(PlayerIndex).dTwelve;
			SetDeath(TargetIndex);
		}	
		public void SetDeath(int TargetIndex)
        {
            if (playerList.get(TargetIndex).health <= 0)
            {
                System.out.println();
                System.out.println(playerList.get(TargetIndex).name + " has been defeated!");
                playerList.remove(TargetIndex);
            }
        }
		public void CalculateCritical(int TargetIndex, int PlayerIndex)
		{
			if (playerList.get(PlayerIndex).dEight == playerList.get(PlayerIndex).dSix)
			{
				playerList.get(PlayerIndex).dTwenty *= 2;
			}
		}
		public void CalculateElemental(int TargetIndex, int PlayerIndex)
		{
			if(playerList.get(PlayerIndex).element == playerList.get(TargetIndex).element - 1 || 
					playerList.get(PlayerIndex).element == 6 && playerList.get(TargetIndex).element == 1)
			{
				playerList.get(PlayerIndex).dTwenty *= 2;
			}
			else if(playerList.get(PlayerIndex).element == playerList.get(TargetIndex).element + 1 ||
					playerList.get(PlayerIndex).element == 1 && playerList.get(TargetIndex).element == 6)
			{
				playerList.get(PlayerIndex).dTwenty /= 2;
			}
		}
		public void SetDiceValue(int PlayerIndex)
		{
			playerList.get(PlayerIndex).guardLevel = playerList.get(PlayerIndex).SetPlayerGuard();
			playerList.get(PlayerIndex).currentElement = playerList.get(PlayerIndex).SetPlayerElement();
		}
		public void EndMatch()
		{
			System.out.println();
			System.out.println("Congratulations " + playerList.get(0).name + ", you won!");
		}
}