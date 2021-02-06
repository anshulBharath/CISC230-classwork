package week04;

public class CardMain {

	public static void main(String[] args) {
		
		Card myCard = new Card("DIAMONDS", 12);
		
		System.out.println(myCard.getSuit());
		System.out.println(myCard.getRank());
		System.out.println(myCard);

	}

}
