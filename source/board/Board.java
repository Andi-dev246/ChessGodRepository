package board;

import pieces.Piece;

public interface Board {
	
	public Piece getPiece(Position position);
	
	public void setPiece(Piece piece, Position position);
	
	public boolean isEmpty(Position position);
	
	public int getNumberOfTurns();
}
