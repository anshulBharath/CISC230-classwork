package week02;

import java.util.Scanner;

/**
 * This class asks the user to enter a number
 * and then prints the number of 1's in the binary
 * representaion of the entered value
 * 
 * @author Anshul Bharath
 *
 */

public class MainBitCounter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		int userInput = input.nextInt();
		
		int test;
		int bitSum = 0;
		
		
		
		while(userInput != 0 ) {
			test = userInput & 1;
			bitSum = bitSum + test;
			userInput = userInput >>> 1;
		}
		
		System.out.println(bitSum);
		

	}

}
