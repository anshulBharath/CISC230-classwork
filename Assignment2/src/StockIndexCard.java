/**
 * This is the class that correlates with the StockIndexCard. This class has 5 fields
 * 
 * @author Anshul Bharath
 *
 */
public class StockIndexCard {
	
	/**
	 * A unique integer used to identify every title in the inventory
	 */
	private int id;
	/**
	 * The title of the book being sold
	 */
	private String title;
	/**
	 * The author of the book
	 */
	private String author;
	/**
	 * The price the book is being sold for
	 */
	private Double price;
	/**
	 * The number of copies the bookstore has of the book
	 */
	private int quantity;
	
	/**
	 * Constructor for the class StockIndexCard
	 * @param newId
	 * @param newTitle
	 * @param newAuthor
	 * @param newPrice
	 * @param newQuantity
	 */
	public StockIndexCard(int newId, String newTitle, String newAuthor, Double newPrice, int newQuantity) {
		
		if(newPrice<0) {
			NegativePriceException npe = new NegativePriceException("The price " +newPrice+ " is not allowed."
					+ " Only positive price values can be used");
			throw npe;
		}
		if(newQuantity<0) {
			IllegalArgumentException badArg = new IllegalArgumentException("Either price or quanity were negative.");
			throw badArg;
		}
		
		id = newId;
		title = newTitle;
		author = newAuthor;
		price = newPrice;
		quantity = newQuantity;
	}

	/**
	 * Gets the value of id for the SIC
	 * @return a unique id number
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the title of a given SIC
	 * @return a string value of the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Gets the name of the author for a given SIC
	 * @return a string value of the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Gets the price of the author for given SIC
	 * @return a Double value of the price
	 */
	public Double getPrice() {
		return price;
	}
	
	/**
	 * Gets the quantity of the 
	 * @return an int value of the stock of books of the given SIC
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * This function gives the user only the ability to add to the stock 
	 * @param increase
	 */
	public void increaseQuantity(int increase) {
		quantity = quantity + increase;
	}
	
	 /** 
	 * This function gives the user only the ability to subtract from the stock 
	 * @param decrease
	 */
	public void decreaseQuantity(int decrease) {
		quantity = quantity - Math.abs(decrease);
	}
	
	/**
	 * Changes price to new price
	 * @param newPrice
	 */
	public void changePrice(Double newPrice) {
		price = newPrice;
	}
	
	/**
	 * The toString of the SIC class returns a summary of the current SIC
	 */
	public String toString() {
		String ret = "";
		
		ret = ret + "Stock Index Card " + id + "\n";
		ret = ret + "\tTitle: " + title + "\n";
		ret = ret + "\tAuthor: " + author + "\n";
		ret = ret + "\tPrice: $" + price + "\n";
		ret = ret + "\tQuantity: " + quantity + "\n";
		
		return ret;
	}

	
	

}
