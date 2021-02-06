package week09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
	
	
	
	private void  arrayMethod() {
		int [] array = {1,2,3,4,5};
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			flag = false;
			System.out.print("Enter the index you want to print: ");
		
			try {
				int userIndex = input.nextInt();
				int x = array[userIndex];
				System.out.println("The value at "+userIndex+" is "+x);
			}catch(ArrayIndexOutOfBoundsException exp) {
				System.out.println("Your number is out of bounds.");
			}catch(InputMismatchException exp) {
				System.out.println("You entered the wrong type of information.");
				input.nextLine();
				flag=true;
			}
		}
		System.out.println("Bye!");
	}
		
	public void testMethod() {
	
		arrayMethod();
		
		System.out.println("Finishing testMethod");
	}
	
	public static void main(String[] args) {
		ExceptionDemo m = new ExceptionDemo();
		
		m.testMethod();
		
		System.out.println("Finishing main");
		
	}
	
	
	
}

