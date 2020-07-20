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
		int differenceInX_Coordinates, differenceInY_Coordinates;
		
		differenceInX_Coordinates = Math.abs(end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0]);
		differenceInY_Coordinates = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);
		
		return differenceInX_Coordinates == differenceInY_Coordinates;
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
