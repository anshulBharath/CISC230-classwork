import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

public class Misc {

	public void method1() {
		System.out.println("How now brown cow");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int in = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(in >= 0) {
			System.out.print("Please enter your number: ");
			
			try {
				in = input.nextInt();
				if(in >= 0) {
					list.add(in);
				}
			}
			catch(InputMismatchException exp) {
				System.out.println("You entered the wrong type of information.");
				input.nextLine();
				in = 0;
			}
		}
		
		ListIterator<Integer> it = list.listIterator();
		while(it.hasNext()) {
			int i = it.next();
			System.out.println(i);
		}
		/*for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		
		
		/*Misc m = new Misc();
		m.method1();*/
	}

}
