import java.util.ArrayList;

/**
 * This class will create the set of questions a user has specified
 * @author Anshul Bharath
 *
 */
public class QuestionMaker {
	/**
	 * An arraylist of question that 
	 */
	ArrayList<Question> Questions;
	
	/**
	 * The constructor of the Question maker, instantiates the Queestions arrayList
	 */
	public QuestionMaker() {
		Questions = new ArrayList<Question>();
	}
	
	/**
	 * This method will return an arralist that contains Question objects
	 * @return Questions, an arraylist of questions
	 */
	public ArrayList<Question> getQuestions(){
		this.createQuestions();
		return this.Questions;
	}
	
	/**
	 * This method will create a new FileReader object and use other helper method to parse through the user created file
	 */
	private void createQuestions() {
		FileReader reader = new FileReader();
		String curLine;
		String[] line;
		String qIndicator;
		int qNum = 1;
		
		while(reader.fileHasNextLine()) {
			curLine = reader.getNextLineOfFile();
			line = curLine.split(";");
			qIndicator = line[0];
			
			try {
				switch(qIndicator) {
				
				case "TF":
					this.parseTrueFalse(line);
					break;
				
				case "FB":
					this.parseFillInBlank(line);
					break;
				
				
				case "MC":
					this.parseMultipleChoice(line);
					break;
				}
			}
			catch(ArrayIndexOutOfBoundsException exp) {
				System.out.println("\tERROR: Question #" + qNum + " was thrown out due to formating\n");
			}
			catch(QuestionAlreadyExistsException qae) {
				System.out.println("\tERROR: Question #" + qNum + " was thrown out due to duplicate question\n");
			}
			catch(Exception exp) {
				System.out.println("\tERROR: There was an unexpected error with Question #" + qNum + "\n");
			}
			qNum = qNum + 1;
		}	
		
	}
	
	/**
	 * This method will parse through a trueFalse line of the file and parse through the data
	 * Throws an exception if there is a duplicate question
	 * @param lineArray
	 */
	private void parseTrueFalse(String[] lineArray) {
		String question = lineArray[1];
		String answer = lineArray[2];
		int points = Integer.parseInt(lineArray[3]);
		
		if(this.checkDuplicates(question)) {
			throw new QuestionAlreadyExistsException("This quesiton already exists");
		}
		else {
			this.Questions.add(new QuestionFB(question, answer, points));
		}
	}
	
	/**
	 * This method will parse through a fill in the blank line of the file and parse though the data
	 * Throws an exception if there is a duplicate question
	 * @param lineArray
	 */
	private void parseFillInBlank(String[] lineArray) {
		String question = lineArray[1];
		String answer = lineArray[2];
		int points = Integer.parseInt(lineArray[3]);
		
		if(this.checkDuplicates(question)) {
			throw new QuestionAlreadyExistsException("This quesiton already exists");
		}
		else {
			this.Questions.add(new QuestionFB(question, answer, points));
		}
		
	}
	
	/**
	 * This method will parse through the multiple choice question line
	 * Throws an exception if there is a duplicate question
	 * @param lineArray
	 */
	private void parseMultipleChoice(String[] lineArray) {
		String question = lineArray[1] + "\n";
		int numChoices = Integer.parseInt(lineArray[2]);
		int points = Integer.parseInt(lineArray[lineArray.length - 1]);
		String answer;
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int curPos = 3;
		
		//This for loop adds the choices of the MC question to the question string and keeps track of the curPos so that the answer can be tracked
		for(int i = 0; i < numChoices; i++) {
			question = question +"\t"+ letters.charAt(i) + ")" + lineArray[curPos] + "\n";
			curPos = curPos + 1;
		}		
			
		answer = lineArray[curPos];
		
		if(this.checkDuplicates(question)) {
			throw new QuestionAlreadyExistsException("This quesiton already exists");
		}
		else {	
			this.Questions.add(new QuestionMC(question, answer, points));
		}
		
	}
	
	/**
	 * This method will check for duplicate questions
	 * @param q
	 * @return true, if there is another duplicate question
	 */
	private boolean checkDuplicates(String q) {
		boolean duplicateExists = false;
		
		for(int i = 0; i<this.Questions.size(); i++) {
			if(this.Questions.get(i).getQuestion().equals(q)) {
				duplicateExists = true;
			}
		}
		
		//System.out.println("Duplicate?: "+duplicateExists);
		return duplicateExists;
	}
	
	
}
