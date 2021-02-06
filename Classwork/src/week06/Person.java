package week06;

public class Person {
	
	protected int age;
	private String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void eat() {
		System.out.println("Nom, Nom, Nom");
	}
	
	public void sleep() {
		System.out.println("zzzzzzzz");
	}
	
	public void changeName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name + " is " + this.age + " years old";
	}
	

}
