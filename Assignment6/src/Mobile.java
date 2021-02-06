/**
 * This abstract class will be extended by Player and Jarvis and provide movement funtionality to both of them
 * @author anshul_bharath
 *
 */
public abstract class Mobile implements Boardable, Runnable{
	
	/**
	 * This is the board object that will be passed to a mobile object
	 */
	protected Board board;
	
	/**
	 * The constructor for a Mobile object
	 * @param board
	 */
	public Mobile(Board board) {
		this.board = board;
	}
	
	/**
	 * The move method for Player and Jarvis. This will be implemented differently by each of the 
	 */
	protected abstract void move();
}
