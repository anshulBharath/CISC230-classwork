/**
 * This main was used for testing the main functions of the Board and the stylus
 * @author Anshul Bharath
 *
 */
public class TestDriver {
	private static final int ROW = 5;
	private static final int COL = 5;
	
	public static void main(String[] args) {
		TestDriver tester = new TestDriver();
		
		System.out.println("This program will run tests on the main functionalities of the board and the stylus objects");
		tester.printSeperator();
		tester.testRange();
		
		tester.printSeperator();
		tester.testEdges();
		
		tester.printSeperator();
		tester.testDiagonals();
		
		tester.printSeperator();
		tester.testAlreadyPassedElem();
		tester.printSeperator();
		
	}
	
	
	
	
	/**
	 * This method will use the callMoveDirectionXTimes to move the stylus to each of the edges and try to go past the edge
	 * This method will give a Actual and expected output of the boolean values returned by the move method after it is called
	 */
	public void testEdges() {
		System.out.println("\nTEST: Moving the stylues up, down, right, and left\n");
		System.out.println("Stylus Moving Right:");
		this.callMoveDirectionXTimes(Direction.RIGHT,5);
		System.out.println("Expected Output: true, true, true, true, false\n");
		System.out.println("Stylus Moving Down:");
		this.callMoveDirectionXTimes(Direction.DOWN, 5);
		System.out.println("Expected Output: true, true, true, true, false\n");
		System.out.println("Stylus Moving Left:");
	   	this.callMoveDirectionXTimes(Direction.LEFT, 5);
		System.out.println("Expected Output: false, false, false, false, false\n");
		System.out.println("Stylus Moving Up:");
		this.callMoveDirectionXTimes(Direction.UP, 5);
		System.out.println("Expected Output: false, false, false, false, false\n");
		System.out.println();
		
	}
	
	/**
	 * This method will use the callMoveDiagonalXTimes to move the stylus along each of the diagonls and try to go past the edge
	 * This method will give a Actual and expected output of the boolean values returned by the move method after it is called 
	 */
	public void testDiagonals() {
		System.out.println("\nTEST: Moving the stylus on the diagonals\n");
		this.callMoveDiagonalsXTimes(Direction.DOWN_RIGHT,5);
		System.out.println("Expected Output: true, true, false, false, false\n");
		this.callMoveDiagonalsXTimes(Direction.DOWN_LEFT, 5);
		System.out.println("Expected Output: true, true, false, false, false\n");
		this.callMoveDiagonalsXTimes(Direction.UP_RIGHT, 5);
		System.out.println("Expected Output: true, true, false, false, false\n");
		this.callMoveDiagonalsXTimes(Direction.UP_LEFT, 5);
		System.out.println("Expected Output: true, true, false, false, false\n");
		System.out.println();
	}
	
	/**
	 * This method will create boards of different lengths and catch exceptions that should be thrown by the board
	 */
	public void testRange() {
		System.out.println("\nTEST: Creating boards of different ranges\n");
		try {
			Board myBoard = new Board(1,1);
			myBoard.printBoard();
			System.out.println("SUCCESS: A board in the right range was created\n");
		}
		catch(IllegalArgumentException e) {
			System.out.println("ERROR: There should not be an exception caught here\n");
		}
		
		try {
			Board myBoard = new Board(ROW,COL);
			myBoard.printBoard();
			System.out.println("SUCCESS: A board in the right range was created\n");
		}
		catch(IllegalArgumentException e) {
			System.out.println("ERROR: There should not be an exception caught here\n");
		}
		
		try {
			Board myBoard = new Board(10,10);
			myBoard.printBoard();
			System.out.println("SUCCESS: A board in the right range was created\n");
		}
		catch(IllegalArgumentException e) {
			System.out.println("ERROR: There should not be an exception caught here\n");
		}
		
		try {
			Board myBoard = new Board(-1,2);
			myBoard.printBoard();
			System.out.println("ERROR: A board with dimensions of -1, 2 should be thrown\n");
		}
		catch(IllegalArgumentException e) {
			System.out.println("SUCCESS: A board with dimensions of -1, 2 was thrown\n");
		}
		
		try {
			Board myBoard = new Board(0,0);
			myBoard.printBoard();
			System.out.println("ERROR: A board with dimensions of 0, 0 should be thrown\n");
		}
		catch(IllegalArgumentException e) {
			System.out.println("SUCCESS: A board with dimensions of 0, 0 was thrown\n");
		}
		
		try {
			Board myBoard = new Board(100,101);
			myBoard.printBoard();
			System.out.println("ERROR: A board with dimensions of 100, 101 should be thrown\n");
		}
		catch(IllegalArgumentException e) {
			System.out.println("SUCCESS: A board with dimensions of 100, 101 was thrown\n");
		}
	}
	
	public void testAlreadyPassedElem() {
		System.out.println("\nTEST: Trying to move an element that is not on the board");
		
		try {
			Board myBoard = new Board(5,5);
			Stylus stylus = null;
			myBoard.move(Direction.RIGHT, stylus);
			System.out.println("ERROR: The board moved an element that was not on the board");
			
		}
		catch(IllegalArgumentException e) {
			System.out.println("SUCCESS: The board did not try to move an element that was not placed on the board");
		}
		
		
	}
	
	/**
	 * This method will perform a direction x number of times
	 * @param dir - the direction that will be performed
	 * @param x - the number of times that the direction will be repeated
	 * @return true, if direction stays in the bounds of the board and false otherwise
	 */
	public void callMoveDirectionXTimes(Direction dir, int x) {
		boolean ret = false;
		String retString = "";
		
		Board myBoard = new Board(ROW,COL);
		Stylus stylus = new Stylus(myBoard);
		myBoard.printBoard();
		
		for(int i = 0; i < x; i++) {
			ret = myBoard.move(dir, stylus);
			myBoard.printBoard();
			retString = retString + ret + ", " ;
		}
		System.out.println("\nActual Output: " + retString);
	}
	
	/**
	 * This method will move the stylus on the diagonals.
	 * For this method to have a good test, the stylus was placed in the middle of the board to test each of the diagonals.
	 * By default, the stylus starts at 0,0 so there is a stylus at 0,0 that will not be moved
	 * @param dir - the direction that the stylus will move
	 * @param x - the number of times that the direction will be called
	 */
	private void callMoveDiagonalsXTimes(Direction dir, int x) {
		boolean ret = false;
		String retString = "";
		
		Board myBoard = new Board(ROW,COL);
		Stylus stylus = new Stylus(myBoard);
		myBoard.placeElement(stylus, 2, 2);
		myBoard.printBoard();
		
		for(int i = 0; i < x; i++) {
			ret = myBoard.move(dir, stylus);
			myBoard.printBoard();
			retString = retString + ret + ", " ;
		}
		System.out.println("\nActual Output: " + retString);
	}
	
	/**
	 * This was used for clarity when printing out the different tests
	 */
	public void printSeperator() {
		System.out.println("____________________________________________________________________");
	}

}
