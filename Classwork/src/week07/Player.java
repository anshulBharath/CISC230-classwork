package week07;

public class Player {
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void receiveRollResults(int[] results) {
		System.out.println(this.name + ":\n\t");
		for(int i = 0; i < results.length; i++) {
			System.out.print(i + 1 + ") " +results[i] + " ");
		}
		System.out.println("\n");
	}

}
