package cardsContinued;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a deck of cards
 * @author Anshul Bharath
 *
 */
public class Deck {
	/**
	 * An array representation of a deck of PlayingCard
	 */
	private ArrayList<PlayingCard> deck;
	
	public Deck() {
		deck = new ArrayList<PlayingCard>();
		populateDeck();
	}
	
	private void populateDeck() {
		String[] suit = {"SPADES", "DIAMONDS", "HEARTS", "CLUBS"};
		
		for(int i = 0; i < suit.length; i++) {
			for(int j = 1; j <= 13; j++) {
				deck.add(new PlayingCard(suit[i], j)) ;
			}
		}
	}
	
	/**
	 * Deals a PlayingCard to the user
	 * @return the card on top of the deck
	 */
	public PlayingCard deal() {
		if(!deck.isEmpty()) {
			return deck.remove(0);
		}
		else {
			System.err.println("All cards are gone");
			return null;
		}
		
	}
	
	/**
	 * Invoking this method will shuffle the deck
	 */
	public void shuffle() {
		/*Random rand = new Random();
		Card temp;
		
		for(int i = 0; i < 10000; i++) {
			temp = this.dealCard();
			int newPos = rand.nextInt(52);
		}*/
		
		//This section for aliasing
		/*ArrayList<PlayingCard> temp = new ArrayList<PlayingCard>();
		int randomIndex;
		int range = 52;
		
		for(int i = 0; i < 51; i++) {
			randomIndex = (int) (Math.random() * range);
			temp.add(deck.remove(randomIndex));
			range = range - 1;
		}
		temp.add(deck.remove(0));
		deck = temp;*/
		
		Random rand = new Random();
		PlayingCard temp;
		
		for(int i = 0; i < 10000; i++) {
			temp = this.deal();
			int newPos = rand.nextInt(this.deck.size() + 1);
			this.deck.add(newPos, temp);
		}
		
	}
	
	public void insertCard(PlayingCard card, int pos) {
		if(pos >= 0 && pos <= this.deck.size()) {
			this.deck.add(pos, card);
		}
			
	}
	
	public void returnCard(PlayingCard retCard) {
		
		for(int i = 0; i < deck.size(); i++) {
			if(deck.get(i).equals(retCard)) {
				System.err.println(retCard.toString() + "is already in the deck");
				return;
			}
		}
		this.deck.add(retCard);
		
	}
	
	public void cutCards(int num) {
		
		if(num < deck.size()) {
			for(int i = 0; i < num; i++) {
			PlayingCard temp = deal();
			this.returnCard(temp);
			}
		}
	}
	
	public boolean equals(Deck other) {
		ArrayList<PlayingCard> tempDeck = new ArrayList<PlayingCard>();
		
		if(this.deck.size() != tempDeck.size()) {
			return false;
		}
		
		for(int i = 0; i < other.deck.size(); i++) {
			tempDeck.add(other.deck.get(i));
		}
		
		for(int i = 0; i < deck.size(); i++) {
			if(!this.deck.get(i).equals(tempDeck.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		String ret = "";
		
		for(PlayingCard card : deck) {
			ret = ret + card.toString() + ", ";
		}
		
		return ret + deck.size();
	}
}
