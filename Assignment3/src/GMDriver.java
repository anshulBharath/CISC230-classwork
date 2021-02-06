import java.util.Scanner;
/**
 * This is the driver of the GameMaster.
 * This main method allows gives the user the choice to register a human player or an automated player.
 * The main also allows a user to enter in the name of the player they want to register with the GM
 * 
 * @author Anshul Bharath
 *
 */
public class GMDriver {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		GameMaster gm = new GameMaster();
		
		int choice;
		String name;
		
		System.out.println(gm.toString());

		do {
			System.out.println("Enter one of the following options: \n");
			System.out.println("\t1. Real Player");
			System.out.println("\t2. Automated Player");
			System.out.println("\t3. Start Game\n");
			choice = input.nextInt();
			input.nextLine();
			
			if(choice == 1) {
				System.out.print("What is the player's name?: ");
				name = input.nextLine();
				gm.registerPlayer(new Player(name));
				System.out.println("\n");
			}
			else if(choice == 2) {
				System.out.print("What is the automated player's name?: ");
				name = input.nextLine();
				gm.registerPlayer(new AutomatedPlayer(name));
				System.out.println("\n");
			}
			else if(choice == 3) {
				choice = 3;
			}
			else if(choice != 2 || choice != 1) {
				System.err.println("Invalid Input!");
				System.out.println("Enter one of the following options: \n");
				System.out.println("\t1. Real Player");
				System.out.println("\t2. Automated Player");
				System.out.println("\t3. Start Game\n");
				choice = input.nextInt();
				System.out.println("\n");
			}
		} while(choice != 3);
		
		gm.playGame();
		input.close();
	}

}
