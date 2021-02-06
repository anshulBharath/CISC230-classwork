import java.util.Random;

/**
 * This class represents an automated player.
 * It is not as smart as it could be, but I believe it should work without crashing
 * @author anshul_bharath
 *
 */
public class AutomatedPlayer extends Player {
	
	/**
	 * The number of players that are in the game
	 */
	private int numPlayers;
	/**
	 * Info of the dice that was rolled
	 */
	private int[] diceInfo;
	
	/**
	 * The random object that will be used to make choices
	 */
	private Random rand;
	
	/**
	 * The size of the set that will be used
	 */
	private int diceSize;
	
	/**
	 * The results of the current roll
	 */
	private int[] curRoll;

	public AutomatedPlayer(String name) {
		super(name);
		rand = new Random();
	}
	
	/**
	 * Recieves the number of players and saves the num players
	 */
	public void recieveNumberOfPlayers(int num) {
		super.recieveNumberOfPlayers(num);
		numPlayers = num;
	}
	
	/**
	 * Receives the info of the dice and saves it
	 * @param results
	 */
	public void recieveDiceInfo(int[] results) {
		super.reciveDiceInfo(results);
		this.diceInfo = this.createCopy(results);
		this.diceSize = this.diceInfo.length;
	}
	
	/**
	 * This method will randomly choose to guess or not
	 */
	public boolean wantsToGuess(){
		int num = rand.nextInt(4);
		
		if(num == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This method will return an int array with random guesses of the nrpdices
	 *  
	 */
	public int[] guess() {
		int[] guesses = new int[2];
		
		guesses[0] = rand.nextInt(this.diceSize + 1) + 1;
		guesses[1] = rand.nextInt(this.diceSize + 1) + 1;
		
		System.out.println("Automated Player Guessed");
		return guesses;
	}
	
	/**
	 * This method will allow the player to receive the results of the roll.
	 */
	public void receiveRollResults(int[] results) {
		super.receiveRollResults(results);
		curRoll = this.copyArray(results);
	}
	
	/**
	 * This method will allow the automated player to choose which dice to roll
	 * @return rerolls, a boolean array that will hold all the dice that the automated player wants to reroll
	 */
	public boolean[] reroll() {
		boolean[] rerolls = new boolean[this.diceSize];
		
		if(this.decideYesOrNo()) {
			for(int i = 0; i < this.diceSize; i++) {
				rerolls[i] = this.decideYesOrNo();
			}
			return rerolls;
		}
		else {
			return new boolean[1];
		}
	}
	
	/**
	 * Gets the name of the automated player
	 * @return the name of the player
	 */
	public String getName() {
		return super.getName();
	}
	
	/**
	 * A helper method to choose.
	 * Will choose true 5 out of 6 times
	 * @return
	 */
	private boolean decideYesOrNo() {
		int num = rand.nextInt(6);
		
		if(num == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * Creates a copy of the int array 
	 * @param org
	 * @return
	 */
	private int[] createCopy(int[] org) {
		int[] copy = new int[org.length];
		
		for(int i = 0; i < copy.length; i++) {
			copy[i] = org[i];
		}
		
		return copy;
	}

}
