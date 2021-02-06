package finalExamCode;

import java.util.ArrayList;

public class PublicVars {
	
	public static ArrayList<Integer> unSawin(int[] a) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		for(int i = 0; i < a.length - 1; i = i + 2) {
			for(int j = 0; j < a[i+1]; j++) {
				ret.add(a[i]);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int [] x = {2,5,3,4};
		System.out.println(unSawin(x));
	}

}
