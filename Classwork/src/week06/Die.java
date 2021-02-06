package week06;

import java.util.Random;

/**
 * This class represents a die that can be set a specific num sides
 * @author Anshul Bharath
 *
 */
public class Die {
	/**
	 * the number of sides that the die will have
	 */
	private int numSides;
	/**
	 * Random object that will create random numbers
	 */
	private final Random rand = new Random();
	
	/**
	 * Creates the Die object
	 * @param numSides
	 */
	public Die(int numSides) {
		this.numSides = numSides;
	}
	
	/**
	 * Generates a random number between 1 and the num sides
	 * @return
	 */
	public int roll() {
		return rand.nextInt(numSides) + 1;
	}
	
	
	/**
	 * Returns the number of sides the die has
	 * @return and integer representation of the sides
	 */
	public int getNumSides() {
		return this.numSides;
	}
}
