import java.util.Scanner;

/**
 * This is a class that will be used for the processing of the inventory
 * This class will contain the important methods of the menu that the user will see
 * @author Anshul Bharath
 *
 */
public class UserInput {
	private Scanner input =  new Scanner(System.in);
	/**
	 * This object will house the ArrayList for the inventory
	 */
	private SICInventory inventory;
	
	public UserInput() {
		inventory = new SICInventory();
	}
	
	/**
	 * Starts the menu of the program. Uses a switch statement to select the different options.
	 */
	public void startInterface() {
		Scanner input = new Scanner(System.in);
		int choice = 42;
		
		while(choice != 10){
			mainMenu();
			choice = input.nextInt();
			System.out.println("");
			
			switch(choice) {
			
			case 1:
				promptAdd();
				break;
			case 2:
				promptRemove();
				break;
			case 3:
				promptIncreaseStock();
				break;
			case 4:
				promptDecreaseStock();
				break;
			case 5:
				displayById();
				break;
			case 6:
				displayByAuthor();
				break;
			case 7:
				displayByTitle();
				break;
			case 8:
				System.out.println(this.toString());;
				break;
			case 9:
				changePrice();
				break;
			case 10:
				break;
			default:
				System.out.println("");
				mainMenu();
				break;
			}
				
		}
		input.close();
		System.out.println("\nThank you for using Inventory Incredible");

	}
	
	/**
	 * A display of the string value that holds the string representation of the menu
	 */
	public void mainMenu() {
		String menu = "";
		
		menu = menu + "Please select a number from the following options:\n";
		menu = menu + "1) Add new Stock Index Card\n";
		menu = menu + "2) Remove Stock Index Card\n";
		menu = menu + "3) Increase Stock by SIC-ID\n";
		menu = menu + "4) Decrease Stock by SIC-ID\n";
		menu = menu + "5) Display Stock Index Card by SIC-ID\n";
		menu = menu + "6) Display Stock Index Card by Author\n";
		menu = menu + "7) Display Stock Index Card by Title\n";
		menu = menu + "8) Display All Stock Index Cards\n";
		menu = menu + "9) Change the price by SIC-ID\n";
		menu = menu + "10) Quit\n";
		menu = menu + ">> ";
		
		System.out.print(menu);
	}
	
	/**
	 * This method prompts the user to add a new SIC
	 * If an entered id is already taken, an error message will be given and the user will return to the menu
	 */
	private void promptAdd() {
		int id;
		String title;
		String author;
		Double price;
		int quantity;
		
		
			System.out.println("Making new card: ");
			System.out.print("\tPlease enter the SIC-ID: ");
			id =  input.nextInt();
			
			
			if(inventory.checkIdenticalId(id)) {
				System.out.println("Error: SIC-ID " + id + " is already in the system.\n");
			}
			
			while(!inventory.checkIdenticalId(id)) {
				System.out.print("\tPlease enter the title: ");
				input.nextLine(); //Needed to move to the next line
				title = input.nextLine();
				title = title.trim();
			
				System.out.print("\tPlease enter the author: ");
				author = input.nextLine();
				author = author.trim();
			
				System.out.print("\tPleaser enter the price: ");
				price = input.nextDouble();
			
				System.out.print("\tPlease enter the quantity: ");
				quantity = input.nextInt();
				input.nextLine();
				
				inventory.addNewSIC(id, title, author, price, quantity);
				System.out.println(""); //Buffer in the lines
			}
	}
	
	/**
	 * Prompts the user to remove a SIC using the SIC-ID. Will result in an error if the entered id does not exist
	 */
	private void promptRemove() {
		int id;
		boolean error = false;
		
		if(inventory.getInventorySize() <= 0) {
			System.out.println("ERROR: The inventory is empty\n");
		}
		
		while(inventory.getInventorySize() > 0 && !error ) {
			System.out.println("Removing Stock Index Card: ");
			System.out.print("\tPlease enter the SIC-ID of the stock index card to be removed: ");
			id = input.nextInt();
			System.out.println("");
			
			if(inventory.getByID(id) == null) {
				System.out.println("ERROR: unable to find the Stock index card with this SIC-ID\n");
				error = true;
			}
			else {
				inventory.removeSIC(inventory.getIndexById(id));
				System.out.println("The Stock index card with SIC-ID "+ id + " was removed successfully\n");
			}
		}
	}
	
	/**
	 * This method prompts the user to enter the amount they want to increase their stock by
	 * If a negative or zero value is entered an error message will show
	 */
	private void promptIncreaseStock() {
		int id;
		int amount;
		
		System.out.println("Increasing Stock: ");
		System.out.print("\tPlease enter the SIC-ID: ");
		id = input.nextInt();
		
		if(inventory.getByID(id) == null) {
			System.out.println("ERROR: unable to find the Stock index card with this SIC-ID\n");
		}
		else {
			System.out.print("\tPlease enter the amount you wish to increase the stock by: ");
			amount = input.nextInt();
			System.out.println("");
			
			if(amount <= 0) {
				System.out.println("ERROR: unable to increase the inventory amount\n");
			}
			else {
				inventory.getByID(id).increaseQuantity(amount); 
			}
		}
	}
	
	/**
	 * This method prompts the user to enter the amount they want to decrease their stock by
	 * If a negative value is entered it will assume the user wants to decrease by this amount. 
	 * If zero is entered an error will occur
	 */
	private void promptDecreaseStock() {
		int id;
		int amount;
		
		System.out.println("Decreasing Stock: ");
		System.out.print("\tPlease enter the SIC-ID: ");
		id = input.nextInt();
		
		if(inventory.getByID(id) == null) {
			System.out.println("ERROR: unable to find the Stock index card with this SIC-ID\n");
		}
		else {
			System.out.print("\tPlease enter the amount you wish to decrease the stock by: ");
			amount = input.nextInt();
			System.out.println("");
			
			if(amount <= 0 || (inventory.getByID(id).getQuantity() - amount ) < 0) {
				System.out.println("ERROR: unable to decrease the inventory amount\n");
			}
			else {
				inventory.getByID(id).decreaseQuantity(amount); 
			}
		}
	}
	
	/**
	 * Displays the toString of an StockIndexCard object given an id
	 */
	private void displayById() {
		int id;
		boolean error = false;
		String display;
		
		if(inventory.getInventorySize() <= 0) {
			System.out.println("ERROR: The inventory is empty\n");
		}
		
		while(inventory.getInventorySize() > 0 && !error ) {
			System.out.println("Displaying by ID: ");
			System.out.print("\tPlease enter the SIC-ID of the stock index card to be displayed: ");
			id = input.nextInt();
			System.out.println("");
			
			if(inventory.getByID(id) == null) {
				System.out.println("ERROR: unable to find the Stock index card with this SIC-ID\n");
				error = true;
			}
			else {
				display = inventory.getByID(id).toString();
				System.out.println(display);
				error = true;
			}
		}
	}
	
	/**
	 * Displays all the SIC's that match the user entered author
	 */
	private void displayByAuthor() {
		String author;
		boolean error = false;
		
		if(inventory.getInventorySize() <= 0) {
			System.out.println("ERROR: The inventory is empty\n");
		}
		
		while(inventory.getInventorySize() > 0 && !error ) {
			System.out.println("Displaying books by author: ");
			System.out.print("\tPlease enter the name of the author: ");
			author = input.nextLine();
			System.out.println("");
			
			System.out.println(inventory.displayByAuthor(author));
			error = true;
		}
	}
	
	/**
	 * Displays all the SIC's that match the user entered author
	 */
	private void displayByTitle() {
		String title;
		boolean error = false;
		
		if(inventory.getInventorySize() <= 0) {
			System.out.println("ERROR: The inventory is empty\n");
		}
		
		while(inventory.getInventorySize() > 0 && !error ) {
			System.out.println("Displaying titles: ");
			System.out.print("\tPlease enter the name of the title: ");
			title = input.nextLine();
			System.out.println("");
			
			System.out.println(inventory.displayByTitle(title));
			error = true;
		}
	}

	/**
	 * Prompts the user to change the price given a SIC
	 */
	private void changePrice() {
		int id;
		Double amount;
		
		System.out.println("Changing price: ");
		System.out.print("\tPlease enter the SIC-ID: ");
		id = input.nextInt();
		
		if(inventory.getByID(id) == null) {
			System.out.println("ERROR: unable to find the Stock index card with this SIC-ID\n");
		}
		else {
			System.out.print("\tPlease enter the new price: ");
			amount = input.nextDouble();
			System.out.println("");
			
			if(amount <= 0.0) {
				System.out.println("ERROR: unable to change price. Must be postive\n");
			}
			else {
				inventory.getByID(id).changePrice(amount); 
			}
		}
	}
	
	/**
	 * Uses the same toString as the SICInventory class
	 */
	public String toString() {
		String ret = "";
		
		if(inventory.getInventorySize() == 0) {
			ret = ret + "Displaying All Books:\n";
			ret = ret + "\tThe inventory is empty\n";
			return ret;
		}
		else
			return inventory.toString();
	}
}
			


