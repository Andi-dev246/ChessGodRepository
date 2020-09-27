package model;

import exceptions.InvalidMoveException;
import model.board.Position;
import model.pieces.PieceType;
import model.player.ChessColor;

public interface Piece {
	
	public PieceType getType();
	
	public ChessColor getColor();
	
	public Position getPosition();
	
	public boolean getHasPieceBeenMoved();
	
	public void setHasPieceBeenMoved(boolean hasPieceBeenMoved);
	
	public boolean isValidMove(Position start, Position end);
	
	public void move(Position end) throws InvalidMoveException;
}
