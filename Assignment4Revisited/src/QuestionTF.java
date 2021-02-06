
public class QuestionTF extends QuestionTemplate {
	
	public QuestionTF(String question, String answer, int points) {
		this.question = "True/False: "+question;
		this.answer = answer;
		this.points = points;
	}
	
	public QuestionTF(String[] raw) {
		this(raw[1], raw[2], Integer.parseInt(raw[3]));
	}
	
}
