/**
 * Models a playing card from a standard deck of 52.  Suits are CLUBS, HEARTS, SPADES, DIAMONDS 
 * and the ranks are 2-10, 11 for JACKS, 12 for QUEENS, 13 for KINGS and 1 for ACES. 
 * @author Jason Sawin
 *
 */
public class Card implements CompareMe{
	/**
	 * Holds the suit of the card.  Valid values are 
	 *  CLUBS, HEARTS, SPADES, DIAMONDS.
	 */
	private PlayingCardSuits suit;
	/**
	 * Holds the rank of the card: valid values are
	 * 2-10, 11 for JACKS, 12 for QUEENS, 13 for KINGS and 1 for ACES.
	 */
	private int rank;
	
	/**
	 * Parameterized constructor that allows the caller to set
	 * the values of the suit and rank.  If the suit is not in the allowed range,
	 * it is given the default value of CLUBS.  If the rank is not in the allowed range,
	 * it is give default value of 2.
	 * @param newSuit the suit of the card. Must be CLUBS, HEARTS, SPADES, DIAMONDS. 
	 * @param newRank the rank of the card. Must be 2-10, 11 for JACKS, 12 for QUEENS, 13 for KINGS and 1 for ACES. 
	 */
	public Card (PlayingCardSuits suit, int newRank) {
		
		this.suit = suit;
		
		//Check if newRank is allowed
		if(newRank>=1 && newRank<14 ) {
			rank = newRank;
		}else {
			//Print a warning and set the default value
			System.err.println("The rank "+newRank+" is not valid.  Setting rank to default of 2.");
			rank = 2;
		}
		
	}
	/**
	 * Allows the suit of the card to be retrieved.
	 * @return suit of the card
	 */
	public PlayingCardSuits getSuit() {
		return suit;
	}
	
	/**
	 * Allows the rank of the card to be retrieved.
	 * @return rank of the card
	 */
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	/**
	 * Checks to see if compareCard is the same card as the card it is being compared to
	 * @param compareCard
	 * @return boolean value true if the same card and false if the cards are different
	 */
	public boolean equals(Card compareCard) {
		
		return (compareCard.getRank() == this.rank) && (compareCard.getSuit().equals(this.suit));
	}
	
	/**
	 * Returns a string representation of the card in the format:
	 * rank of suit.  It modifies the rank so that JACK is displayed for 11, 
	 * QUEEN for 12, KING for 13 and ACE for 1.  
	 */
	public String toString() {
		String ret;//will hold the final string value
		
		//Convert the rank for face cards and Aces
		switch(rank) {
		case 13:
			ret = "KING";
			break;
		case 12: 
			ret = "QUEEN";
			break;
		case 11:
			ret = "JACK";
			break;
		case 1:
			ret = "ACE";
			break;
		default:
			ret = rank +"";
		}
		
		//After the rank is written add in the suit
		ret = ret +" of "+suit.toString();
		return ret;
	}
	
	/**
	 * If this card is greather than other return a positve number
	 * If the are equal return zero
	 * If this card is less than other return a negative number
	 */
	public int compareTo(Object other) {
		Card ot = (Card) other;
		
		if(this.rank == ot.getRank()) {
			return this.suit.ordinal() - ot.suit.ordinal();
		}
		return this.rank - ot.getRank();
		
	}

}
