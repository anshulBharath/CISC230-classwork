import java.util.Scanner;

/**
 * This class will represent a Stylus object and implements the Boarable interface.
 * 
 * @author Anshul Bharath
 *
 */
public class Stylus implements Boardable {
	
	/**
	 * board represents the board and will be passed in through the constructor 
	 */
	private Board board;
	/**
	 * input is the scanner object that will take user input
	 */
	private Scanner input;
	/**
	 * isVisible keeps track of the visibility of the stylus
	 */
	private boolean isVisible;
	
	/**
	 * The constructor for the stylus class. 
	 * The constructor takes a board object and places this stylus on position 0,0
	 * @param board - the board that the player makes 
	 */
	public Stylus(Board board) {
		this.board = board;
		input = new Scanner(System.in);
		isVisible = true;
		this.board.placeElement(this, 0, 0);
	}
	
	/**
	 * This method returns the visibility of the stylus object
	 * @return true, if the the stylus is visible and false if not
	 */
	public boolean isVisible() {
		return this.isVisible;
	}
	
	/**
	 * This method will move the stylus depending on what letter/direction the user enters
	 * Before a value is entered, this method will print the board, so the user will see where the stylus is currently located
	 * 
	 * @return true, if the move was successful and false otherwise
	 */
	public boolean move() {
		String userKey;
		int defaultValue = -1; //This is used to go through the doWHile loop
		
		board.printBoard(); //prints the board before each move
		
		do {
			userKey = input.nextLine();
			userKey.toLowerCase();
			
			switch(userKey) {
			case "w":
				board.move(Direction.UP, this);
				defaultValue = -1;
				break;
			case "x":
				board.move(Direction.DOWN, this);
				defaultValue = -1;
				break;
			case "a":
				board.move(Direction.LEFT, this);
				defaultValue = -1;
				break;
			case "d":
				board.move(Direction.RIGHT, this);
				defaultValue = -1;
				break;
			case "q":
				board.move(Direction.UP_LEFT, this);
				defaultValue = -1;
				break;
			case "e":
				board.move(Direction.UP_RIGHT, this);
				defaultValue = -1;
				break;
			case "z":
				board.move(Direction.DOWN_LEFT, this);
				defaultValue = -1;
				break;
			case "c":
				board.move(Direction.DOWN_RIGHT, this);
				defaultValue = -1;
				break;
			case "s": //Forgot about implementing the rest of this functionality
				this.isVisible = !this.isVisible;
				defaultValue = -1;
				break;
			case "0": //This is the case to exit the loop
				defaultValue = 1;
				break;
			default:
				defaultValue = -1;
				break;
			}
			System.out.println();
			board.printBoard();
			 
		} while(!userKey.equals("0") && defaultValue == -1);
		
		return false;
	}
	
	/**
	 * This is the toString for the Stylus class.
	 * @return an asterix if the stylus is visible and return an empty string if the stylus is not visible
	 */
	public String toString() {
		if(this.isVisible) {
			return "*";
		}
		else {
			return "";
		}
		
	}

}
