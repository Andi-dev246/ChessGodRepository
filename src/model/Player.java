package model;

import exceptions.InvalidMoveException;
import model.board.Position;
import model.player.ChessColor;

public interface Player extends Cloneable {
	
	public void movePiece(Position start, Position end) throws InvalidMoveException;
	
	public ChessColor getColor();
	
	public boolean isInCheck();
	
	public boolean isCheckmate();
	
	public boolean isStalemate();
	
}
