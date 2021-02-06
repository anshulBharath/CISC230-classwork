package week13;

import java.util.Scanner;

public class NumberBuilder {
	
	public static void printDigits(Digit curDigit) {
		if(curDigit != null) {
			printDigits(curDigit.getNext());
			System.out.print(curDigit.getValue()+" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Digit start;
		start = null;
		System.out.println("Enter a single digit: ");
		int curNum = input.nextInt();
		
		while(curNum >=0) {
			Digit temp = new Digit(curNum);
			temp.setNext(start);
			start = temp;
			
			System.out.println("Enter a single digit: ");
			curNum = input.nextInt();
		}
		
		Digit temp;
		temp = start;
		
		printDigits(start);
		/*while(temp != null) {
			System.out.println(temp.getValue());
			temp = temp.getNext();
		}*/

	}

}
