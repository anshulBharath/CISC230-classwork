package Inheritance;

public class Person {
	private int age;
	private String name;
	
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void eat() {
		System.out.println("nom, nom, nom");
	}
	
	public void sleep() {
		System.out.println("ZZZZzzzz");
	}

}
