package model.player;

import exceptions.InvalidMoveException;
import model.board.Board;
import model.board.Position;

public interface Player {
	
	public void movePiece(Position start, Position end) throws InvalidMoveException;
	
	public ChessColor getColor();
	
	public boolean isInCheck();
	
	public boolean isCheckmate();
	
	public boolean isStalemate();
	
}
