
public class QuestionMC extends QuestionTemplate {
	
	public QuestionMC(String question, String answer, int points) {
		this.question = "Multiple Choice: "+question;
		this.answer = answer;
		this.points = points;
	}
	
	public QuestionMC(String[] raw) {
		String question = raw[1];
		int numChoices = Integer.parseInt(raw[2]);
		
		for(int i = 0; i < numChoices; i++) {
			question = question + "\n\t"+(char)('A'+i)+") "+raw[i+3];
		}
		
		this.question = question;
		this.answer = raw[raw.length - 2];
		this.points = Integer.parseInt(raw[raw.length - 1]);
	}
	
}
