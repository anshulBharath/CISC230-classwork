package week06;

import java.util.Random;

public class InstanceOfDemo {

	public static void main(String[] args) {
		Random rand = new Random();
		
		for(int i = 0; i < 15; i++) {
			int num = rand.nextInt(3);
			if(num == 0) {
				InvokeSpecialMethod.invokeMethod(new Person(20+i, "Person"+i));
			}
			else if(i == 1) {
				InvokeSpecialMethod.invokeMethod(new Student(40+i, "Student"+i));
			}
			else {
				InvokeSpecialMethod.invokeMethod(new Professor (90+i, "Professor"+i));
			}
		}

	}

}
