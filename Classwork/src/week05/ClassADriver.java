package week05;

public class ClassADriver {

	public static void main(String[] args) {
		
		ClassA myClass = new ClassA(6,2);
		ClassA myClass2 = new ClassA(7,6);
		
		
		System.out.println("The public variable is " + myClass.getXPub() + "The public static public is " + ClassA.yPub);
		System.out.println("The public variable is " + myClass2.getXPub() + "The public static public is " + ClassA.yPub);

	}

}
