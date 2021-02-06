package week06;

public class DieDriver2 {

	public static void main(String[] args) {
		
		CheaterFinder finder = new CheaterFinder();
		CheaterDie cheatDie = new CheaterDie(7);
		HistoryDie histDie = new HistoryDie(7);
		Die die = new Die(7);
		
		
		finder.isCheater(cheatDie);

	}

}
