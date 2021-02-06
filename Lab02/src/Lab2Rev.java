import java.util.Scanner;

public class Lab2Rev {
	
	private static Scanner input;
	
	private static double initialInvestment;
	private static double initialSalary;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userInput();
		System.out.println("The initial investment was: " + initialInvestment);
		System.out.println("The initial salary was: " + initialSalary);
		
	

	}
	
	private static void userInput() {
		input = new Scanner(System.in);
		getInitialInvestment();
		getInitialSalary();
		
		input.close();
	}
	
	private static void getInitialInvestment() {
	
		System.out.print("Please enter the current amount you have in your retirement account: ");
		initialInvestment = input.nextDouble();
		while(initialInvestment < 0) {
			System.out.print("ERROR: The retirement account balance must be zero or greater. Please re-enter your current amount you have in your retirement account: ");
			initialInvestment = input.nextDouble();
		}
	}
	
	private static void getInitialSalary() {
		System.out.print("Please enter your initial salary: ");
		initialSalary = input.nextDouble();
		while(initialSalary < 0) {
			System.out.print("ERROR: The retirement account balance must be zero or greater. Please re-enter your current amount you have in your retirement account: ");
			initialSalary = input.nextDouble();
		}
	}

}
