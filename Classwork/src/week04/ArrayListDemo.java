package week04;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList<Integer> myList = new ArrayList<Integer>();
		int index = 0;
	
		Scanner input = new Scanner(System.in);
		int userInput;
		
		System.out.println("Pleaser enter a positive integer: ");
		userInput = input.nextInt();
		
		while(userInput >= 0) {
			myList.add(userInput);
			System.out.println("Please enter another positive integer, or if you are done enter a negative integer");
			userInput = input.nextInt();
		}
		
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
		
		while(!myList.isEmpty()) {
			int curVal = myList.remove(myList.size() - 1);
			System.out.println(curVal);
		}
		System.out.println();
		input.close();

	}

}
