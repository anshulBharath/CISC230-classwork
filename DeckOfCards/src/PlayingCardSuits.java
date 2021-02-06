
public enum PlayingCardSuits {
	CLUBS(1),
	HEARTS(2),
	DIAMONDS(3),
	SPADES(4);
	
	private int orderValue;
	
	private PlayingCardSuits(int orderValue) {
		this.orderValue = orderValue;
	}
	
	public int getOrderValue() {
		return this.orderValue;
	}
}
