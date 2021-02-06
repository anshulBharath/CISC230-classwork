
public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.deposit(100);

		BankUser pete = new BankUser(bank, "Pete");
		BankUser james = new BankUser(bank, "James");
		Thread pThread = new Thread(pete);
		Thread jThread = new Thread(james);
		
		pThread.start();
		jThread.start();
		
		Bank bank2 = new Bank();
		bank.deposit(100);

		BankUser tom = new BankUser(bank2, "Tom");
		BankUser luke = new BankUser(bank2, "Luke");
		Thread tThread = new Thread(tom);
		Thread lThread = new Thread(luke);
		
		tThread.start();
		lThread.start();
	}
	
	public void setArray(int row, int col) {
		if(row < 1 || row>100) {
			throw new IllegalArgumentException();
		}
		int [][] twoD = new int[row][col];
		
		
	}

}
