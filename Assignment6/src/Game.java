import java.util.Random;

/**
 * This is the driver for Assignment6
 * @author Anshul Bharath
 *
 */
public class Game {
	private static int row = 10;
	private static int col = 10;
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		Board board = new Board(row,col);
		Player player = new Player(board);
		Jarvis jarvis = new Jarvis(board);
		FlashLight light = new FlashLight(board);
		
		Thread playerThread = new Thread(player);
		Thread jarvisThread = new Thread(jarvis);
		Thread fThread = new Thread(light);
		
		int jRow = rand.nextInt(row - 2) + 1;
		int jCol = rand.nextInt(col - 2) + 1;
		
		board.placeElement(player, 0,0);
		board.placeElement(jarvis, jRow, jCol);
		board.placeElement(light, 0, 1);
		
		playerThread.start();
		jarvisThread.start();
		fThread.start();
		
		try {
			playerThread.join();
			jarvisThread.join();
			fThread.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thank you for playing \"Hug the Angry Jarvis\"");
	}
	
	

}
