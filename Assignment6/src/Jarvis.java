import java.util.Random;

/**
 * This class will represent Jarvis. This class will represent an object that moves around randomly placing traps every 6th move
 * Jarvis will move every 800 milliseconds
 * Once 
 * @author Anshul Bharath
 *
 */
public class Jarvis extends Mobile {
	/**
	 * isVisible will keep track of whether Jarvis is visible or not at any given time
	 */
	private boolean isVisible = false;
	
	/**
	 * This random object will be used to make all of Jarvis' moves and throw the traps
	 */
	private Random rand;
	
	/**
	 * This keeps track of the number of moves the Jarvis makes and resets after he makes 
	 */
	private int moveCounter;
	/**
	 * The constructor for the Jarvis object
	 * The constructor takes in board and instantiates isVisible and random object
	 * @param board - the board that jarvis will be on
	 */
	public Jarvis(Board board) {
		super(board);
		moveCounter = 0;
		rand = new Random();
	}

	/**
	 * Gets the visibility of Jarvis
	 * @return true, if Jarvis is visible and false otherwise
	 */
	public boolean isVisible() {
		return this.isVisible;
	}

	/**
	 * Checks to see if another boardable object can share the cell that this Jarvis object is in.
	 * @return true, if Player or HomeworkTrap object and false otherwise
	 */
	public boolean share(Boardable elem) {
		if(elem instanceof Player) {
			this.board.setHugged(true); //this should end the game
			System.out.println("Jarvis has been soothed");
			return true;
		}
		if(elem instanceof HomeworkTrap) {
			return true;
		}
		return false;
	}

	/**
	 * This is the run method that comes from the Runnable interface.
	 * This run method will call Jarvis' move and laytrap while also allowing Jarvis to sleep every 800 milliseconds
	 */
	public void run() {
		while(!this.board.beenHugged()) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.move();
			
			if(this.moveCounter == 6) {
				this.layTrap();
			}
			//this.board.printBoard();
		}
		
	}

	/**
	 * The move function for Jarvis. This move function will try every direction 
	 */
	protected void move() {
		int randMove = rand.nextInt(10);
		boolean moveSuccessful = false;
		
		do {
			switch(randMove) {
			case 0:
				moveSuccessful = board.move(Direction.UP, this);
				break;
			case 1:
				moveSuccessful = board.move(Direction.DOWN, this);
				break;
			case 2:
				moveSuccessful = board.move(Direction.LEFT, this);
				break;
			case 3:
				moveSuccessful = board.move(Direction.RIGHT, this);
				break;
			case 4:
				moveSuccessful = board.move(Direction.UP_LEFT, this);
				break;
			case 5:
				moveSuccessful = board.move(Direction.UP_RIGHT, this);
				break;
			case 6:
				moveSuccessful = board.move(Direction.DOWN_LEFT, this);
				break;
			case 7:
				moveSuccessful = board.move(Direction.DOWN_RIGHT, this);
				break;
			case 8: //This is the case to stay in the same place
				moveSuccessful = true;
				break;
			}
			if(!moveSuccessful) {
				randMove = (randMove + 1) % 9;
			}
		}while(!moveSuccessful);
		
		this.moveCounter = this.moveCounter + 1;
	}
	
	/**
	 * This is the toString for Jarvis
	 */
	public String toString() {
		return "?";
	}
	
	/**
	 * This method will lay the traps
	 * Need to fix this +1 % 8
	 */
	public void layTrap() {
		int trapPosition = rand.nextInt(10);
		boolean trapPostionSuccessful = false;
	
		HomeworkTrap tempTrap = new HomeworkTrap(this.board);
		this.board.placeElement(tempTrap, this.board.getRow(this), this.board.getColumn(this));
		
		do{
			switch(trapPosition){
			case 0:
				trapPostionSuccessful = board.move(Direction.UP, tempTrap);
				break;
			case 1:
				trapPostionSuccessful = board.move(Direction.DOWN, tempTrap);
				break;
			case 2:
				trapPostionSuccessful = board.move(Direction.LEFT, tempTrap);
				break;
			case 3:
				trapPostionSuccessful = board.move(Direction.RIGHT, tempTrap);
				break;
			case 4:
				trapPostionSuccessful = board.move(Direction.UP_LEFT, tempTrap);
				break;
			case 5:
				trapPostionSuccessful = board.move(Direction.UP_RIGHT, tempTrap);
				break;
			case 6:
				trapPostionSuccessful = board.move(Direction.DOWN_LEFT, tempTrap);
				break;
			case 7:
				trapPostionSuccessful = board.move(Direction.DOWN_RIGHT, tempTrap);
				break;
			case 8:
				trapPostionSuccessful = true;
				break;
			case 9:
				this.board.removeElement(tempTrap);
				trapPostionSuccessful = true;
			}
			
			if(!trapPostionSuccessful) {
				trapPosition = (trapPosition + 1) % 9;
			}
			
		}while(!trapPostionSuccessful);
		
		this.moveCounter = 0;
	}
}
