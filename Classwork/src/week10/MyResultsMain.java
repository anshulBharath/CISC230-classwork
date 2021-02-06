package week10;

public class MyResultsMain {

	public static void main(String[] args) {
		MyResultsMain m = new MyResultsMain();
		
		Resultable curResult = new MyResults();
		//m.printResults(curResult.getResults());
		Resultable otherRes = curResult.copy();
		
		int[] myRes = curResult.getResults();
		int[] otRes = otherRes.getResults();
		
		m.printResults(myRes);
		m.printResults(otRes);
		myRes[0] = -100;
		m.printResults(myRes);
		m.printResults(otRes);

	}
	
	public void printResults(int[] res) {
		for(int x: res) {
			System.out.print(x+ " ");
		}
		System.out.println();
	}

}
