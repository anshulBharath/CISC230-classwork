import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a deck of cards
 * @author Anshul Bharath
 *
 */
public class CardDeck {
	/**
	 * An array representation of a deck of PlayingCard
	 */
	private ArrayList<Card> deck;
	
	public CardDeck() {
		deck = new ArrayList<Card>();
		populateDeck();
	}
	
	private void populateDeck() {
		PlayingCardSuits[] suit = PlayingCardSuits.values();
		
		for(int i = 0; i < suit.length; i++) {
			for(int j = 1; j <= 13; j++) {
				deck.add(new Card(suit[i], j)) ;
			}
		}
	}
	
	/**
	 * Deals a PlayingCard to the user
	 * @return the card on top of the deck
	 */
	public Card dealCard() {
		return deck.remove(deck.size() - 1);
	}
	
	/**
	 * Invoking this method will shuffle the deck
	 */
	public void shuffleDeck() {
		/*Random rand = new Random();
		Card temp;
		
		for(int i = 0; i < 10000; i++) {
			temp = this.dealCard();
			int newPos = rand.nextInt(52);
		}*/
		
		ArrayList<Card> temp = new ArrayList<Card>();
		int randomIndex;
		int range = 52;
		
		for(int i = 0; i < 51; i++) {
			randomIndex = (int) (Math.random() * range);
			temp.add(deck.remove(randomIndex));
			range = range - 1;
		}
		temp.add(deck.remove(0));
			deck = temp;
	}
	
	public void insertCard(Card card, int pos) {
		if(pos >= 0 && pos <= this.deck.size()) {
			this.deck.add(pos, card);
		}
			
	}
	
	public void returnCard(Card retCard) {
		
		for(int i = 0; i < deck.size(); i++) {
			if(deck.get(i).equals(retCard)) {
				System.out.println(retCard.toString() + "is already in the deck");
				return;
			}
		}
		deck.add(retCard);
		
	}
	
	public String toString() {
		String ret = "";
		
		for(Card card : deck) {
			ret = ret + card.toString() + ", ";
		}
		
		return ret + deck.size();
	}
	
	public void orderDeck() {
		Sorter.sort(this.deck);
	}
}
