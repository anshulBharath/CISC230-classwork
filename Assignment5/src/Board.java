import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class will represent the playing board for this Assignment
 * The board will be made up of a user specified length and width of cells
 * @author Anshul Bharath
 *
 */
public class Board {
	
	/**
	 * board is a two dimensional array that will hold the elements of each cell
	 */
	private Cell[][] board;
	
	/**
	 * height will store the height of the board/two dimensional array
	 */
	private int height;
	/**
	 * width will store the width of the board/two dimensional array
	 */
	private int width;

	/**
	 * elementPlace will keep track of where each Boardable element is placed
	 */
	private HashMap<Boardable, Cell> elementPlace;

	/**
	 * This private inner class will represent a Cell object that a board will be made of.
	 */
	private class Cell{
		/**
		 * row represents the current row that the cell is located at 
		 */
		private int row;
		/**
		 * col represents the current column that the cell is located at 
		 */
		private int col;
		/**
		 * isVisible is TODO Im not exactly sure how this will work right now 
		 */
		private boolean isVisible;
		/**
		 * elements holds the different boardable objects that can be on a board.
		 * For assignment5 this will only hold a stylus for now
		 */
		private ArrayList<Boardable> elements;
		
		/**
		 * This is the constructor for the Cell class
		 * @param row - the row that the cell will be located
		 * @param col - the column that the cell will be located
		 */
		public Cell(int row, int col) {
			this.row = row;
			this.col = col;
			this.isVisible = false;
			
			elements = new ArrayList<Boardable>();
		}
		
		/**
		 * This method will add a boardable object to the arraylist
		 * @param elem - an object that implements the boardable interface
		 */
		public void addElement(Boardable elem) {
			elements.add(elem);
			this.isVisible = true;
		}
		
		/**
		 * This method will remove the first instance of the specified elem object
		 * @param elem - the boardable object that needs to be removed
		 * @return true, if the element was removed and false otherwise
		 */
		public boolean removeElement(Boardable elem) {
			return elements.remove(elem);
		}
		
		/**
		 * The toString method for the Cell class.
		 * @return a "#" if isVisible is false
		 * @return a " " if elements is empty
		 * @return the last element of elements otherwise
		 */
		public String toString() {
			if(!this.isVisible) {
				return "#";
			}
			else {
				if(this.elements.isEmpty()) {
					return " ";
				}
				else {
					return this.elements.get(this.elements.size()-1).toString();
				}
			}
		}
		
	}
	
	/**
	 * The constructor for the board class will initialize the Cell array and instantiate the hasMap
	 * The constructor will throw out any values that are not in the range
	 * @param height - the width of the board
	 * @param width - the height of the board
	 */
	public Board(int height, int width) {
		
		if(height > 100 || height < 1 || width > 100 || width < 1) {
			IllegalArgumentException illegalArgument = new IllegalArgumentException("The entered values were out of range");
			throw illegalArgument;
		}
		else {
			this.height = height;
			this.width = width;
			
			this.board = new Cell[height][width];
			this.createBoard();
			elementPlace = new HashMap<Boardable, Cell>();
		}
		
	}
	
	/**
	 * This method will take a boardable element and a direction and move the element in the specified direction
	 * This method will throw an IllegalArgumentException if the passed element has not been placed on the board yet
	 * @param dir - an enum that holds all the direction values
	 * @param elem - the element that is going to be moved
	 * @return true if the element was moved successfully and false otherwise
	 */
	public boolean move(Direction dir, Boardable elem) {
		if(!this.elementPlace.containsKey(elem)) {
			IllegalArgumentException illegalArgument = new IllegalArgumentException("This boardable element does not exist");
			throw illegalArgument;
		}
		
		Cell temp = this.elementPlace.get(elem);
		int oldRow = temp.row;
		int oldCol = temp.col;
		int newRow = 0;
		int newCol = 0;
		
		//Switch statement will change the row and/or col to the new position based on the direction
		switch(dir){
		case UP:
			newRow = oldRow - 1;
			newCol = oldCol;
			break;
		case DOWN:
			newRow = oldRow + 1;
			newCol = oldCol;
			break;
		case LEFT:
			newCol = oldCol - 1;
			newRow = oldRow;
			break;
		case RIGHT:
			newCol = oldCol + 1;
			newRow = oldRow;
			break;
		case UP_LEFT:
			newRow = oldRow - 1;
			newCol = oldCol - 1;
			break;
		case UP_RIGHT:
			newRow = oldRow - 1;
			newCol = oldCol + 1;
			break;
		case DOWN_LEFT:
			newRow = oldRow + 1;
			newCol = oldCol - 1;
			break;
		case DOWN_RIGHT:
			newRow = oldRow + 1;
			newCol = oldCol + 1;
			break;
		default:
			newRow = -1;
			newCol = -1;
			break;
		}
		
		//if the new rol/col is outside of the board's parameters, this function will return false
		if(newRow<0 || newRow >= this.height || newCol<0 || newCol>=this.width) {
			return false;
		}
		
		//Turns where the stylus was to a blank space
		this.board[oldRow][oldCol].removeElement(elem);
			
		
		Cell newCell = new Cell(newRow, newCol);
		newCell.addElement(elem);
		
		this.board[newRow][newCol] = newCell;
		this.elementPlace.put(elem, newCell);
		return true;
			
	}
	
	/**
	 * This method will take a boardable element and place it on the board with the specified row and col
	 * @param elem - the boardable element that will be placed
	 * @param row - the row where the boardable element will be placed
	 * @param col - the col where the boardable element will be placed 
	 * @return true, if the element was placed correctly
	 */
	public boolean placeElement(Boardable elem, int row, int col) {
		Cell temp = board[row][col];
		
		if(!temp.isVisible) {
			temp.addElement(elem);
			elementPlace.put(elem, temp);
			return true;
		}
		return false;
	}
	
	/**
	 * This method will print the board
	 * This method will be called after each move is made, in order to get a refreshed board
	 */
	public void printBoard() {
		String ret = "";
		for(int i = 0; i < this.height; i++) {
			for(int j = 0; j < this.width; j++) {
				ret = ret + board[i][j].toString();
			}
			ret = ret + "\n";
		}
		System.out.println(ret);
	}
	
	/**
	 * This method will create the board with all the cells instantiated
	 */
	private void createBoard() {
		for(int i = 0; i < this.height; i++) {
			for(int j = 0; j < this.width; j++) {
				this.board[i][j] = new Cell(i,j);
			}
		}
	}
}
