/**
 * This exception will be thrown if the question already exists
 * @author Anshul Bharath
 *
 */
public class QuestionAlreadyExistsException extends IllegalArgumentException {

	public QuestionAlreadyExistsException (String message) {
		super(message);
	}
}
