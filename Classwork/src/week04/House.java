package week04;

/**
 * Models a house.  It stores number of windows the house has, the current value of the house, and the current temperature. 
 * @author Jason Sawin
 *
 */
public class House {
	/**
	 * Number of windows the house has.
	 */
	private int numWindows;
	/**
	 * The current market value of the home.
	 */
	private double value;
	/**
	 * The current temperature in the house.
	 */
	private float temp;
	
	/**
	 * Builds a house objec that initially has 8 windows, is worth
	 * $230,000.00 and has an internal temperature of 68.5 degrees.
	 */
	public House() {
		numWindows = 8;
		value = 230_000.00;
		temp = 68.5F;
	}
	
	/**
	 * Allows the user to see how many windows the house has.
	 * @return the number of windows the house has
	 */
	public int getNumWindows() {
		return numWindows;
	}
	
	/**
	 * Allows the user to change the number windows the house has.
	 * @param newNumWindows The new number of windows the house will have.  It must be a positive number.
	 */
	public void setNumWindows(int newNumWindows) {
		if(newNumWindows >= 0) {
			numWindows = newNumWindows;
		}else {
			System.err.println("The number of windows is not allowed to be negative.");
		}
	}
	
	/**
	 * Allows the user to see current temperature in the house.
	 * @return the temperature of the house in degrees Fahrenheit
	 */
	public float getTemp() {
		return temp;
	}
	
	/**
	 *  Allows the user to change the temperature in the house. The new value must be between 
	 * 40 and 120 degrees Fahrenheit.
	 * @param newTemp the new temperature in the house.  Must be in the range (40,12).
	 */
	public void setTemp(float newTemp) {
		if(newTemp> 40 && newTemp<120) {
			temp = newTemp;
		}else {
			System.err.println("The valid range for temp is (40,120)");
		}
	}
	
	/**
	 * Allows the user to see current value of the house.
	 * @return the value of the house USD
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Allows the user to set a new value for the house.  The new value has to be greater than 0.
	 * @param newValue the new value, in USD, of the house.  Must be a positive amount
	 */
	public void setValue(double newValue) {
		if(newValue>=0) {
			value = newValue;
		}else {
			System.err.println("The house's value is not allowed to go below zero.");
		}
	}
	
}
