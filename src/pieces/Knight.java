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
		int differenceInX_Coordinates, differenceInY_Coordinates;
		
		differenceInX_Coordinates = Math.abs(end.getIntegerPosition()[0] - start.getIntegerPosition()[0]);
		differenceInY_Coordinates = Math.abs(end.getIntegerPosition()[1] - start.getIntegerPosition()[1]);
		
		return (differenceInX_Coordinates == 2 && differenceInY_Coordinates == 1) || (differenceInX_Coordinates == 1 && differenceInY_Coordinates == 2);
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
