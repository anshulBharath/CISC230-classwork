package week06;

public class Student extends Person{
	private String name;
	private int age;
	private boolean fakeId = false;
	
	public Student(int age, String name) {
		super(age, name);
		this.age = age;
		this.name = name;
	}
	
	public void doHomework() {
		System.out.println("Nah brah, letz eat instead");
		super.eat();
	}
	
	public void fakeId() {
		this.fakeId = !this.fakeId;
		age = super.age + 5;
		name = "McLovin";
	}
	
	public String toString() {
		if(fakeId) {
			return this.name + " is " + this.age + " years old";
		}
		else {
			return super.toString();
		}
	}

}
