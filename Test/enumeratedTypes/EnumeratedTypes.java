package enumeratedTypes;

public class EnumeratedTypes {
	enum Season {Winter, Spring, Summer, Fall};
	enum Grades {A,B,C,D,E,F}

	public static void main(String[] args) {
		
		Season time;
		Grades grade;
		
		time = Season.Winter;
		grade = Grades.B;
		
		System.out.println(time);
		System.out.println(grade);
		
		System.out.println(grade.ordinal()); 
		System.out.println(grade.name()); 
	}

}
