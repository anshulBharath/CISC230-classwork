package scannerExample;

import java.util.Scanner;

public class MainScanner {

	public static void main(String[] args) {
		//This class demonstrates the use of the scanner
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an interger: ");
		int in = input.nextInt();
		
		System.out.println("You entered: " + in);
		

	}

}
