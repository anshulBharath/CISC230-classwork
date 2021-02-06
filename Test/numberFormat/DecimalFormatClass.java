package numberFormat;

import java.text.DecimalFormat;

public class DecimalFormatClass {

	public static void main(String[] args) {
		DecimalFormat fmt = new DecimalFormat("0.##");
		
		System.out.println(fmt.format(12.4443));

	}

}
