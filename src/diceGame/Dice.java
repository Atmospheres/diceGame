package diceGame;

import java.util.concurrent.ThreadLocalRandom;



public class Dice
{	
	int dFour;
	int dSix;
	int dEight;
	int dTen;
	int dTwelve;
	int dTwenty;
	public int DFour()
	{
		dFour = ThreadLocalRandom.current().nextInt(1,5);
		return dFour;
	}
	public int DSix()
	{
		dSix = ThreadLocalRandom.current().nextInt(1,7);
		return dSix;
	}
	public int DEight()
	{
		dEight = ThreadLocalRandom.current().nextInt(1,9);
		return dEight;
	}
	public int DTen()
	{
		dTen = ThreadLocalRandom.current().nextInt(1,11);
		return dTen;
	}
	public int DTwelve()
	{
		dTwelve = ThreadLocalRandom.current().nextInt(1,13);
		return dTwelve;
	}
	public int DTwenty()
	{
		dTwenty = ThreadLocalRandom.current().nextInt(1,21);
		return dTwenty;
	}
	public void RollDice()
	{
		DFour();
		DSix();
		DEight();
		DTen();
		DTwelve();
		DTwenty();
	}
}