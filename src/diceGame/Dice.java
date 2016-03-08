package diceGame;

import java.util.concurrent.ThreadLocalRandom;

public class Dice
{
	

	public int DFour()
	{
		int dFour = ThreadLocalRandom.current().nextInt(1,5);
		return dFour;
	}
	public int DSix()
	{
		int dSix = ThreadLocalRandom.current().nextInt(1,7);
		return dSix;
	}
	public int DEight()
	{
		int dEight = ThreadLocalRandom.current().nextInt(1,9);
		return dEight;
	}
	public int DTen()
	{
		int dTen = ThreadLocalRandom.current().nextInt(1,11);
		return dTen;
	}
	public int DTwelve()
	{
		int dTwelve = ThreadLocalRandom.current().nextInt(1,13);
		return dTwelve;
	}
	public int DTwenty()
	{
		int dTwenty = ThreadLocalRandom.current().nextInt(1,21);
		return dTwenty;
	}
}