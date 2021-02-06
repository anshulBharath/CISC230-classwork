package finalExamCode;

public class Student {
	
	private int yearInSchool;
	private String name;
	protected double gpa;
	
	public Student(String name, int year, double gpa) {
		
		if((year < 1 || year > 4) || (gpa < 1.0 || gpa > 4.0)) {
			IllegalArgumentException exp = new IllegalArgumentException("Invalid Data");
			throw exp;
		}
		this.yearInSchool = year;
		this.name = name;
		this.gpa = gpa;
		
	}
	
	public boolean equals(Student other) {
		return(this.yearInSchool == other.yearInSchool && this.name.equals(other.name) && this.gpa == other.gpa);
	}
	
	public int compareTo(Student other) {
		if(this.gpa == other.gpa && this.yearInSchool == other.yearInSchool) {
			return 0;
		}
		if(this.yearInSchool == other.yearInSchool) {
			if(this.gpa > other.gpa) {
				return 1;
			}
			else {
				return -1;
			}
		}
		if(this.yearInSchool > other.yearInSchool) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public Student copy() {
		return new Student(this.name, this.yearInSchool, this.gpa);
	}
	
	public String getName() {
		return this.getName();
	}
	
	public int getYear() {
		return this.getYear();
	}
	
	public Double getGPA() {
		return this.gpa;
	}

}
