package week11;
/**
 * This is an example class for enums
 * @author anshul_bharath
 *
 */
public class EnumExample {
	
	/*public enum Company{
		EBAY, PAYPAL, GOOGLE, YAHOO, ATT
	}*/
	/*
	 * 1. Enum cannot extend anything else
	 * 2. Enum are type safe
	 * 3. Specify values. MyENum.values() will return an array of MyEnum values
	 * 4. Enum constants are implicitly static and final and can not be changed once created
	 * 5. Enum can be safely compared useing
	 * 		- Switch-case operator
	 * 		- == operator
	 * 		- .equals(( method
	 * 6. Cannot creat instance of enum by using "new" operator
	 * 7. Enum declared outside of a class cannot be marked static, final, abstract, protected, private
 	 */
	public enum Company {
		EBAY(30), PAYPAL(10), GOOGLE(15), YAHOO(20), ATT(25);
		private int value;
 
		private Company(int value) {
			this.value = value;
		}
	}
	
	public enum Direction{
		UP("w"), DOWN("x"), LEFT("a"), RIGHT("d");
		private String value;
		
		private Direction(String value) {
			this.value = value;
		}
	}
	
	public enum CrunchifyEnumCompany {
		 
		GOOGLE("G"), YAHOO("Y"), EBAY("E"), PAYPAL("P");
	 
		private String companyLetter;
	 
		private CrunchifyEnumCompany(String s) {
			companyLetter = s;
		}
	 
		public String getCompanyLetter() {
			return companyLetter;
		}
	}
	
	Company cName;
	
	public EnumExample(Company cName) {
		this.cName = cName;
	}
	
	public void companyDetails() {
		switch(cName) {
		case EBAY:
			System.out.println("Biggest Markest place in the world");
			break;
		case PAYPAL:
			System.out.println("Simplest way to manage Money");
			break;
		case GOOGLE:
        case YAHOO:
            System.out.println("YAHOO: 1st Web 2.0 Company.");
            break;

        default:
            System.out.println("DEFAULT: Google - biggest search giant.. ATT - my carrier provider..");
            break;
		}
	}
	
	public static void main(String[] args) {
        EnumExample ebay = new EnumExample(Company.EBAY);
        ebay.companyDetails();
        EnumExample paypal = new EnumExample(Company.PAYPAL);
        paypal.companyDetails();
        EnumExample google = new EnumExample(Company.GOOGLE);
        google.companyDetails();
        EnumExample yahoo = new EnumExample(Company.YAHOO);
        yahoo.companyDetails();
        EnumExample att = new EnumExample(Company.ATT);
        att.companyDetails();
        
        for (Company cName : Company.values()) {
			System.out.println("Company Value: " + cName.value + " - Company Name: " + cName);
		}
        
        CrunchifyEnumCompany.EBAY.getCompanyLetter();
    }

}
