
public class BankUser implements Runnable {
	private Bank bank;
	private String name;
	
	private static Object lock = new Object();
	
	public BankUser(Bank bank, String name) {
		this.bank = bank;
		this.name = name;
	}
	
	public void doBanking() {
		synchronized(bank) {
			int curAmount = bank.getAmount();
			
			if(curAmount < 0) {
				System.out.println(this.name + "Overdrafts are going to break me");
				System.exit(0); //Never ever use
			}
			
			if(curAmount <= 1) {
				System.out.println(this.name + ": adding 100");
				this.bank.deposit(100);
			}
			else {
				System.out.println(this.name+": removing " + ((int) (curAmount * .55)));
				bank.withdraw((int)(curAmount * .55));
			}
		}
	}
	
	@Override
	public void run() {
		while(true) {
			this.doBanking();
		}
		
	}

}
