package week06;

import java.util.ArrayList;
import java.util.Random;

public class DieDriver {

	public static void main(String[] args) {
		
		ArrayList<Die> dice = new ArrayList<Die>();
		Random rand = new Random();
		
		for(int x = 0; x < 5; x++) {
			int num = rand.nextInt(3);
			if(num == 0) {
				dice.add(new HistoryDie(6));
			}
			else {
				dice.add(new CheaterDie(6));
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(Die x: dice) {
				System.out.println(x.roll() + "  ");
			}
			System.out.println();
		}
		
		/*CheaterDie die1 = new CheaterDie(7);
		
		for(int i = 0; i < 100; i ++) {
			System.out.print(i + 1 + ") " + die1.roll() + ", ");
		}
		ArrayList<Integer> history  = die1.getHistory();
		
		System.out.println();
		for(int j = 0; j < history.size(); j ++) {
			System.out.print(j + 1 + ") " + history.get(j) + ", ");
		}*/
		
		
	
		

		

	}

}
