package board;

import java.io.Serializable;

import pieces.Piece;
import player.ChessColor;

public class Tile implements Serializable {

	private static final long serialVersionUID = -5270338999414322275L;
	private Position position;
	private Piece piece;

	private Tile(Position position, Piece piece) {
		this.setPosition(position);
		this.setPiece(piece);
	}

	public static Tile createEmptyTile(Position position) {
		return new Tile(position, null);
	}

	public static Tile createTakenTile(Position position, Piece piece) {
		return new Tile(position, piece);
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

	public static ChessColor getColor(Position position) {
		int sum = position.getPositionAsInteger()[0] + position.getPositionAsInteger()[1];
		if (sum % 2 == 0) {
			return ChessColor.BLACK;
		} else {
			return ChessColor.WHITE;
		}
	}

	public boolean isEmpty() {
		return piece == null;
	}

	@Override
	public String toString() {
		if (this.getPiece() == null) {
			return "0";
		} else {
			return this.getPiece().toString();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((piece == null) ? 0 : piece.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (piece == null) {
			if (other.piece != null)
				return false;
		} else if (!piece.equals(other.piece))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

}