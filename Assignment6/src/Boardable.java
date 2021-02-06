/**
 * This is the interface for a Boardable class.
 * In this assignment the stylus will implement this interface
 * @author Anshul Bharath
 *
 */
public interface Boardable {

	/**
	 * This method will check to see if the the current Boardable object will be visible or not
	 * @return
	 */
	public boolean isVisible();
	
	/**
	 * This method wil check to see if the two boardable objects can share a cell 
	 * @param elem - the element that is already in the cell
	 * @return true, if elem can be added to the the other cell
	 */
	public boolean share(Boardable elem);
	
	/**
	 * This is the toString for all Boardable objects
	 * @return a String representation of the object
	 */
	public String toString();
}
