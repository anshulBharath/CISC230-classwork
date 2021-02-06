package week10;

import java.util.Random;

public class MyResults implements Resultable{

	private int[] results;
	private Random rand;
	
	public MyResults() {
		rand = new Random();
		int size = rand.nextInt(6) + 5;
		
		results = new int[size];
		
		for(int i = 0; i < results.length; i++) {
			int temp = rand.nextInt(101);
			results[i] = temp;
		}
	}
	
	private MyResults(MyResults other) {
		this.results = new int[other.results.length];
		for(int i = 0; i < this.results.length; i++) {
			this.results[i] = other.results[i];
		}
	}
	
	public int[] getResults() {
		return results;
	}

	public Resultable copy() {
		MyResults copy = new MyResults(this);
		return copy;
	}

}
