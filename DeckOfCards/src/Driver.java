import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		for(PlayingCardSuits curSuit : PlayingCardSuits.values()) {
			System.out.println(curSuit + ": "+curSuit.ordinal());
		}
		
		/*CardDeck deck = new CardDeck();
		Scanner input = new Scanner(System.in);
		
		System.out.println(deck);
		deck.shuffleDeck();
		System.out.println(deck);
		deck.orderDeck();
		System.out.println(deck);*/
		
	}

}
