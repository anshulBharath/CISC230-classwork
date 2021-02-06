package test;

import java.util.Random;

public class episodePicker {

	public static void main(String[] args) {
		getEpisode(9, 24);

	}
	
	private static void getEpisode(int seasons, int episodes) {
		int retSeason;
		int retEpisode;
		Random rand = new Random();
		
		retSeason = rand.nextInt(seasons) + 1;
		retEpisode = rand.nextInt(episodes) + 1;	
		
		
		System.out.println("The generator picked: Season- " + retSeason + " episode- " + retEpisode);
	}

}
