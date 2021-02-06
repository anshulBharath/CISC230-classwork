import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class represents the GameMaster and will be in charge of running the game. 
 * This class will be the middle man between the dice and the players, avoiding any cheating (hopefully)
 * @author anshul_bharath
 *
 */
public class GameMaster {
	
	/**
	 * The score to reach for without going over
	 */
	private final int winningScore = 200;
	
	/**
	 * A list of the player objects
	 */
	private ArrayList<Player> players;
	
	/**
	 * The set of dice that will be handled through the game.
	 */
	private ArrayList<Die> dice;
	
	/**
	 * An associated array that holds the scores of each of the players
	 */
	private ArrayList<Integer> scores;
	
	/**
	 * 
	 */
	private ArrayList<Boolean> playerHasGuessed;
	
	/**
	 * An array the holds the current roll values for each of the die
	 */
	private int[] curDiceValues;
	
	/**
	 * The locations of the two nonRepeating dice stored in an array
	 */
	private int[] nrpLocations = new int[2];
	
	/**
	 * The random object that will create the random number of dice and the random number of sides for each of the die 
	 */
	private Random rand = new Random();
	
	public GameMaster() {
		
		//An instantiation of the dice arrayList and the associated arrays
		this.dice = new ArrayList<Die>();
		
		this.players = new ArrayList<Player>();
		this.scores = new ArrayList<Integer>();
		this.playerHasGuessed = new ArrayList<Boolean>();
	}
	
	
	/**
	 * Registers the player with the gamemaster - puts the player into an arraylist
	 * @param curPlayer
	 */
	public void registerPlayer(Player curPlayer) {
		this.players.add(curPlayer);
		this.scores.add(0);
		this.playerHasGuessed.add(false);
	}
	
	/**
	 * When called, this method will play the game.
	 */
	public void playGame() {
		//broadCastResults();
		
		int round = 1; //Keep track of the current round
		int curPlayer = 0; //The index of the current player
		
		boolean playerHasWonByGuess = false; //maybe change this to get a method from GM
		boolean playerHasWonByRoll = false; //change to get a method 
		
		this.createDiceSet(); //The dice set that will be used for the current iteration of the game. Stored in the arraylist
		
		while(round <= 5 && !playerHasWonByRoll && !playerHasWonByGuess){
			while(curPlayer < players.size() && !playerHasWonByRoll && !playerHasWonByGuess) {
				System.out.println(" \n\n");
				
				this.broadcastSeparator(); //Will separate different players
				
				this.broadcastRound(round);
				this.broadcastPlayerBox(players.get(curPlayer), round);
				this.broadcastDiceInfo(players.get(curPlayer));
				
				if(!this.playerHasGuessed.get(curPlayer)) { //This will check whether the player has already guessed or not
					if(this.broadcastsWantsToGuess(players.get(curPlayer))) {
						if(this.checkIfWonByGuess(curPlayer)) {
							playerHasWonByGuess = true; 
						}
						else {
							this.playerHasGuessed.set(curPlayer, true);
							this.broadcastLoserRoll(players.get(curPlayer));
						}
					} //end of guess dialogue if statement. Will either have a winner or set the player guess at curPlayer to true
					
					if(!playerHasWonByGuess && !this.playerHasGuessed.get(curPlayer)) {
						playerHasWonByRoll = this.broadcastRoll(players.get(curPlayer)); //will be true or false
						this.broadCastWonByRoll(playerHasWonByRoll, curPlayer);
					}
				}
				else {
					this.broadcastLoserRoll(players.get(curPlayer)); //Broadcast this when the player has already guessed
				}
		
				this.broadcastSeparator(); //Will separate different players
				
				curPlayer = curPlayer + 1; //moves the counter to next player
				
			} //end of player loop
			
			this.broadcastAllScores(round);
			curPlayer = 0;
			round = round + 1;
			
		} //end of round loop
		
		if((!playerHasWonByRoll && !playerHasWonByGuess)) {
			this.broadcastWonByScore();
		}
	}
	
	/**
	 * Creates a die with a random number of sides
	 * @return the die object that was created
	 */
	private Die createRandomDice() {
		int numSides = rand.nextInt(9) + 3;
		return new Die(numSides);
	}

	/**
	 * Add the nonRepeating die and calss the addRepeating die to complete the set
	 */
	private void createDiceSet() {
		int numSides1 = rand.nextInt(9) + 3;
		int numSides2 = rand.nextInt(9) + 3;
		
		NonRepeatingDie die1 = new NonRepeatingDie(numSides1);
		NonRepeatingDie die2 = new NonRepeatingDie(numSides2);
		
		dice.add(die1);
		dice.add(die2);
		addRepeatingDie();
		Collections.shuffle(dice);
		
		this.nrpLocations[0] = this.dice.indexOf(die1) + 1;
		this.nrpLocations[1] = this.dice.indexOf(die2) + 1;
		this.curDiceValues = new int[this.dice.size()];
		
		
	}
	
	/**
	 * adds the repeating die to the dice list
	 */
	private void addRepeatingDie() {
		int numRepeatingDie = rand.nextInt(6) + 2;
		
		for(int i = 0; i < numRepeatingDie; i++) {
			dice.add(createRandomDice());
		}
	}
	
	
	/**
	 * This method will broadcast a player info box for the player
	 * This info box will consist of the player name, score, players in the game and the round # during each turn
	 * @param player
	 * @param round
	 */
	private void broadcastPlayerBox(Player player, int round) {
		this.broadcastName(player);
		this.broadcastScore(player);
		this.broadcastNumPlayers(player);
		System.out.println("Round: " + round );
		System.out.println("----------------------\n");
	}
	
	/**
	 * This method will broadcast the number of players in the game
	 * @param player
	 */
	private void broadcastName(Player player) {
		System.out.println("----------------------");
		System.out.println("Name: " + player.getName());
	}
	
	/**
	 * This method will broadcast the score of the current player
	 * @param player
	 */
	private void broadcastScore(Player player) {
		int score = this.scores.get(this.getPlayerIndex(player));
		
		System.out.println("Score: " + score);
	}
	
	/**
	 * This method will broadcast the score of the current player when they roll or reroll
	 * @param player
	 */
	private void broadcastRollScore(Player player) {
		int score = this.scores.get(this.getPlayerIndex(player));
		
		System.out.println("Score after Roll/Reroll: " + score + "\n");
	}
	
	/**
	 * This method will broadcast all the scores of the players
	 * @param round
	 */
	private void broadcastAllScores(int round) {
		String ret = "";
		
		ret = "\nPlayer Scores After Round: " + round + "\n";
		for(int i = 0; i < this.scores.size(); i++) {
			ret = ret + this.players.get(i).getName() + ": " + this.scores.get(i) +"\n";
		}
		System.out.println(ret);
	}
	
	/**
	 * This method will broadcast the number of players registered to all the players
	 */
	private void broadcastNumPlayers(Player player) {
		player.recieveNumberOfPlayers(players.size());
	}
	
	/**
	 * This method will broadcast the current round with some formating
	 * @param round
	 */
	private void broadcastRound(int round) {
		System.out.println("\t\t\t\t\tRound: " + round);
		System.out.println("\t\t\t\t_________________________"); //To make the output easier to read
	}
	
	/**
	 * This method will broadcast the diceInfo to a specified player
	 * @param player
	 */
	private void broadcastDiceInfo(Player player) {
		int[] diceInfo = new int[this.dice.size()];
		
		for(int i = 0; i < diceInfo.length; i++) {
			diceInfo[i] = dice.get(i).getNumSides();
		}
		
		player.reciveDiceInfo(diceInfo);
	}
	
	
	/**
	 * This method broadcast a safe roll to the player. This method will return
	 * @return true, if the player rolls a winning set of dice
	 */
	private boolean broadcastRoll(Player player) {
		int[] roll = this.getSafeRoll(player);
		player.receiveRollResults(roll);
		this.broadcastRollScore(player);
		
		if(this.allTheSameValue(roll)) {
			System.out.println("YOU WON!!! The Dice had all had the same values!\n");
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This method will broadcast the dialogue to the player, if they have already guessed the nrp dice and guessed wrong
	 * @param player
	 */
	private void broadcastLoserRoll(Player player) {
		int[] rollResults = new int[dice.size()];
		
		for(int i = 0; i < this.dice.size(); i++) {
			rollResults[i] = this.dice.get(i).roll();
		}
		player.receiveRollResults(rollResults);
		System.err.println("\nYou have already attempted a guess, so this roll will not count toward your score\n");
	}
	
	/**
	 * This method will broadcast the dialogue for wanting to guess
	 * @param player
	 * @return true, if the player wants to guess and false if they do not
	 */
	private boolean broadcastsWantsToGuess(Player player) {
		return player.wantsToGuess(); //This will return true or false
	}
	
	/**
	 * THis method will broadcast the dialogue for the guesses.
	 * @param player
	 * @return guessResults, an array of ints that holds the player's guess of the position of the NonRepeating dice
	 */
	private int[] broadcastGuess(Player player) {
		int[] guessResults = player.guess();// This will return an array of guesses
		return guessResults;
	}
	
	
	/**
	 * This method will broadcast the dialogue for initiate a reroll then reroll the specified positions
	 * @param player
	 * @return an array of boolean that correlate with the 
	 */
	private boolean broadcastReroll(Player player) {
		boolean[] rerolls = this.createCopy(player.reroll());
		int[] rollResults = new int[this.curDiceValues.length];
		
		while(rerolls.length > 1) {
			for(int i = 0; i < this.curDiceValues.length; i++) {
				if(rerolls[i]) {
					this.scores.set(this.getPlayerIndex(player), this.scores.get(this.getPlayerIndex(player)) - this.curDiceValues[i]); //Subtracts the existing dice value, so the reroll does not count twice
					this.curDiceValues[i] = this.dice.get(i).roll();
					this.scores.set(this.getPlayerIndex(player), this.scores.get(this.getPlayerIndex(player)) + this.curDiceValues[i]);
				}
				else {
					this.curDiceValues[i] = this.curDiceValues[i];
				}
			}
			rollResults = this.createCopy(curDiceValues);
			player.receiveRollResults(rollResults);
			this.broadcastRollScore(player);
			
			if(this.allTheSameValue(rollResults)) {
				System.out.println("YOU WON!!! The Dice had all the same values!\n");
				return true;
			}
			else {
				rollResults = new int[0]; //Used to get out of the while loop
				return false;
			}
			
		}
		return false;
	}
	
	
	/**
	 * Helper method for the roll method. This function will ensure that aliasing does not occur
	 * @return rollResults, an array of the roll results
	 */
	private int[] getSafeRoll(Player player) {
		int[] rollResults;
		
		for(int i = 0; i < this.curDiceValues.length; i++) {
			this.curDiceValues[i] = this.dice.get(i).roll();
			this.scores.set(this.getPlayerIndex(player), this.scores.get(this.getPlayerIndex(player)) + this.curDiceValues[i]);
		}
		
		rollResults = this.createCopy(this.curDiceValues);
		
		return rollResults;
	}	

	/**
	 * This method prints out a separator. Used to make the output look a little cleaner
	 */
	private void broadcastSeparator() {
		System.out.println("__________________________________________________________________________________________");
	}
	
	/**
	 * Get the index of the player in the arraylist
	 * @param player
	 * @return and int representation of the index
	 */
	private int getPlayerIndex(Player player) {
		return players.indexOf(player);
	}
	
	/**
	 * This method will check to see if the players guesss were right
	 * @param curPlayer
	 */
	private boolean checkIfWonByGuess(int curPlayer) {
		int[] Guesses = this.createCopy(this.broadcastGuess(players.get(curPlayer)));
		if((Guesses[0] == this.nrpLocations[0] || Guesses[0] == this.nrpLocations[1]) && (Guesses[1] == this.nrpLocations[0] || Guesses[1] == this.nrpLocations[1])) {
			System.out.println("You Won! The game is over");
			return true;
		}
		else {
			System.out.println("Game over! Your Guesses Were Incorrect.");
			System.out.println("You will have to continue to play without the chance of winning :(\n");
			this.playerHasGuessed.set(curPlayer, true);
			return false;
		}
	}
	
	/**
	 * This method will ouptut the dialogue when a player wins by roll or reroll 
	 * @param playerHasWonByRoll
	 * @param curPlayer
	 */
	private void broadCastWonByRoll(boolean playerHasWonByRoll, int curPlayer) {
		if(playerHasWonByRoll) {
			System.out.println("The game is over. " + players.get(curPlayer).getName() + " has won the game.\n");
		}
		else {
			
			playerHasWonByRoll = this.broadcastReroll(players.get(curPlayer));
			
			if(playerHasWonByRoll) {
				System.out.println("The game is over. " + players.get(curPlayer).getName() + " has won the game.\n");
			}
		}
	}
	
	/**
	 * This method will broadcast the winner by score or it will declare a draw
	 */
	private void broadcastWonByScore() {
		String ret = "";
		int playerScores[] = this.createCopy(this.scores);
		int maxScore = 0;
		String winningPlayer = "";
		
		this.broadcastSeparator();
		
		for(int i = 0; i < playerScores.length; i++) {
			if(playerScores[i] >= maxScore && playerScores[i] <= this.winningScore && !this.playerHasGuessed.get(i)) {
				winningPlayer = this.players.get(i).getName();
				maxScore = playerScores[i];
			}
		}
		
		if(winningPlayer.length() == 0) {
			ret = ret + "There was a draw. No Players Won!";
		}
		else{
			ret = ret + winningPlayer + " won the game with a score of "+ maxScore + "\n";
		}
		System.out.println(ret);
		
	}
	
	/**
	 * This method check to see if the passed array has all the same values.
	 * Used to declare winner by roll
	 * 
	 * @param dice
	 * @return true, if all the values are the same.
	 */
	private boolean allTheSameValue(int[] dice) {
		int val = dice[0];
		boolean ret = true;
		
		for(int i = 0; i < dice.length; i++) {
			if(dice[i] != val) {
				ret = false;
			}
		}
		return ret;
	}
	
	/**
	 * The toString method for GameMaster. This will give the player instructions for the game.
	 * More for UI
	 */
	public String toString() {
		String ret = "\n\n\n\n";
		
		ret = ret + "\t\t\tWELCOME TO GUESS THE DICE\n\n";
		ret = ret + "\tHow to win:\n";
		ret = ret + "\t\t1. Be the first to roll all the same dice values\n";
		ret = ret + "\t\t2. Guess the two NonRepeating Die (Only one chance)\n";
		ret = ret + "\t\t3. Be the first to get closest to 200 with rolls without going over\n\n";
		
		ret = ret + "\tAdditional Information:\n ";
		ret = ret + "\t\t1. There can be anywhere between 4 and 9 dice\n";
		ret = ret + "\t\t2. Each die will have between 3 and 11 sides\n";
		ret = ret + "\t\t3. There are 5 rounds of play\n";
		ret = ret + "\t\t4. If you guess the NonRepeating Dice incorrectly, you will continue to play without being able to win\n";
		ret = ret + "\t\t5. At the end of 5 rounds, if all players are over 200 points, a draw will be called\n\n\n";
		return ret;
	}
	
	/**
	 * Creates a safe copy of an array.
	 * Used to avoid aliasing (hopefully)
	 * 
	 * @param org
	 * @return copy, a copy of an int array
	 */
	private int[] createCopy(int[] org) {
		int[] copy = new int[org.length];
		
		for(int i = 0; i < copy.length; i++) {
			copy[i] = org[i];
		}
		
		return copy;
	}
	
	/**
	 * Creates a safe copy of a boolean array
	 * @param org
	 * @return copy, a copy of a boolean array
	 */
	private boolean[] createCopy(boolean[] org) {
		boolean[] copy = new boolean[org.length];
		
		for(int i = 0; i < copy.length; i++) {
			copy[i] = org[i];
		}
		return copy;
	}
	
	/**
	 * Creates a safe copy of an arraylist and stores it in an array
	 * @param org
	 * @return copy, a copy of an arraylist in an array
	 */
	private int[] createCopy(ArrayList<Integer> org) {
		int[] copy = new int[org.size()];
		
		for(int i = 0; i < copy.length; i++) {
			copy[i] = org.get(i);
		}
		
		return copy;
	}
}

