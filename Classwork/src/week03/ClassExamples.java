package week03;

import java.util.Random;
import java.util.Scanner;

public class ClassExamples {
	private static int[] array;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size;
		
		do {
			System.out.println("Please enter the size of your array");
			size = scan.nextInt();
		}while(size < 1);
		
		array = new int[size];
		
		populateArray(array);
		
		
		System.out.println(numberOfOddNumbers(array));
		
	}
	
	private static void populateArray(int[] locArray) {
		array = locArray;
		
		Random rand = new Random();
		
		for(int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(201) - 100;
		}
	}
	
	private static int numberOfOddNumbers(int[] locArray) {
		int numOdd;
		array = locArray;
		
		numOdd = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] % 2 != 0) {
				numOdd = numOdd + 1;
			}
		}
		
		return numOdd;
	}
		
				
		
		/*int x = 43;
		
		System.out.println((x&1) == 1 ? "Odd" : "Even"); //Ternary operator
		*/

		/*
		if((x & 1) == 0) {
			System.out.println("Even");
		}
		else
			System.out.println("Odd");
		*/
		
	

}
