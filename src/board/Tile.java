package board;

import java.io.Serializable;

import pieces.Piece;
import player.Color;

public class Tile implements Serializable {
	
	private static final long serialVersionUID = -5270338999414322275L;
	private Position position;
	private Color color;
	private Piece piece;
	
	private Tile (Position position, Color color, Piece piece) {
		this.setPosition(position);
		this.color = color;
		this.setPiece(piece);
	}
	
	public static Tile createEmptyTile (Position position) {
		return new Tile(position, null, null);
	}
	
	public static Tile createTakenTile (Position position, Piece piece) {
		return new Tile(position, null, piece);
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Color getColor() {
		return color;
	}
	
	public boolean isEmpty() {
		return piece == null;
	}
	
	@Override
	public String toString() {
		if(this.getPiece() == null) {
			return "0";
		}
		else {
		return this.getPiece().toString();
		}
	}
}
