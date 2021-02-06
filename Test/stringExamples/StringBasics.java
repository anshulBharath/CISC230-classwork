package stringExamples;

/**
 * This is the first program of CISC 230. Going through the textbook we begin with strings
 * This will be the last time that I have to start coding from scratch. I feel this time will
 * be different.
 * 
 * @author Anshul Bharath
 *
 */

public class StringBasics 
{

	public static void main(String[] args) 
	{
		int a = 5;
		int b = 3;
		int z;
		int x;
		int y;
		
		z = a & b;
		x = a | b;
		y = a ^ b;
		
		System.out.println(z);
		System.out.println(x);
		System.out.println(y);
		System.out.println(~a);

	}

}
