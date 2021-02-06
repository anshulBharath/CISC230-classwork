package week10;

import java.io.IOException;
import java.sql.SQLException;

public class ThrowingExceptionDemo {

	public static void main(String[] args) throws SQLException, IOException {
		
		Object f = null;
		//throwException(f);
		method(2);

	}
	
	private static void throwException(Object c) {
		
		if(c == null) {
			NullPointerException npe = new NullPointerException("The parameter is null.");
			throw npe;
		}
	}
	
	public static void method(int x) throws SQLException, IOException{
		if(x == 1) {
			SQLException sqlExp = new SQLException("SQL Error");
			throw sqlExp;
		}
		
		if(x == 2) {
			IOException ioExp = new IOException("IO Error");
			throw ioExp;
		}
	}

}
