package week10;

import java.util.ArrayList;

/**
 * This class is a directory for storing the name, phone number, address, and email of numerous people.
 * 
 * @author Jason Sawin
 *
 */
public class Directory {
	
	private ArrayList<Info> contacts = new ArrayList<Info>();
	

	/**
	 * This is a private nested class.  It can only be used instead Directory.
	 * It is essentially a wrapper class for all the contact information.  You can add
	 * getter and setter methods if you like though they are not necessary. 
	 *
	 */
	private class Info{
		private String name;
		private String address;
		private long phoneNumber;
		private String email;
		
		Info(String name, String address, long phoneNumber, String email){
			this.name = name;
			this.address = address;
			this.phoneNumber=phoneNumber;
			this.email = email;
		}
	}
	
	
	/**
	 * Adds a new contact to the directory
	 * @param name the full name of the contact should not already be in the directory
	 * @param address the mailing address of the contact
	 * @param phoneNumber the phone number of the contact
	 * @param email the email address of the contact
	 */
	public void addContact(String name, String address, long phoneNumber, String email) {
		if(hasContact(name)) {
			throw new NameAlreadyInDirectoryException("The name "+name+" is already used in directory");
		}
		
		Info temp = new Info(name, address, phoneNumber, email);
		this.contacts.add(temp);
	}
	
	/**
	 * Determines if the directory contains a contact for the given name
	 * @param name The name to look up in the directory	
	 * @return true if the directory cantain information for the diven name and false otherwise
	 */
	public boolean hasContact(String name) {
		for(Info inf : contacts) {
			if(inf.name.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	
	private Info getInfo(String name) {
		for(Info inf : contacts) {
			if(inf.name.equalsIgnoreCase(name)) {
				return inf;
			}
		}
		
		throw new NameNotInDirectoryException("The name "+name+" is not in the directory");
	}
	
	/**
	 * Get the address associated with the given name
	 * @param name Name of a contact in the directory
	 * @return the address associated with the given name
	 */
	public String getAddress(String name) {
		Info temp = this.getInfo(name);
		return temp.address;
	}
	
	/**
	 * Get the phone number associated with the given name
	 * @param name Name of a contact in the directory
	 * @return the phone number associated with the given name
	 */
	public long getPhone(String name) {
		return this.getInfo(name).phoneNumber;
	}

	/**
	 * Get the email associated with the given name
	 * @param name Name of a contact in the directory
	 * @return the email associated with the given name
	 */
	public String getEmail(String name) {
		return this.getInfo(name).email;
	}

	
	
	
	
}
