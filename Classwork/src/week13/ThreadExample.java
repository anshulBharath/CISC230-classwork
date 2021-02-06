package week13;

public class ThreadExample {
	
	public static int [] nums = new int[1000];
	
	public static void setArray() {
		for(int i = 0; i<nums.length; i++) {
			nums[i] = -55;
		}
	}
	
	public static void printArray() {
		for(int i = 1; i<=nums.length; i++) {
			System.out.print(nums[i-1] + " ");
			if(i%20 ==0) {
				System.out.println();
			}
		}
		System.out.println("\n\n");
	}

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		setArray();
		long end = System.currentTimeMillis();
		long result1 = end - start;
		printArray();
		
		ArrayFiller a1 = new ArrayFiller(0,nums.length/2,8);
		ArrayFiller a2 = new ArrayFiller(nums.length/2,nums.length,4);
		
		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a2);
		
		start = System.currentTimeMillis();
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		
		long result2 = end - start;
		
		printArray();
		System.out.println(result1);
		System.out.println(result2);
		
		/*ExmpleThread ex1 = new ExmpleThread(7);
		ExmpleThread ex2 = new ExmpleThread(888);
		Thread ex1Thread = new Thread(ex1);
		Thread ex2Thread = new Thread(ex2);
		
		Thread firstThread = new Thread();
		Thread secondThread = new Thread();*/

		//firstThread.
		/*
		ex1Thread.start();
		ex2Thread.start();
		*/
		
	}
	
	

}
