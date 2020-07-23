package exceptions;

public class InvalidMoveException extends Exception{
	
	public InvalidMoveException() {
		super("This move is invalid.");
	}
	
	public InvalidMoveException(String string) {
		super(string);
	}
}
