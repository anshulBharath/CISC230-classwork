package week06;

import java.util.ArrayList;

public class HistoryDie extends Die {

	protected ArrayList<Integer> history = new ArrayList<Integer>();
	
	public HistoryDie(int numSides) {
		super(numSides);
	}
	
	public int roll() {
		int num = super.roll();
		this.history.add(num);
		return num;
	}
	
	public ArrayList<Integer> getHistory(){
		return this.history;
	}

}
