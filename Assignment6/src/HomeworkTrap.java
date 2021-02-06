/**
 * This class will represent the homework trap class. 
 * These traps will be laid by Jarvis and will stop the player from moving for a given amount of time
 * @author Anshul Bharath
 *
 */
public class HomeworkTrap implements Boardable{
	/**
	 * board represents the board that will be made at the beginning of the game
	 */
	private Board board;
	
	public HomeworkTrap(Board board) {
		this.board = board;
	}
	
	/**
	 * This method will always return false, as the homeowork traps are never visible
	 */
	public boolean isVisible() {
		return false; //will return true for now for testing purposes
	}

	/**
	 * This method check to see if Homeworktrap can share its cell with another boardable elem
	 * @return true, only if elem is a player and false otherwise
	 */
	public boolean share(Boardable elem) {
		if(elem instanceof Player) {
			Player player = (Player) elem;
			player.setDelay((long) 5000);
			System.out.println("UH OH, You hit a homework Trap!!! Wait 5 seconds");
			this.board.removeElement(this);
			return true;
		}
		else if(elem instanceof Jarvis) {
			return true;
		}
		else {
			return false; //if lands on another trap
		}
		
	}
	
	/**
	 * The toString method for the homework trap class
	 */
	public String toString() {
		return " ";
	}
		
}	
