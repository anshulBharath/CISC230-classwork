package finalExamCode;

public class MyException extends Exception{
	
	private static long numCreated = 0;
	
	public MyException(String message) {
		super(message);
		numCreated = numCreated + 1;
	}
	
	public long getNumCreated() {
		return MyException.numCreated;
	}

}
