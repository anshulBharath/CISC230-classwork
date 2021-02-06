package week04;

public class Card {
	
	private String suit;
	private int rank;
	
	public Card(String s, int r){
		s = s.toUpperCase();
		if(s.equals("HEARTS") || s.equals("CLUBS") || s.equals("SPADES") || s.equals("DIAMONDS")) {
			suit = s;
		}
		else {
			System.err.println("The suit " + s + " is not valid. Setting rank to default CLUBS.");
			suit = "CLUBS";
		}
			
		
		
		if(r >= 1 && r < 14) {
			rank = r;
		}
		else {
			System.err.println("The rank " + r + " is not valid. Setting rank to default 2.");
			rank = 2;
		}
		
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String toString() {
		String ret;
		
		switch(rank) {
		case 1: 
			ret = "ACE";
			break;
		case 11:
			ret = "JACK";
			break;
		case 12:
			ret = "QUEEN";
			break;
		case 13:
			ret = "KING";
			break;
		default:
			ret = "" + rank;
			break;
		}
		
		ret = ret + " of " + suit;
		return ret;
	}

}
