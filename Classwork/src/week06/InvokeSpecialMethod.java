package week06;

public class InvokeSpecialMethod {
	
	public static void invokeMethod(Person p) {
		if(p instanceof Professor) {
			Professor temp = (Professor) p;
			temp.Grade();
		}
		
		if(p instanceof Student) {
			Student temp = (Student) p;
			temp.doHomework();
		}
		p.eat();
	}

}
