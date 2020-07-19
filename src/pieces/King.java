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
		int differenceInX_Coordinates, differenceInY_Coordinates;

		differenceInX_Coordinates = Math.abs(end.getIntegerPosition()[0] - start.getIntegerPosition()[0]);
		differenceInY_Coordinates = Math.abs(end.getIntegerPosition()[1] - start.getIntegerPosition()[1]);

		return (differenceInX_Coordinates <= 1) && (differenceInY_Coordinates <= 1);
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

