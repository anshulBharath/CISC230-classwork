package week13;

public class ArrayFiller implements Runnable {
	
	private int start;
	private int end;
	private int value;
	
	public ArrayFiller(int start, int end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}
	
	public void fillArray() {
		for(int i = this.start; i < this.end; i++) {
			ThreadExample.nums[i] = value;
			if(i%99 == 0) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void run() {
		fillArray();
		
	}

}
