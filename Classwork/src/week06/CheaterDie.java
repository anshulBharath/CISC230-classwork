package week06;

import java.util.Random;

public class CheaterDie extends HistoryDie{
	
	//private int cheatNum = 0;
	
	public CheaterDie(int numSides) {
		super(numSides);
	}
	
	public int roll() {
		
		Random rand = new Random();
		if(rand.nextInt(10) == 0) {
			
			super.history.add(getNumSides());
			return super.getNumSides();
		}
		return super.roll();
		
	}
	
}
