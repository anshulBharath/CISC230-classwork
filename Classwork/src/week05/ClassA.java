package week05;

public class ClassA {
	
	 //
	public static int yPub = 0;
	private static int yPriv = 0;
	
	public int xPub = 5;
	private int xPriv = 5;
	
	public ClassA(int xPub, int xPriv) {
		this.xPub = xPub;
		this.xPriv = xPriv;
		
		//ClassA.yPub++;
	}
	
	public int getXPub() {
		yPub++;
		return this.xPub;
	}
	
	public void setXPub(int xPub) {
		this.xPub = xPub;
	}
	
	public int getXPriv() {
		return this.xPriv;
	}
	
	public void setXPriv(int xPriv) {
		this.xPriv = xPriv;
	}
	
	public static int getyPub() {
		return yPub;
	}

	public static void setyPub(int yPub) {
		ClassA.yPub = yPub;
	}

	public static int getyPriv() {
		return yPriv;
	}

	public static void setyPriv(int yPriv) {
		ClassA.yPriv = yPriv;
	}
	
	
	

}
