package week13;

/**
 * This is a representation of the Digit class. A scaled down version of a linked list
 * @author Jason Sawin
 *
 */
public class Digit {
	private int value;
	private Digit next;
	
	public Digit(int value) {
		this.value = value;
		next = null;
	} 
	
	public int getValue() {
		return value;
	}
	
	public Digit getNext() {
		return next;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setNext (Digit next) {
		this.next = next;
	}

}



