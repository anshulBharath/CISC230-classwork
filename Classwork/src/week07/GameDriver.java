package week07;

public class GameDriver {

	public static void main(String[] args) {
		
		GameMaster gm = new GameMaster();
		Player sally = new Player("Sally");
		Player bob = new Player("Bob");
		Player sawin = new Sawin();
		
		gm.registerPlayer(sawin);
		gm.registerPlayer(sally);
		gm.registerPlayer(bob);
		
		
		gm.playGame();

	}

}
