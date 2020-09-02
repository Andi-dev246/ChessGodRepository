package player;

import board.Position;
import exceptions.InvalidMoveException;

public interface Player {
	
	public void movePiece(Position start, Position end) throws InvalidMoveException;
	
	public boolean isInCheck();
	
	public boolean isCheckmate();
	
	public boolean isStalemate();
}
