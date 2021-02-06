import java.util.Scanner;

/**
 * This class will represent a Stylus object and implements the Boarable interface.
 * 
 * @author Anshul Bharath
 *
 */
public class Player extends Mobile {
	
	/**
	 * board represents the board and will be passed in through the constructor 
	 */
	//private Board board;
	/**
	 * input is the scanner object that will take user input
	 */
	private Scanner input;
	/**
	 * isVisible keeps track of the visibility of the stylus
	 */
	private boolean isVisible = true;
	
	/**
	 * delayTime keeps track of what the current delayTime is during each move
	 */
	private long delayTime;
	
	/**
	 * The constructor for the stylus class. 
	 * The constructor takes a board object and places this stylus on position 0,0
	 * @param board - the board that the player makes 
	 */
	public Player(Board board) {
		super(board);
		input = new Scanner(System.in);
		//this.board.placeElement(this, 0, 0);
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
	public void move() {
		String userKey;
		board.printBoard(); //prints the board before each move
		
		do {
			this.delay();
			userKey = input.nextLine();
			userKey.toLowerCase();
			
			switch(userKey) {
			case "w":
				board.move(Direction.UP, this);
				break;
			case "x":
				board.move(Direction.DOWN, this);
				break;
			case "a":
				board.move(Direction.LEFT, this);
				break;
			case "d":
				board.move(Direction.RIGHT, this);
				break;
			case "q":
				board.move(Direction.UP_LEFT, this);
				break;
			case "e":
				board.move(Direction.UP_RIGHT, this);
				break;
			case "z":
				board.move(Direction.DOWN_LEFT, this);
				break;
			case "c":
				board.move(Direction.DOWN_RIGHT, this);
				break;
			default:
				break;
			}
			System.out.println();
			board.printBoard();
			 
		} while(!this.board.beenHugged());
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

	/**
	 * This is the share method for the player. This will always return false
	 * @return false
	 */
	public boolean share(Boardable elem) {
		//Needs to have instanceof
		return false;
	}

	/**
	 * This is the player's implementation of the Runnable interface. This method will only call move
	 */
	public void run() {
		move();
		
	}
	
	/**
	 * This method will set the delayTime for the player
	 * @param time - the time that the player will be delayed
	 */
	public void setDelay(Long time) {
		this.delayTime = time;
	}
	
	/**
	 * This method will be called every move and will be delayed delayTime seconds
	 */
	private void delay() {
		try {
			Thread.sleep(this.delayTime);
			System.in.read(new byte[System.in.available()]);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		delayTime = 0;
	}

}
