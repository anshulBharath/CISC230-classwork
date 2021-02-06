
public class FlashLight extends Mobile {

	public FlashLight(Board board) {
		super(board);
	}

	public boolean isVisible() {
		return true;
	}

	public boolean share(Boardable elem) {
		return false;
	}

	public void run() {
		this.move();
	}

	protected void move() {
		boolean canMove = true;
		
		while(canMove) {
			canMove = this.board.move(Direction.DOWN, this);
		}
		this.board.removeElement(this);
		
	}
	
	public String toString() {
		return "F";
	}

}
