package week07;

public class Sawin extends Player{
	
	public Sawin() {
		super("Sawin");
	}
	
	public void receiveRollResults(int[] results) {
		super.receiveRollResults(results);
		
		for(int i = 0; i < results.length; i++) {
			results[i] = results[i] - 60;
		}
	}

}
