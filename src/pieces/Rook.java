package pieces;

import board.Position;
import player.Color;

public final class Rook extends Piece{

	private static final long serialVersionUID = 3065523308359553685L;

	private Rook(Color color) {
		super(color, PieceType.ROOK);
	}
	
	public static Rook createWhiteRook() {
		return new Rook(Color.WHITE);
	}
	
	public static Rook createBlackRook() {
		return new Rook(Color.BLACK);
	}

	@Override
	public boolean isValidPath(Position start, Position end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Position[] drawPath(Position start, Position end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		String color;
		color = (this.getColor() == Color.WHITE) ? "W" : "B";
		return "R"+"("+color+")";
	}
}
