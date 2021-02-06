package week11;

import java.util.ArrayList;

public class Recursive {

	public static void main(String[] args) {
		
		int[] array = {1,2,3,2,1};
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		
		System.out.println(list);
		System.out.println(isPal(list));
		System.out.println(list);
		

	}
	
	public static boolean isPal(ArrayList<Integer> array) {
		if(array.size() == 0 || array.size() == 1) {
			return true;
		}
		boolean ret = false;
		
		if(array.get(0) == array.get(array.size()-1)) {
			int first = array.remove(0);
			int last = array.remove(array.size()-1);
			ret = isPal(array);
			array.add(0,first);
			array.add(last);
		}
		return ret;
	}

}
