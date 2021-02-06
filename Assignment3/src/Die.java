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
	 * a unique id that is given to the die to keep track
	 */
	private int id;
	/**
	 * Random object that will create random numbers
	 */
	private final Random rand = new Random();
	/**
	 * a static variable that will assign the id;
	 */
	private static int curId = 0;
	
	/**
	 * Creates the Die object
	 * @param numSides
	 */
	public Die(int numSides) {
		if(numSides < 3 || numSides > 11) {
			System.err.println("The num sides were set out of the allowed sides. A random number sides will be assigned.");
			this.numSides = rand.nextInt(9) + 3;
			this.id = curId;
			curId = curId + 1;
		}
		else {
			this.numSides = numSides;
			this.id = curId;
			curId = curId + 1;
		}
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
	 * @return an integer representation of the sides
	 */
	public int getNumSides() {
		return this.numSides;
	}
	
	/**
	 * Returns the unique id of the dice
	 * @return an integer representation of the id
	 */
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		String ret = "";
		
		ret = ret + "Id: " + this.id + " Num Sides: " + this.numSides + "\n";
		return ret;
	}
}
