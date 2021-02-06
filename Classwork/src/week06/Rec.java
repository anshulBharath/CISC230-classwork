package week06;

public class Rec {

	public static int power(int base, int exp) {
		if (exp == 0)
			return 1;
        else
            return (base * power(base, exp - 1));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(2,5));

	}
	

}
