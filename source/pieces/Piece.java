package pieces;

import board.Position;
import exceptions.InvalidMoveException;
import player.ChessColor;

public interface Piece {
	
	public PieceType getType();
	
	public ChessColor getColor();
	
	public boolean isValidMove(Position start, Position end);
	
	public void move(Position end) throws InvalidMoveException;
}
