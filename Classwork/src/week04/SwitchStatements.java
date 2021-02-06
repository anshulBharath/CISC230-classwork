package week04;

/**
 * Example of Switch statements
 * 
 * @author Anshul Bharath
 *
 */
public class SwitchStatements {

	public static void main(String[] args) {
		/**
		 * Switch statements only work with:
		 * - byte and Byte
		 * - short and Short
		 * - int and Integer
		 * - char and Character
		 * - enum
		 * - String
		 * 
		 * No null values are allowed
		 */

		System.out.println(exampleOfSwitch("TIGER"));
		System.out.println(exampleOfSwitchGrouping("DOG"));
	}
	
	private static String exampleOfSwitch(String animal) {
		String result;
		
		switch(animal) {
		
		case "DOG":
			result = "domestic animal";
			break;
		case "CAT":
			result = "domestic animal";
			break;
		case "TIGER":
			result = "wild animal";
			break;
		default:
			result = "unknown";
			break;
		}
		
		return result;
	}
	
	private static String exampleOfSwitchGrouping(String animal) {
		String result;
		
		switch(animal) {
		
		case "DOG":
		case "CAT":
			result = "domestic animal";
			break;
		case "TIGER":
		case "LION":
			result = "wild animal";
			break;
		default:
			result = "unknown";
			break;
		}
		
		return result;
	}
	
	private static String exampleOfSwitchVars(String animal) {
		final String dog="DOG";
		final String cat="CAT";
		String result = "";
		 
		switch (animal) {
		case dog: //compiles
		    result = "domestic animal";
		case cat: //does not compile
		    result = "feline";
		}
		
		return result;
	}
	
	/*
	private static Month newSwitchStatement(Month month) {
		var result = switch(month) {
	    case JANUARY, JUNE, JULY -> 3;
	    case FEBRUARY, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER -> 1;
	    case MARCH, MAY, APRIL, AUGUST -> 2;
	    default -> 0; 
	};
	}
	*/
	
	
	

}
