package numberFormat;

import java.text.NumberFormat;

public class NumberFormatClass {

	public static void main(String[] args) {
		NumberFormat fm1 = NumberFormat.getCurrencyInstance();
		NumberFormat fm2 = NumberFormat.getPercentInstance();
		
		System.out.println(fm1.format(10));
		System.out.println(fm2.format(.423));

	}

}
