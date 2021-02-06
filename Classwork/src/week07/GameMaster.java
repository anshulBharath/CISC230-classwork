package week07;

import java.util.ArrayList;
import java.util.Random;

public class GameMaster {
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public GameMaster() {
	}
	
	public void registerPlayer(Player curPlayer) {
		this.players.add(curPlayer);
	}
	
	private int[] createCopy(int[] org) {
		int[] copy = new int[org.length];
		
		for(int i = 0; i < org.length; i++) {
			copy[i] =org[i];
		}
		
		return copy;
	}
	
	private void broadCastResults() {
		int[] randNums = new int[7];

		
		Random rand = new Random();
		
		for(int i = 0; i < randNums.length; i++) {
			randNums[i] = rand.nextInt(10) + 1;
		}
		
		
		for(int j = 0; j < this.players.size(); j++) {
			int[] temp = createCopy(randNums);
			players.get(j).receiveRollResults(temp);
		}	
	}
	
	public void playGame() {
		broadCastResults();
		
	}
	
	


}
