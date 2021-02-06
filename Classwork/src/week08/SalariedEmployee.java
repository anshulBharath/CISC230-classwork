package week08;


public class SalariedEmployee extends Employee{
	

	private double salary;
	
	public SalariedEmployee(int id, String name, double salary) {
		super(id,name);
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double calculateWeeklyPay() {
		return this.salary/52.0;
	}
	
}
