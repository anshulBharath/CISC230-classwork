/**
 * This class will represent a fill in the blank question
 * @author anshul_bharath
 *
 */
public class QuestionFB implements Question {

	/**
	 * This is the string representation of the true/false question
	 */
	private String question;
	/**
	 * This is the string representation of the answer
	 */
	private String correctAnswer;
	/**
	 * This is how many points the question will be worth
	 */
	private int points;
	
	public QuestionFB(String question, String correctAnswer, int points) {
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.points = points;
	}
	
	/**
	 * This method will the string of the question
	 * @return question, the string of the question
	 */
	public String getQuestion() {
		return this.question;
	}

	/**
	 * This method will check to see if the user entered ans is equal to the correct answer
	 * @return true, if the two string match
	 */
	public boolean isCorrect(String ans) {
		return correctAnswer.equalsIgnoreCase(ans);
	}

	/**
	 * This method will get the correct answer for the question
	 * @return the correct answer
	 */
	public String getCorrectAns() {
		return this.correctAnswer;
	}

	/**
	 * This method will get the num points that the question is worth
	 * @return points, the number of points
	 */
	public int getPoints() {
		return this.points;
	}
}
