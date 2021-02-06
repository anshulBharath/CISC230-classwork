package week13;

public class ExmpleThread implements Runnable {

	private int value;
	
	
	public ExmpleThread(int value) {
		this.value = value;
	}
	
	public void verbose()  {
		for(int i = 0; i < 1000; i++) {
			System.out.print(this.value+" ");
			if(i%20 == 0) {
				System.out.println();
				try {
					Thread.sleep(3000);
				}
				catch(InterruptedException ex) {
					System.out.println("I'm interuptted");
				}
				 
			}
		}
		System.out.println("\n\n");
	}
	
	@Override
	public void run() {
		verbose();
	}

}
