package model;

import model.board.Position;

public interface Board extends Iterable <Piece>, Cloneable{
	
	public Piece getPiece(Position position);
	
	public void setPiece(Piece piece, Position position);
	
	public boolean isEmpty(Position position);
	
	public int getNumberOfTurns();
	
	public void addToHistory();
	
	public Board getBoardInTurn(int i);
	
	public Board clone();
}
