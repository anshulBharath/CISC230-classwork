package week01;

public class HelloWorldMain {

	public static void main(String[] args) {
		
		int total = 0;
		int cur = 0;
		
		do {
			total = total + cur;
			cur++;
		} while(cur <= 100);
		
		System.out.println(total);

	}

}
