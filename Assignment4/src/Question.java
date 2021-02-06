/**
 * This is the interface for any type of Question
 * @author Anshul Bharath
 *
 */
public interface Question {
	
	/**
	 * This method will get the question
	 * @return
	 */
	public String getQuestion();
	
	/**
	 * This method will compare the user answer to the correct answer
	 * @param ans
	 * @return true, if the two answers are correct
	 */
	public boolean isCorrect(String ans);
	
	/**
	 * This method will get the correct answer for the question
	 * @return a string representation of the correct answer
	 */
	public String getCorrectAns();
	
	/**
	 * This method will get the number of points that are associated with the question
	 * @return an int value of the points
	 */
	public int getPoints();
	

}
