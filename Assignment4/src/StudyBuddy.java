import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class will consist of the user interface for Assignment 4.
 * This main method of this class will allow the user to choose a .txt file on their machine 
 * Then the user can select any number of questions from their loaded questions and asked those questions
 * At the end of the program the user will get a summary of how they did in the study session
 * @author anshul_bharath
 *
 */
public class StudyBuddy {
	
	/**
	 * This is the scanner object that will be used for user input
	 */
	private static Scanner input = new Scanner(System.in);
	/**
	 * Score will keep track of how many points the user is getting. Will start at 0
	 */
	private int score;
	/**
	 * numCorrect will keep track of how many questions the user gets correct. Will start at 0
	 */
	private int numCorrect;
	/**
	 * numAttempted will keep track of the questions that the user attempted to answer. Will start at 0
	 * Passing a question will not impact this.
	 */
	private int numAttempted;
	
	public static void main(String[] args) {
		StudyBuddy sb = new StudyBuddy();
		sb.study();
	}
	
	/**
	 * This method call multiple helper methods to prompt the user to select a file, input how many questions they would like
	 * and continue to answer questions
	 */
	public void study() {
		
		ArrayList<Question> userLoadedQuestions;
		ArrayList<Question> questionSet;
		
		
		System.out.println("Welcome to StudyBuddy! Press enter when you are ready to select the file holding your study questions.");
		input.nextLine();
		
		QuestionMaker maker = new QuestionMaker();
		userLoadedQuestions = maker.getQuestions();
		int numQuestions;
		
		Collections.shuffle(userLoadedQuestions); //to shuffle the order
		
		if(userLoadedQuestions.size() == 0) {
			System.out.println("\nERROR: You did not load any questions. The program will not shut down...");
		}
		else {
			numQuestions = this.promptUserForNumQuestions(userLoadedQuestions);
			questionSet = this.getQuestionSet(numQuestions, userLoadedQuestions);
			this.askQuestions(questionSet);
			this.displayResults();
		}
		
	}
	
	/**
	 * This method will prompt the user to give the number of questions they want to answer from the ones that they loaded
	 * This method will not let the user enter in bad input like a string value or numQUestions larger than what they have laoded
	 * This method will set the numQuestions to all the the questions that were loaded if an unexpected error is found
	 * @param questions
	 * @return numQuestions, the number of questions that will be asked
	 */
	private int promptUserForNumQuestions(ArrayList<Question> questions) {
		int numQuestions = -1;
		
		while(numQuestions > questions.size() || numQuestions <= 0){
			System.out.println("How many questions would you like to answer?");
			
			try {
				numQuestions = input.nextInt();
				input.nextLine();
				System.out.println();
				
				if(numQuestions > questions.size()) {
					System.out.println("\n\tError: You have only loaded " + questions.size() + " questions.\n");
				}
				else if(numQuestions <= 0) {
					System.out.println("\n\tError: You have to answer at least one question.\n");
				}
			}
			catch(InputMismatchException exp) {
				System.out.println("\n\tERROR: You entered the wrong type of information.\n");
				input.nextLine();
			}
			catch(Exception exp) {
				System.out.println("\n\tERROR: There was an unexpected error. Setting number of Questions to all loaded questions\n");
				numQuestions = questions.size();
			}
			
		}
		return numQuestions;
	}
	
	/**
	 * This method will create the set of questions with the user specified size
	 * @param num
	 * @param fullSet
	 * @return temp, an arraylist with a specified size
	 */
	private ArrayList<Question> getQuestionSet(int num, ArrayList<Question> fullSet){
		ArrayList<Question> temp = new ArrayList<Question>();
		
		for(int i = 0; i < num; i++) {
			temp.add(fullSet.get(i));
		}
		return temp;
	}
	
	/**
	 * This method will ask the questions to the user from the loaded questions
	 * Entering "delay" will remove the question and place it at the end of the arraylist
	 * Entering "pass" will skip the question and not return to it
	 * @param questions
	 */
	private void askQuestions(ArrayList<Question> questions) {
		Question temp;
		String userAnswer;
		this.score = 0;
		this.numCorrect = 0;
		this.numAttempted = 0;
		
		while(questions.size() != 0) {
			temp = questions.remove(0);
			this.displayQuestion(temp);
			
			userAnswer = input.nextLine();
			
			if(userAnswer.equalsIgnoreCase("delay")){
				System.out.println("Ok, I will ask that question later\n");
				questions.add(temp);
			}
			else if(userAnswer.equalsIgnoreCase("pass")) {
				System.out.println("Ok, lets skip that one\n");
			}
			else if(temp.isCorrect(userAnswer)) {
				System.out.println("Correct! You get " + temp.getPoints() + " points!\n");
				this.score = this.score + temp.getPoints();
				this.numAttempted = this.numAttempted + 1;
				this.numCorrect = this.numCorrect + 1;
			}
			else if(!temp.isCorrect(userAnswer)) {
				System.out.println("Incorrect, the correct answer was " + temp.getCorrectAns() + ". You lose " + temp.getPoints() +" points.\n");
				this.score = score - temp.getPoints();
				this.numAttempted = this.numAttempted + 1;
			}
		}
	}
	
	/**
	 * This method will display the question to the user
	 * @param q
	 */
	private void displayQuestion(Question q) {
		System.out.println("Points: " + q.getPoints());
		System.out.println(q.getQuestion());
	}
	
	/**
	 * This method will print out the end result of the studying session
	 * If the user scores higher than a 70% they pass the study session
	 */
	private void displayResults() {
		double grade = ((double) this.numCorrect) / ((double) this.numAttempted);		
		System.out.println("Of the " + this.numAttempted + " questions that you attempted, you got "+this.numCorrect+" correct.");
		System.out.println("You earned a total of " + this.score + " point(s)");
		
		if(grade >= 0.7) {
			System.out.println("Good Job, you passed!");
		}
		else {
			System.out.println("Better luck next time!");
		}
	}
}
