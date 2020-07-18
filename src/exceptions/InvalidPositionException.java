package exceptions;

public class InvalidPositionException extends RuntimeException {

	private static final long serialVersionUID = -6826540753552877448L;

	public InvalidPositionException() {
		super("This Position is invalid.");
	}
	
	public InvalidPositionException(String string) {
		super(string);
	}
}

