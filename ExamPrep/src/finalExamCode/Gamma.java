package finalExamCode;

public class Gamma extends Beta {
	public void two() {
		System.out.println("G3");
	}
	
	public void iii() {
		this.two();
		super.iii();
	}
}
