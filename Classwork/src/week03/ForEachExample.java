package week03;

public class ForEachExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,2,3,4,5,6};
		int sum = 0;
		
		for(int element: array) {
			sum = sum + element;
		}
		System.out.println(sum);
		

	}

}
