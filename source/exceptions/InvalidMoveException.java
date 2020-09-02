package exceptions;

public class InvalidMoveException extends Exception{
	
	private static final long serialVersionUID = 6463146758090617487L;

	public InvalidMoveException() {
		super("This move is invalid.");
	}
	
	public InvalidMoveException(String string) {
		super(string);
	}
}
