package week13;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Integer> mySet = new HashSet<Integer>();
		
		mySet.add(5);
		mySet.add(4);
		mySet.add(5);
		mySet.add(4);
		mySet.add(6);
		
		System.out.println(mySet.size());
	}

}
