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
		int differenceInX_Coordinates, differenceInY_Coordinates;
		
		differenceInX_Coordinates = Math.abs(end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0]);
		differenceInY_Coordinates = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);
		
		return (differenceInX_Coordinates == 0 || differenceInY_Coordinates == 0);
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
