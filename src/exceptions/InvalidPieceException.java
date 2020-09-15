package exceptions;

public class InvalidPieceException extends RuntimeException {

	private static final long serialVersionUID = -6826540753552877448L;

	public InvalidPieceException() {
		super("This Piece is invalid.");
	}
	
	public InvalidPieceException(String string) {
		super(string);
	}
}

