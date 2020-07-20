package pieces;

import java.io.Serializable;
import java.util.ArrayList;

import board.Position;
import player.Color;

public abstract class Piece implements Serializable {
	
	private static final long serialVersionUID = -8866279910626551589L;
	private int numberOfMoves;
	private Color color;
	protected PieceType pieceType;
	
	protected Piece(Color color, PieceType type) {
		this.color = color;
		setNumberOfMoves(0);
		this.pieceType = type;
	}
	
	public int getNumberOfMoves() {
		return numberOfMoves;
	}

	public void setNumberOfMoves(int numberOfMoves) {
		this.numberOfMoves = numberOfMoves;
	}

	public Color getColor() {
		return color;
	}

	public PieceType getPieceType() {
		return pieceType;
	}
	
	public abstract boolean isValidPath(Position start, Position end);
	
	public ArrayList<Position> drawPath(Position start, Position end) {
		return null; 
	}
	
}
