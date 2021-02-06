package week06;

public class PersonDriver {

	public static void main(String[] args) {
		
		Person bob = new Person(56, "Sally");
		Student sonBob = new Student(27, "Tom");
		
		System.out.println(bob.toString());
		System.out.println(sonBob.toString());
		sonBob.fakeId();
		sonBob.fakeId();
		System.out.println(sonBob.toString());
		
		
		
		
		

	}

}
