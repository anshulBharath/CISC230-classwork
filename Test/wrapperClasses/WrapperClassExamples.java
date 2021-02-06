package wrapperClasses;

public class WrapperClassExamples {

	public static void main(String[] args) {
		
		Integer myInt = new Integer(42);
		Double myDouble = new Double(421.12);
		int num = Integer.parseInt("4321");
		
		System.out.println(myInt);
		System.out.println(myDouble);
		System.out.println(myDouble.intValue()); //Another way of casting?
		System.out.println(num);
		
		/*
		 * All primitive types have a wrapper class to convert to an object with more functionality.
		 * The naming convention is fairly similar to the name of the primitive in question.
		 * for more information see pg 309 in the Lewis and Loftus textbook.
		 */

	}

}
