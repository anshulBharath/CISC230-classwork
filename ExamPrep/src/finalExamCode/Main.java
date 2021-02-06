package finalExamCode;

import java.util.HashMap;
import java.util.Map;

/**
 * This class can execute any of the code written in the final exam
 * @author Anshul Bharath
 *
 */
public class Main { 
	
	public static void main(String[] args) {
		Alpha a = new Gamma();
		a.two();
	}
	
	public static boolean foo(int x) {
		return ((x>>31) & 1) == 0x1;
	}
	
	

}
