package week08;


/**Abstract class that provides a template for all future employee types.
 * An instance of this class cannot be created
 * @author Jason Sawin
 *
 */
public abstract class Employee {
	/**
	 * employee id number
	 * */
	private int id;
	/**
	 *full name of the employee
	 */
	private String name;

	
	/**
	 * Takes the values for the id and name attributes
	 * @param id employee id should be unique
	 * @param name full name of the employee
	 */
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
 
	/**
	 * Returns the unique id of the employee
	 * @return unique id of the employee
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the name of the employee
	 * @return	name of the employee			
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This is an abstract method (there is no body and it has the abstract keyword
	 * in its declarations).  The method is meant to be overridden by concrete subclasses 
	 * of Employee	
	 * @return the amount the employee gets pay for a week
	 */
	public abstract double calculateWeeklyPay();
	
}

