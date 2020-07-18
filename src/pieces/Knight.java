package pieces;

import board.Position;
import player.Color;

public final class Knight extends Piece {

	private static final long serialVersionUID = -6116564816722111617L;

	protected Knight(Color color) {
		super(color, PieceType.KNIGHT);
	}
	
	public static Knight createWhiteKnight() {
		return new Knight(Color.WHITE);
	}
	
	public static Knight createBlackKnight() {
		return new Knight(Color.BLACK);
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
		return "Kn"+"("+color+")";
	}
}
