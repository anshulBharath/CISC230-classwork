import java.util.ArrayList;

/**
 * This class allows a user to create, delete and interact with SIC's
 * @author Anshul Bharath
 *
 */
public class SICInventory {
	
	/**
	 * This arraylist instance variable will hold the inventory of the stock index cards
	 */
	private ArrayList<StockIndexCard> inventory; 
	
	public SICInventory() {
		inventory = new ArrayList<StockIndexCard>();  
	}
	
	/**
	 * Adds a new SIC object to inventory
	 * @param id
	 * @param title
	 * @param author
	 * @param price
	 * @param quantity
	 */
	public void addNewSIC(int id, String title, String author, Double price, int quantity) {
		
			inventory.add(new StockIndexCard(id, title, author, price, quantity));
	}
	
	public void removeSIC(int index) {
		inventory.remove(index);
	}
	
	/**
	 * Checks to see if the id in the parameter already exists in the ArrayList
	 * @param id
	 * @return
	 */
	public boolean checkIdenticalId(int id) {
		
		for(StockIndexCard card: inventory) {
			if(card.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method gets a SIC by SIC-ID 
	 * @param id
	 * @return a SIC object or null if there is no SIC with the given id
	 */
	public StockIndexCard getByID(int id) {
		int index = -1;
		
		for(int i = 0; i < inventory.size(); i ++) {
			if(inventory.get(i).getId() == id) {
				index = i;
			}
		}
		
		if(index >= 0) {
			return inventory.get(index);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Gets the index of the SIC with the given SIC-ID
	 * @param id
	 * @return an int value of the index of the SIC-ID
	 */
	public int getIndexById(int id) {
		int index = -1;
		
		for(int i = 0; i < inventory.size(); i ++) {
			if(inventory.get(i).getId() == id) {
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * Creates an array of StockIndexCards toStrings that match the specified author
	 * @param author
	 * @return a string display of all the SIC's
	 */
	public String displayByAuthor(String author){
		ArrayList<Integer> locations = new ArrayList<Integer>();
		ArrayList<String> display = new ArrayList<String>();
		String ret = "Displaying books by " + author +": \n";
		
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getAuthor().equalsIgnoreCase(author)) {
				locations.add(i);
			}
		}
		
		if(locations.size() == 0) {
			ret = ret + "Error: No books were found by " + author + "\n";
			return ret;
		}
		else {
			for(int j = 0; j < locations.size(); j++) {
				display.add(inventory.get(locations.get(j)).toString());
			}
		}
		
		for(String z: display) {
			ret = ret + z + "\n";
		}
		return ret;
	}
	
	/**
	 * Creates an array of StockIndexCards toStrings that match the specified title
	 * @param title
	 * @return a string display of all the SIC's
	 */
	public String displayByTitle(String title){
		ArrayList<Integer> locations = new ArrayList<Integer>();
		ArrayList<String> display = new ArrayList<String>();
		String ret = "Displaying books by " + title +": \n";
		
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getTitle().equalsIgnoreCase(title)) {
				locations.add(i);
			}
		}
		
		if(locations.size() == 0) {
			ret = ret + "Error: No books were found with the title " + title + "\n";
			return ret;
		}
		else {
			for(int j = 0; j < locations.size(); j++) {
				display.add(inventory.get(locations.get(j)).toString());
			}
		}
		
		for(String z: display) {
			ret = ret + z + "\n";
		}
		return ret;
	}
	
	/**
	 * Gets the size of the inventory at the time that the method is called
	 * @return an int value of the size of the inventory
	 */
	public int getInventorySize() {
		return inventory.size();
	}
	
	/**
	 * To String displaying the inventory
	 */
	public String toString() {
		String ret = "";
		
		ret = ret + "Displaying All Books:\n";
		
		for(StockIndexCard card: inventory) {
			ret = ret + card.toString() + "\n";
		}
		
		return ret;
	}
	
	public String booksInPriceRange(Double minPrice, Double maxPrice) {
		ArrayList<String> display = new ArrayList<String>();
		String ret = "";
		
		for(int i = 0; i < inventory.size(); i ++) {
			if(inventory.get(i).getPrice() >= minPrice && inventory.get(i).getPrice() <= maxPrice) {
				display.add(inventory.get(i).toString());
			}
		}
		
		if(display.size() == 0) {
			return ret;
		}
		else {
			ret = "Displaying Books in price range between " + minPrice + " and " + maxPrice + "\n";
			for(int i = 0; i < display.size(); i ++) {
				ret = ret + display.get(i) + "\n";
			}
		}
		return ret;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
