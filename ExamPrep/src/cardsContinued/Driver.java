package cardsContinued;

public class Driver {

	public static void main(String[] args) {
		
		Deck deck = new Deck();
		Deck deck2 = new Deck();
		
		deck.shuffle();
		deck.deal();
		
		System.out.println(deck.equals(deck2));
		

	}

}
