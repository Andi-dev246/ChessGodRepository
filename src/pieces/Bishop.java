package pieces;

import board.Position;
import player.Color;

public final class Bishop extends Piece {

	
	private static final long serialVersionUID = 7312820475446116544L;

	private Bishop(Color color) {
		super(color, PieceType.BISHOP);
	}
	
	public static Bishop createWhiteBishop() {
		return new Bishop(Color.WHITE);
	}
	
	public static Bishop createBlackBishop() {
		return new Bishop(Color.BLACK);
	}
	@Override
	public boolean isValidPath(Position start, Position end) {
		return false;
	}

	@Override
	public Position[] drawPath(Position start, Position end) {
		return null;
	}
	
	@Override
	public String toString() {
		String color;
		color = (this.getColor() == Color.WHITE) ? "W" : "B";
		return "B"+"("+color+")";
	}
}
