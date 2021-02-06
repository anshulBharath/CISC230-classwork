
public class TestDriver {

	public static void main(String[] args) {
		//testRemoveBoardElement();
		//testGetColRow();
		//testJarvisMove();
		//testJarvisHomeworkPlacement();
		//testJarvisLayTrap();
		//testJarvisLayingTraps();
		//testJarvisMoveAdvanced();
		//testJarivsLayTrapAdvanced();
	}
	
	public static void testRemoveBoardElement() {
		Board board = new Board(5,5);
		Player player = new Player(board);
		Player player2;
		board.printBoard();
		board.placeElement(player, 2, 2);
		board.printBoard();
		System.out.println(board.removeElement(player));
		board.printBoard();
	}
	
	public static void testGetColRow() {
		Board board = new Board(5,5);
		Player player = new Player(board);
		Player player2 = null;
		System.out.print(board.getRow(player) + " ");
		System.out.print(board.getColumn(player));
		board.placeElement(player, 2, 2);
		System.out.print(board.getRow(player) + " ");
		System.out.print(board.getColumn(player));
	}
	
	public static void testJarvisMove() {
		Board board = new Board(3,3);
		Jarvis j = new Jarvis(board);
		board.placeElement(j, 1, 1);
		board.printBoard();
		
		for(int i = 0; i < 100; i++) {
			j.move();
			board.printBoard();
		}	
	}
	
	public static void testJarvisMoveAdvanced() {
		Board board = new Board(10,10);
		Jarvis j = new Jarvis(board);
		board.placeElement(j, 1, 1);
		board.printBoard();
		
		for(int i = 0; i < 100; i++) {
			j.move();
			board.printBoard();
		}	
	}
	
	public static void testJarvisHomeworkPlacement() {
		Board board = new Board(5,5);
		Jarvis j = new Jarvis(board);
		Player player = new Player(board);
		HomeworkTrap ht = new HomeworkTrap(board);
		System.out.println(board.placeElement(j, 2, 2));
		System.out.println(board.placeElement(player, 3, 2));
		
		System.out.println(board.placeElement(ht, 1, 2));
		board.printBoard();
	}
	
	public static void testJarvisLayTrap() {
		Board board = new Board(3,3);
		Jarvis j = new Jarvis(board);
		Player player = new Player(board);
		
		board.printBoard();
		board.placeElement(j, 1, 1);
		
		for(int i = 0; i < 15; i++) {
			j.layTrap();
			board.printBoard();
		}
		
	}
	
	public static void testJarvisLayingTraps() {
		Board board = new Board(10,10);
		Jarvis j = new Jarvis(board);
		board.placeElement(j, 0, 0);
		
		Thread jThread = new Thread(j);
		jThread.start();
	}
	
	public static void testJarivsLayTrapAdvanced() {
		Board board = new Board(20,20);
		Jarvis j = new Jarvis(board);
		
		board.placeElement(j, 0, 0);
		Thread jThread = new Thread(j);
		jThread.start();
	}

}
