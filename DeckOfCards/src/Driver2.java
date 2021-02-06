
public class Driver2 {

	public static void main(String[] args) {
		
		PlayingCardSuits mySuit = PlayingCardSuits.HEARTS;
		PlayingCardSuits[] allValues = PlayingCardSuits.values();
		
		for(int i = 0; i < allValues.length; i++) {
			System.out.println(allValues[i]);
		}
		
		System.out.println(mySuit.toString());
		
		Card card = new Card(PlayingCardSuits.DIAMONDS, 4);
		System.out.println(card.toString());

	}

}
