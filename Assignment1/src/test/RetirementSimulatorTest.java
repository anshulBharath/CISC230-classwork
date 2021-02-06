package test;

import java.util.Scanner;

/**
 * This is the first Assignment of CISC 230. This Assignment serves as a refresher
 * of some of the content learned in CISC 131 and an introduction to some OOP concepts.
 * This class serves as a retirement simulator.
 * 
 * The class has 3 primary method that are utilized in the main method: userInputs(), runSimulation(), and printResult().
 * The remaining method are used as helper methods for the primary methods.
 * 
 * @author Anshul Bharath
 *
 */
public class RetirementSimulatorTest {
	/**
	 * The scanner variable for input
	 */
	private static Scanner input; 
	
	/**
	 * Keeps track of the current account value at the given year
	 */
	private static Double curAccountValue; 
	/**
	 * Keeps track of the current salary at the given year
	 */
	private static Double curSalary; 
	/**
	 * The number of years until retirement that the user entered
	 */
	private static int yearsUntilRetirement; 
	
	/**
	 * Two element array containing the min and max of the percent salary saved
	 */
	private static Double[] salaryRange = new Double[2]; 
	/**
	 * Two element array containing the min and max of the returns anticipated
	 */
	private static Double[] returnRange = new Double[2]; 
	/**
	 * Two element array containing the min and max of the raise anticipated
	 */
	private static Double[] raiseRange = new Double[2]; 
	
	/**
	 * An array that keeps track of the account value each year starting with year 0
	 */
	private static Double[] yearlyAccountValue; 
	/**
	 * An array that keeps track of the salary each year starting with year 0
	 */
	private static Double[] yearlySalary; 
	
	/**
	 * An array that keeps track of the simulated salary saved values
	 */
	private static Double[] yearlySalarySavedValues; 
	/**
	 * An array that keeps track of the yearly return values
	 */
	private static Double[] yearlyReturnValues; 
	/**
	 * An array that keeps track of the simulated raise values
	 */
	private static Double[] yearlyRaiseValues; 
	
	
	/**
	 * The main method. Runs the three main functions: userInputs(), runSimulation(), printResults()
	 * @param args
	 */
	public static void main(String[] args) {
		
		userInputs();
		runSimulation();
		printResults();
	}
	
	/**
	 * This method takes in the initial values of the retirement simulator from the user
	 * Each  
	 */
	private static void userInputs() {
		input = new Scanner(System.in);
		
		getInitialInvestment(); //Prompts the user for the initial investment
		getInitialSalary(); //Prompts the user for the initial salary
		getPercentSalarySavedRange(); //Prompts the user for the percent salary saved range
		getPercentReturnRange(); //Prompts the user for the percent return range
		getPercentRaiseRange(); //Prompts the user for the percent raise range
		getYearsUntilRetirement(); //Prompts the user for number of years until retirement
		
		input.close();
	}
	
	/**
	 * Runs the simulation over yearsUntilRetirement years
	 */
	private static void runSimulation() {
		
		instantiateArrays(); //Creates all the class arrays that keep track of values using the yearsUntilRetirement for the size 
		simulate(); //The method that does all the calculations for the simulator
	}
	
	/**
	 * Prints all the data specified by the homework requirements
	 */
	private static void printResults() {
		
		printEnteredValues(); //Prints all the values that the user entered
		printSimulatedValues(); //Prints the simulated results
		makeHistogram(); //Prints the formated histogram
	}

	//Start of helper methods
	
	/**
	 * Prompts the user for the initial investment
	 */
	private static void getInitialInvestment() {

		Double initInvest;
		
		System.out.print("Please enter the current amount you have in your retirement account: ");
		initInvest = input.nextDouble();
		curAccountValue = initInvest;
		while(initInvest < 0) {
			System.out.print("ERROR: The retirement account balance must be zero or greater. Please re-enter your current amount you have in your retirement account: ");
			initInvest = input.nextDouble();
			curAccountValue = initInvest;
		}
		
	}

	/**
	 * Prompts the user for the initial salary
	 */
	private static void getInitialSalary() {
		Double initSal;
		
		System.out.print("Please enter your current salary: ");
		initSal = input.nextDouble();
		curSalary = initSal;
		while(initSal < 0) {
			System.out.print("ERROR: The initial salary must be zero or greater. Please re-enter your current salary: ");
			initSal = input.nextDouble();
			curSalary = initSal;
		}
	}
	
	/**
	 * Prompts the user for the min and max of the percent salary saved 
	 */
	private static void getPercentSalarySavedRange() {
		Double min;
		Double max;
		
		System.out.print("As a percentage of salary, please enter the minimum amount you plan to save for retirement in any given year: ");
		min = input.nextDouble();
		salaryRange[0] = min;
		while(min < 0) {
			System.out.print("ERROR: The percentage of salary investment minimum must be zero or greater. Please re-enter your minimum salary investment as a percentage: ");
			min = input.nextDouble();
			salaryRange[0] = min;
		}
		
		System.out.print("As a percentage of salary, please enter the maximum amount you plan to save for retirement in any given year: ");
		max = input.nextDouble();
		salaryRange[1] = max;
		while(max <= min) {
			System.out.print("ERROR: The percentage of salary investment maximum must be greater than the minimum. Please re-enter your maximum salary investment as a percentage: ");
			max = input.nextDouble();
			salaryRange[1] = max;
		}
		
	}

	/**
	 * Prompts the user for the min and max of the percent return
	 */
	private static void getPercentReturnRange() {
		Double min;
		Double max;
		
		System.out.print("As a percentage, please enter the expected minimum yearly return for your investments (This can be a negative Value): ");
		min = input.nextDouble();
		returnRange[0] = min;
		
		System.out.print("As a percentage, please enter the expected maximum yearly return for your investments (This can be a negative Value): ");
		max = input.nextDouble();
		returnRange[1] = max;
		while(max <= min) {
			System.out.print("ERROR: The percentage of salary investment maximum must be greater than the minimum. Please re-enter your maximum salary investment as a percentage (This can be a negative Value): ");
			max = input.nextDouble();
			returnRange[1] = max;
		}
	}

	/**
	 * Prompts the user for the min and max of the percent raise
	 */
	private static void getPercentRaiseRange() {
		Double min;
		Double max;
		
		System.out.print("As a percentage, please enter the minimum pay raise you expect to receive in any given year (This can be a negative Value): ");
		min = input.nextDouble();
		raiseRange[0] = min;
		while(min < -100) {
			System.out.print("ERROR: The expected pay raise minimum must be -100% or greater. Please re-enter your minimum pay raise as a percentage: ");
			min = input.nextDouble();
			raiseRange[0] = min;
		}
		
		System.out.print("As a percentage, please enter the maximum pay raise you expect to receive in any given year (This can be a negative Value):  ");
		max = input.nextDouble();
		raiseRange[1] = max;
		while(max <= min) {
			System.out.print("ERROR: The percentage of yearly raise maximum must be greater than the minimum. Please re-enter your maximum yearly raise as a percentage (This can be a negative Value): ");
			max = input.nextDouble();
			raiseRange[1] = max;
		}
		
		
	}

	/**
	 * Prompts the user for the int value of the years until retirement
	 */
	private static void getYearsUntilRetirement() {
		System.out.print("Please enter the number of years until retirement: ");
		yearsUntilRetirement = (int) input.nextDouble();
		while(yearsUntilRetirement < 0) {
			System.out.print("ERROR: The expected number of years until retirment must be zero or greater. Please re-enter your expected years until retirement: ");
			yearsUntilRetirement = (int) input.nextDouble(); //re-visit to see the certain way to make sure that this number is a whole integer
		}
	}

	/**
	 * Helper method for runSimulation(). Instantiates all the arrays needed for the simulation
	 * Own method required, because the size is unknown until after user input
	 */
	private static void instantiateArrays() {
		yearlyAccountValue = new Double[yearsUntilRetirement + 1];
		yearlySalary = new Double[yearsUntilRetirement + 1];
		
		yearlySalarySavedValues = new Double[yearsUntilRetirement];
		yearlyReturnValues = new Double[yearsUntilRetirement];
		yearlyRaiseValues = new Double[yearsUntilRetirement];
		
		yearlyAccountValue[0] = curAccountValue;
		yearlySalary[0] = curSalary;
	}

	/**
	 * Calculates each simulated year using the simulated values for runSimulation()
	 */
	private static void simulate() {
		Double curSimulatedRaise;
		Double curSimulatedSalarySaved;
		Double curSimulatedReturn;
		
		for(int i = 1; i <= yearsUntilRetirement; i++) {
			curSimulatedSalarySaved = getSimulatedSalaryPercent();
			curSimulatedReturn = getSimulatedReturnsPercent();
			curSimulatedRaise = getSimulatedRaisePercent();
			
			yearlyAccountValue[i] = simulateAddedValue(curSimulatedSalarySaved, curSimulatedReturn);
			yearlySalary[i] = giveRaise(curSimulatedRaise);
			
			yearlySalarySavedValues[i - 1] = curSimulatedSalarySaved;
			yearlyReturnValues[i - 1] = curSimulatedReturn;
			yearlyRaiseValues[i - 1] = curSimulatedRaise;
		}
	}
	
	/**
	 * Calculates a random raise percent given a range
	 * @return random value between specified range
	 */
	private static Double getSimulatedRaisePercent() {
		Double raise;
		
		raise = Math.random() * ((raiseRange[1] - raiseRange[0])) + raiseRange[0]; //The random class was having problems for me
		raise = Math.round(raise * 100) / 100.00;//Statement used to get two decimal places.
	
		return raise;
	}

	/**
	 * Calculates a random salary saved percent given a range
	 * @return random value between specified range
	 */
	private static Double getSimulatedSalaryPercent() {
		Double salary;
		
		salary = Math.random() * ((salaryRange[1] - salaryRange[0])) + salaryRange[0];
		salary = Math.round(salary * 100) / 100.00; //Statement used to get two decimal places.
		
		return salary;
	}
	
	/**
	 * Calculates a random return percent given a range
	 * @return random value between specified range
	 */
	private static Double getSimulatedReturnsPercent() {
		Double returns;
		
		returns = Math.random() * ((returnRange[1] - returnRange[0])) + returnRange[0];
		returns = Math.round(returns * 100) / 100.00; //Statement used to get two decimal places.
		
		return returns;
	}

	/**
	 * Calculates the return for the given year and adds or subtracts it to the current account value
	 * @param simulatedSalarySaved
	 * @param simulatedReturn
	 * @return the curAccount value for the given year 
	 */
	private static Double simulateAddedValue(Double simulatedSalarySaved, Double simulatedReturn) {
		Double returnPercent;
		
		curAccountValue = curAccountValue + (curSalary * (simulatedSalarySaved / 100.00)); //Adds the salary from the previous year
		
		if(simulatedSalarySaved < 0) {
			curAccountValue = curAccountValue - (curAccountValue * (Math.abs(simulatedSalarySaved) / 100.00)); //In the case of negative return
		}
		else {
			returnPercent = 1.0 + (simulatedReturn / 100.00);
			curAccountValue = curAccountValue * returnPercent;
		}
		curAccountValue = Math.round(curAccountValue * 100) / 100.00; //Statement used to get two decimal places.
		
		return curAccountValue;
	}
	
	/**
	 * Simulates a raise or decrease in raise for the given year
	 * @param simulatedRaise
	 * @return the new salary for the given year
	 */
	private static Double giveRaise(Double simulatedRaise) {
		Double raisePercent;
		
		if(simulatedRaise < 0) {
			curSalary = curSalary - (curSalary * (Math.abs(simulatedRaise) / 100.00)); //In the case of negative raise percent
		}	
		else {
			raisePercent = (simulatedRaise / 100.00) + 1.0;
			curSalary = curSalary * raisePercent;
		}
		
		curSalary = Math.round(curSalary * 100) / 100.00; //Statement used to get two decimal places.
		
		return curSalary;
	}
	
	/**
	 * Calculates the min value in an array. Does not count 0 as low number for histogram function
	 * @param array
	 * @return the min value of the array
	 */
	private static double getMin(Double[] array) {
		Double minVal = 100000000000.00;
		int i = 0;
		
		while(i < array.length) {
			if(array[i] < minVal) { 
				minVal = array[i];
			}
			i = i + 1;
		}
		return minVal;
	}
	
	/**
	 * Calculates the max value in an array
	 * @param array
	 * @return the max value of the array
	 */
	private static double getMax(Double[] array) {
		Double maxVal = -100000000000.00;
		int i = 0;
		
		while(i < array.length) {
			if(array[i] > maxVal) {
				maxVal = array[i];
			}
			i = i + 1;
		}
		return maxVal;
	}
	
	/**
	 * Calculates the average value in an array
	 * @param array
	 * @return the average value of the array
	 */
	private static double getAverage(Double[] array) {
		Double total = 0.0;
		Double average;
		int i = 0;
		
		while(i < array.length) {
			total = total + array[i];
			i = i + 1;
		}
		average = total / array.length;
		average = Math.round(average * 100) / 100.00;
		return average;
		
	}

	/**
	 * Helper method for printResults(). Prints the user entered values back to the user
	 */
	private static void printEnteredValues() {
		System.out.println("\nYou Entered:");
		System.out.println("Initial Investment: $" + yearlyAccountValue[0]);
		System.out.println("Initial Salary: $" + yearlySalary[0]);
		System.out.println("Yearly percentage of salary saved: " + salaryRange[0] + "% - " + salaryRange[1] + "%");
		System.out.println("Range of yearly returns: " + returnRange[0] + "% - " + returnRange[1] + "%");
		System.out.println("Yearly salary raise increase: " + raiseRange[0] + "% - " + raiseRange[1] + "%");
		System.out.println("Years until retirement: " + yearsUntilRetirement + "\n");
	}
	
	/**
	 * Helper method for printResults(). Prints simulated values, including min, max, and avg of simulated values
	 */
	private static void printSimulatedValues() {
		System.out.println("The simulation generated the following values:");
		System.out.println("Yearly percentage of salary saved-- min: " + getMin(yearlySalarySavedValues) + "% max: " + getMax(yearlySalarySavedValues) + "% average: " + getAverage(yearlySalarySavedValues) + "%");
		System.out.println("Range of yearly returns-- min: " + getMin(yearlyReturnValues) + "% max: " + getMax(yearlyReturnValues) + "% average: " + getAverage(yearlyReturnValues) + "%");
		System.out.println("Yearly percentage of salary increase-- min: " + getMin(yearlyRaiseValues) + "% max: " + getMax(yearlyRaiseValues) + "% average: " + getAverage(yearlyRaiseValues) + "%");
		System.out.println("The maximum salary used in the simulation was: $" + getMax(yearlySalary));
		System.out.println("After " + yearsUntilRetirement + " year you would have $" + curAccountValue + " in your account");
		System.out.println("");
	}

	/**
	 * Helper method for printResults(). Creates the histogram for the user.
	 */
	private static void makeHistogram() {
		int[] numHashtags = getHashtagCount(); //An array holding the number of #'s used for each value in yearlyAccountValue
		String hashtagString = "";
		
		System.out.println("Year:");
		for(int i = 0; i <= yearsUntilRetirement; i++) {
			for(int j = 0; j < numHashtags[i]; j++ ) {
				hashtagString = hashtagString + "#";
			}
			System.out.println(i + ": " + hashtagString + " ($" + yearlyAccountValue[i] + ")" );
			hashtagString = "";
		}
	}
	
	/**
	 * Helper method for makeHistogram(). Creates an array that designates the amount of hashtags that a single year will get.
	 * @return an array of ints that corresponds to the yearlyAccountValue array
	 */
	private static int[] getHashtagCount() {
		int[] hashtagCountArray = new int[yearsUntilRetirement + 1];
		Double[] temp = copyArray(yearlyAccountValue); 
		int hashtagValue = 1;
		int curIndex;
		
		for(int i = 0; i < temp.length - 1; i++) {
			if(hashtagValue > 99) {
				hashtagValue = 99;
			}
			
			curIndex = getMinIndex(temp);
			hashtagCountArray[curIndex] = hashtagValue;
			temp[curIndex] = 0.0;
			hashtagValue = hashtagValue + 1;
		}
		
		hashtagCountArray[getMaxIndex(temp)] = 100;
	
		return hashtagCountArray;
	}
	
	/**
	 * Gets the index of the minimum value of the array
	 * @param array
	 * @return the index of the minimum value
	 */
	private static int getMinIndex(Double[] array) {
		Double minVal = 100000000000.00;
		int i = 0;
		int index = -1;
		
		while(i < array.length) {
			if(array[i] < minVal && array[i] != 0.0) { 
				minVal = array[i];
				index = i;
			}
			i = i + 1;
		}
		return index;
	}
	
	/**
	 * Gets the index of the maximum value
	 * @param array
	 * @return the index of the maximum value
	 */
	private static int getMaxIndex(Double[] array) {
		Double maxVal = -100000000000.00;
		int i = 0;
		int index = -1;
		
		while(i < array.length) {
			if(array[i] > maxVal) {
				maxVal = array[i];
				index = i;
			}
			i = i + 1;
		}
		return index;
	}
	
	/**
	 * Creates a copy of an array. Method used as a safeguard for pointer issues.
	 * @param array
	 * @return the the copied array
	 */
	private static Double[] copyArray(Double[] array) {
		Double[] copy = new Double[array.length];
		
		for(int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		
		return copy;
	}

}

