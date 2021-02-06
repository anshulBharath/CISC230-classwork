package week10;

public interface Resultable {

	//public final static int temp = 0;
	public int[] getResults();
	
	public Resultable copy();
	
	default public void truthBomb() {
		System.out.println("Sawin is always right!");
	}
}
