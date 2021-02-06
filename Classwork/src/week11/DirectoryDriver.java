package week11;

public class DirectoryDriver {

	public static void main(String[] args) {
		Long startTime = System.currentTimeMillis();
		Directory contacts = new Directory();
		
		for(int i = 0; i <= 50000; i++) {
			contacts.addContact("Bob"+i, ""+i, 6129619087L, "abharath@yahoo.com");
		}
		System.out.println(contacts.getAddress("Bob50000"));
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime);

	}


}
