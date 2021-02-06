package midtermCode;

public class Triple {
	private int x;
	private int y;
	private int z;
	
	public Triple(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return this.z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public boolean equals(Triple trip) {
		return(this.x == trip.getX() && this.y == trip.getY() && this.z == trip.getZ());
	}
	
	public String toString() {
		return "" + this.x + ", " + this.y + ", " +  this.z;
	}

}
