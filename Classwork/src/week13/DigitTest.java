package week13;

public class DigitTest {

	public static void main(String[] args) {
		Digit temp0 = new Digit(0);
		Digit temp1 = new Digit(1);
		Digit temp2 = new Digit(2);
		Digit temp3 = new Digit(3);
		
		temp3.setNext(temp0);
		temp2.setNext(temp3);
		temp1.setNext(temp2);
		
		while(temp0 != null) {
			System.out.println(temp0.getValue());
			temp0 = temp0.getNext();
		}

	}
	
	public static int howManyEven(Digit start) {
		int numEven = 0;
		
		do{
			if(start.getValue()%2 == 0) {
				numEven = numEven + 1;
			}
			start = start.getNext();
		}while(start != null);
		
		 return numEven;
	}

}
