package test;

public class delMe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {8,22,8,11,11,1,4,19,7,4,17,4,0,0,13,3,22,8,11,11,1,17,8,13,6,12,24,5,17,8,4,13,3,24,14,18,7,8,19,14,7,4,11,15};
		
		System.out.println(decrypt(array));

	}
	
	private static String decrypt(int[] mess) {
		String[] letters = {"A","B","C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",};
		String ret = "";
		
		for(int i = 0; i < mess.length; i++) {
			ret = ret + letters[mess[i]];
		}
		return ret;
	}

}
