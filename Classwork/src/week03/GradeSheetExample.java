package week03;

import java.util.Scanner;

public class GradeSheetExample {
	
	private static Double[] grades;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int i = 0;
		Double curGrade;
		
		System.out.print("How many grades would you like to enter? ");
		
		grades = new Double[input.nextInt()];
		
		System.out.println("");
		
		while(i < grades.length) {
			System.out.println("Please enter grade # " + (i+1) + "(must be between 0 and 100)");
			curGrade = input.nextDouble();
			if(curGrade > 100 || curGrade < 0) {
				System.out.println("ERROR! Please enter a number between 0 and 100");
				grades[i] = input.nextDouble();
			}
			else {
				grades[i] = curGrade;
			}
			
			i++;
		}
		
		System.out.println(grades[grades.length - 1]);
			
		

	}
	
	

}
