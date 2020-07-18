package pieces;

import board.Position;
import player.Color;

public final class Pawn extends Piece{

	private static final long serialVersionUID = -9017915203779009904L;

	private Pawn(Color color) {
		super(color, PieceType.PAWN);
	}
	
	public static Pawn createWhitePawn() {
		return new Pawn(Color.WHITE);
	}
	
	public static Pawn createBlackPawn() {
		return new Pawn(Color.BLACK);
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
		return "P"+"("+color+")";
	}
}

