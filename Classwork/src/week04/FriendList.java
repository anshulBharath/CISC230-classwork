package week04;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendList {

	/**
	 * An arraylist that contains string values of 
	 */
	private ArrayList<String> names; 
	
	public FriendList() {
		names = new ArrayList<String>();
	}
	
	public void addFriend() {
		Scanner input = new Scanner(System.in);
		String userInput = "";
		String name;
		
		System.out.print("Please enter your friend's name or type \"end\": ");
		userInput = input.nextLine();
		
		while(!userInput.equals("end")) {
			names.add(userInput);
			System.out.print("Please enter your friend's name or type \"end\": ");
			userInput = input.nextLine();
			
		}
		input.close();
	}
	
	public String getFriend(int index) {
		return names.get(index);
	}
	
	public int getNumFriends() {
		return names.size();
	}
	
	public String toString() {
		String ret = "Here are your friends: \n";
		
		for(int i = 0; i < names.size(); i++) {
			ret = ret + (i + 1) + ": " + names.get(i) + "\n";
		}
		
		return ret;
	}
	
	

}
