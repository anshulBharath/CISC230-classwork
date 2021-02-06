package assignment1Test;

public class RetirementSimulatorTest {

	public static void main(String[] args) {
		
		Double curAccountValue = 0.25;
		Double curSalary = 65000.55;
		Double curYearSalarySaved = 12.81;
		Double curYearReturn = 5.36;
		Double curSalaryIncrease = 4.73;
		Double valueAdded;
		
		Double[] simulationValues = new Double[29];
		
		
		
		
		for(int i = 0; i < simulationValues.length; i++) {
			valueAdded = ((curSalary * (curYearSalarySaved / 100)) + curAccountValue) * (curYearReturn / 100.00);
			System.out.println(valueAdded);
			curAccountValue = curAccountValue + valueAdded;
			curSalary = curSalary + (curSalary * (curSalaryIncrease / 100));
			//System.out.println(curSalary);
			simulationValues[i] = curAccountValue;

		}
		
		System.out.println("---------------");
		
		for(int i = 0; i < simulationValues.length; i++) {
			System.out.println(simulationValues[i]);
		}

	}

}
