import java.util.Random;
import java.util.Scanner;

/**
 * Sample code from Lab day 1
 * @author anshul_bharath
 *
 */

public class DelMeMain {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		
		

		
		
		
		
		int total;
		
		total = 0;
		
		System.out.println("Please enter 5 different ints");
		for(int i = 1; i <= 5; i++) {
			total = input.nextInt() + total;
		}
		
		System.out.println("The sum of your numbers is: " + total);
		
		
		
		/*int total; 
		
		total = 0;
		
		for(int i = 1; i <= 100; i++) {
			total = total + i;
		}
		
		System.out.println(total);
		*/
	
	}

}
