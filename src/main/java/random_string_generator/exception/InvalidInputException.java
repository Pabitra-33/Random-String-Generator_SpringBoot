package random_string_generator.exception;

@SuppressWarnings("serial")
public class InvalidInputException extends RuntimeException {
	
	public InvalidInputException(String message) {
		super(message);
	}
}