import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This is the main driver for Assignment 5
 * @author Anshul Bharath
 *
 */
public class Assignment5Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Board board = null;
		
		int width = 0;
		int height = 0;;
		Boolean exceptionFlag = true;
		
		System.out.println("\nWelcome to a prequel to \"Hug the Angry Jarvis\"\n");
		do {
			System.out.print("What would you like the height of the board to be?(1-100): ");
			try {
				height = input.nextInt();
				exceptionFlag = true;
			}
			catch(InputMismatchException ex) {
				System.out.println("ERROR: The values entered were of the wrong type");
				input.nextLine();
				height = 0;
				exceptionFlag = false;
			}
			
			if(exceptionFlag) {
				System.out.print("What would you like the width of the board to be?(1-100): ");
				try {
					width = input.nextInt();
					exceptionFlag = true;
				}
				catch(InputMismatchException ex) {
					System.out.println("ERROR: The values entered were of the wrong type");
					input.nextLine();
					width = 0;
					exceptionFlag = false;
				}
			}
			
			if(exceptionFlag) {
				try{
					board = new Board(height, width);
					exceptionFlag = true;
				}
				catch(IllegalArgumentException exp){
					System.out.println("ERROR: The height/width was in the wrong range");
					exceptionFlag = false;
				}
			}
			
		}while(!exceptionFlag);
		
		
		Stylus stylus = new Stylus(board);
		System.out.println("\nUse Q,A,Z,X,C,D,E,W as directional controls for the stylus\nEnter \"0\" to quit\n");
		try {
		stylus.move();
		}
		catch(IllegalArgumentException exp){
			System.out.println("ERROR: " +exp.getMessage());
		}

		input.close();
	}

}
