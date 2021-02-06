package test;

import java.util.ArrayList;
import java.util.Random;

public class RandomClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		double preRound = 0.0;
		double rangeMin = 0.0, rangeMax = 100;
		double value = 0.0;
		
		
		/**for(int i = 0; i < 3; i++) {
			preRound = rand.nextDouble() * 6;
			System.out.println("Prerounded: " + preRound); //Ask about getting two decimal places
			System.out.println("Rounded: " + Math.round(preRound * 100.00) / 100.00);
				//Use math.round(doubleValue * 100.0) / 100.0
		}
		**/
		
		for(int i = 0; i < 1000; i++) {
			value = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
			value = Math.round(value * 100) / 100.00;
			System.out.println(value);
		}
		
		

	}

}
