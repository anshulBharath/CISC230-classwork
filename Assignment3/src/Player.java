import java.util.Scanner;

/**
 * This class represents the player contains all the scanning, except for in the driver
 * @author anshul_bharath
 *
 */
public class Player {
	
	
	/**
	 * name holds the string representation of the player's name
	 */
	private String name;
	
	/**
	 * diceSize hold the number of dice there are in the current set.
	 */
	private int diceSize;
	
	/**
	 * The constructor for the player object
	 * @param name
	 */
	private Scanner input = new Scanner(System.in);
	
	/**
	 * The constructor of player
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * This method gives the player a display of how many other players have been registered with the game master.
	 * @param num, the numbers of players playing
	 */
	public void recieveNumberOfPlayers(int num) {
		
		System.out.println("Player(s) in Game: " + num);
		
	}
	
	/**
	 * This method will give the essential info about the dice.
	 * The player will be given the number of dice there are and how many sides each die has
	 * @param diceInfo, an array with the numSides of each die
	 */
	public void reciveDiceInfo(int[] diceInfo) {
		int[] copy = copyArray(diceInfo);
		diceSize = copy.length;
		String dicePos = "";
		
		System.out.println("# of Dice in game: " + diceSize); // See the wording
		System.out.println("Die position and Side length: ");
		
		for(int i = 0; i < copy.length; i++) {
			dicePos = dicePos + "" + (i + 1) + ":(" +copy[i]+ ") ";
		}
		System.out.println("\t" + dicePos + "\n");
	}
	
	/**
	 * This method will ask the player if they want to guess the non repeating dice or not
	 * @return true if the player wants to guess and false if the player does not want to guess
	 */
	public boolean wantsToGuess() {
		String ans = "";
		
		System.out.print("Would you like to guess the postions of the non-repeating dice?(y/n): ");
		ans = input.nextLine();
		System.out.print("\n");
		
		if(ans.equalsIgnoreCase("y")) {
			return true;
		}
		
		if(ans.equalsIgnoreCase("n")) {
			return false;
		}
		
		System.out.print("\n");
		
		while(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) {
			System.err.println("You entered invalid input");
			System.out.print("Would you like to guess the positions of the non-repating dice?(y/n): ");
			ans = input.nextLine();
			
			if(ans.equalsIgnoreCase("y")) {
				return true;
			}
			
			if(ans.equalsIgnoreCase("n")) {
				return false;
			}
			System.out.print("\n");
		}
		
		return false;
	}
	
	/**
	 * When called, This method will ask the user to guess the first and second NonRepeating Dice
	 * @return guesses, an array of length 2 that consists an int of the users guessed positions
	 */
	public int[] guess() {
		int[] guesses = new int[2];
		
		System.out.print("Guess #1 of NonRepeating Dice(1-" + this.getNumDice() + "): ");
		guesses[0] = input.nextInt();
		
		while(guesses[0] <= 0 || guesses[0] > this.getNumDice()) {
			System.err.print("Invalid input! ");
			System.out.print("Guess #1 of NonRepeating Dice(1-" + this.getNumDice() + "): ");
			guesses[0] = input.nextInt();
		}
		
		System.out.print("Guess #2 of NonRepeating Dice(1-" + this.getNumDice() + "): ");
		guesses[1] = input.nextInt();
		
		
		while(guesses[1] <= 0 || guesses[1] > this.getNumDice()) {
			
			System.err.print("Invalid input! ");
			System.out.print("Guess #2 of NonRepeating Dice(1-" + this.getNumDice() + "): ");
			guesses[1] = input.nextInt();
		}
		System.out.println("");
		
		return guesses;
	}
	
	/**
	 * This method gives the results of the last roll
	 * @param results
	 */
	public void receiveRollResults(int[] results) {
		int[] copy = copyArray(results);
		
		System.out.println("Here are the results of the roll: ");
		System.out.print("\t");
		for(int i = 0; i < copy.length; i++) {
			System.out.print("" + (i + 1) + ":(" +copy[i] + ") ");
		}
		System.out.println("\n");
	}
	
	/**
	 * When called, this method will ask the user which dice positions they want to reroll
	 * @return rerolls, an array of boolean representations of the rerolling
	 */
	public boolean[] reroll() {
		String ans = "";
		boolean[] rerolls = new boolean[this.getNumDice()];
		
		if(this.WantsReRoll()) {
			for(int i = 0; i < rerolls.length; i++) {
				System.out.print("Would you like to roll Die #" + (i + 1) + "?(y/n): ");
				ans = input.nextLine();
				
				if(ans.equals("y")) {
					rerolls[i] = true;
				}
				else if(ans.equalsIgnoreCase("n")) {
					rerolls[i] = false;
				}
				else {
					while(!(ans.equalsIgnoreCase("y")) && !(ans.equalsIgnoreCase("n"))) {
						System.err.println("You entered invalid input");
						System.out.print("Would you like to roll Die #" + (i + 1) + "?(y/n): ");
						ans = input.nextLine();
						
						if(ans.equalsIgnoreCase("y")) {
							rerolls[i] = true;
						}
						
						if(ans.equalsIgnoreCase("n")) {
							rerolls[i] = false;
						}
						System.out.print("\n");
					}
				}
			}
			return rerolls;
		}
		else {
			return new boolean[1]; //needed to return some boolean, probably could've done this easier
		}
		
	}
	
	/**
	 * This method will ask the user if they want to reroll or not
	 * @return true, if they want to reroll or false, if not
	 */
	private boolean WantsReRoll() {
		String ans = "";
		
		System.out.print("Would you like the chance to reroll any of the dice?(y/n): ");
		ans = input.nextLine();
		System.out.print("\n");
		
		if(ans.equalsIgnoreCase("y")) {
			return true;
		}
		
		if(ans.equalsIgnoreCase("n")) {
			return false;
		}
		
		System.out.print("\n");
		
		while(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) {
			System.err.println("You entered invalid input");
			System.out.print("Would you like the chance to reroll any of the dice?(y/n): ");
			ans = input.nextLine();
			
			if(ans.equalsIgnoreCase("y")) {
				return true;
			}
			
			if(ans.equalsIgnoreCase("n")) {
				return false;
			}
			System.out.print("\n");
		}
		
		return false;
	}
	
	/**
	 * Returns the name of the player
	 * @return name, a string representation of the name
	 */
	public String getName() {
		return this.name;
	}
	
	public int[] copyArray(int[] array) {
		int[] copy = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		
		return copy;
	}
	
	/**
	 * Return the diceSize in player
	 * @return int size of dice
	 */
	private int getNumDice() {
		return this.diceSize;
	}
	

}
