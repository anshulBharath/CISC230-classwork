package Inheritance;

public class Driver {

	public static void main(String[] args) {
		
		Dean aDean = new Dean(4, "Sally");
		aDean.complain();
		
		Object bDean = new Dean(4, "Sally");
		//bDean.eat();
		
		Professor cDean = new Dean(4, "Sally");
		cDean.complain();
		
		Person dDean = new Dean(4, "Sally");
		dDean.eat();

	}

}
