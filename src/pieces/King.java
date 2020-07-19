package pieces;

import board.Position;
import player.Color;

public final class King extends Piece{

	private static final long serialVersionUID = -8777701028261618727L;

	private King(Color color) {
		super(color, PieceType.KING);
	}
	
	public static King createWhiteKing() {
		return new King(Color.WHITE);
	}
	
	public static King createBlackKing() {
		return new King(Color.BLACK);
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
		return "K"+"("+color+")";
	}
}
