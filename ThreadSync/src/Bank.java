
public class Bank {
	private int amount;
	
	public synchronized int getAmount() {
		return this.amount;
	}
	
	public synchronized void deposit(int value) {
		amount = amount + value;
	}
	
	public void withdraw(int value) {
		this.amount = this.amount - value;
	}
}
