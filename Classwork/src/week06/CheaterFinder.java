package week06;

import java.util.ArrayList;

public class CheaterFinder {
	
	public boolean isCheater(Die die) {
		int[] resultTally = new int [die.getNumSides()];
		
		for(int i = 0; i < resultTally.length; i++) {
			resultTally[i] = 0;
		}
		
		
		
		for(int j = 0; j < 100000; j++) {
			resultTally[die.roll() - 1] ++;
		}
		
		double ratio = 1.0/die.getNumSides();
		
		for(int i = 0; i < resultTally.length; i++) {
			System.out.println(resultTally[i]/100000.0);
		}
		
		return true;
		
	}
}
