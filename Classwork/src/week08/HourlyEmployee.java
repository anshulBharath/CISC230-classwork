package week08;

public class HourlyEmployee extends Employee {
	
	/**
	 * the amount of money the employee gets paid a week
	 */
	private double hourlyRate;
	/**
	 * how many hours a week the employee works
	 */ 
	private double hoursPerWeek;
	
	/**
	 * Constructs a new HourlyEmployee 
	 * @param id unique employee id
	 * @param name the full name of the employee
	 * @param hourlyRate how much the employee earns an hour
	 * @param hoursPerWeek how many hours the employee works a week
	 */
	public HourlyEmployee(int id, String name, double hourlyRate, double hoursPerWeek) {
		super(id, name);
		this.hourlyRate = hourlyRate;
		this.hoursPerWeek = hoursPerWeek;
	}

	
	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	
	/**
	 * This was an abstract method in Employee
	 * overridden here so that it returns hourPerWeek*hourlyRate
	 * @return how much the employee earns in the week 
	 */
	public double calculateWeeklyPay() {
		return this.hourlyRate*this.hoursPerWeek;
	}

}

