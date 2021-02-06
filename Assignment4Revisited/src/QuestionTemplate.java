
public abstract class QuestionTemplate implements Questions {
	protected String question;
	protected String answer;
	protected int points;
	
	@Override
	public String getQuestion() {
		return this.question;
	}

	@Override
	public boolean isCorrect(String ans) {
		return ans.equals(this.answer);
	}

	@Override
	public String getCorrectAns() {
		return this.answer;
	}

	@Override
	public int getPoints() {
		return this.points;
	}
}
