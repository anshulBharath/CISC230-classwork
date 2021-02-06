import java.util.ArrayList;

/**
 * This class represents the NonRepeatingDie.
 * This class extends Die and only differs in the way that it rolls
 * @author Anshul Bharath
 *
 */
public class NonRepeatingDie extends Die {

	private ArrayList<Integer> values = new ArrayList<Integer>();
	
	 /** 
	 * Creates a NonRepeatingDie with the Die constructor
	 * @param numSides
	 * @param id
	 */
	public NonRepeatingDie(int numSides) {
		super(numSides);
	}

	/**
	 * Returns a nonrepeated roll until all the sides have been rolled
	 * @return an integer representation of the rolled side
	 */
	public int roll() {
		int roll = super.roll();
		
		while(!values.contains(roll)) {
			values.add(roll);
			return roll;
		}
		if(values.size() == super.getNumSides()) {
			values.clear();
			roll = super.roll();
			values.add(roll);
			return roll;
		}
		else {
			while(values.contains(roll)) {
				roll = super.roll();
			}
			values.add(roll);
			return roll;
		}
	}
	
}

