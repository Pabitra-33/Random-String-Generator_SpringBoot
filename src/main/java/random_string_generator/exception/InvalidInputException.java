package random_string_generator.exception;

@SuppressWarnings("serial")
public class InvalidInputException extends RuntimeException {
	
	//created a invalid input exception class to manage and handle those exceptions.
	public InvalidInputException(String message) {
		super(message);
	}
}