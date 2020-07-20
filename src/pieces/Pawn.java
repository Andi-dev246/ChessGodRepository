package pieces;

import board.Position;
import player.Color;

public final class Pawn extends Piece {

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
		int rowDifference, columnDifference;
		
		rowDifference = end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0];
		columnDifference = end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1];

		switch (this.getColor()) {
		case BLACK:
			if (this.getNumberOfMoves() == 0) {
				return (rowDifference == -1 || rowDifference == -2) && (columnDifference == 0);
			} else {
				return (rowDifference == -1) && (columnDifference == 0);
			}
		case WHITE:
			if (this.getNumberOfMoves() == 0) {
				return (rowDifference == 1 || rowDifference == 2) && (columnDifference == 0);
			} else {
				return (rowDifference == 1) && (columnDifference == 0);
			}
		default:
			return false;
		}
	}

	public boolean isValidCaptureMove(Position start, Position end) {
		int rowDifference, columnDifference;
		
		rowDifference = end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0];
		columnDifference = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);

		switch (this.getColor()) {
		case BLACK:
			return (rowDifference == -1) && (columnDifference == 1);
		case WHITE:
			return (rowDifference == 1) && (columnDifference == 1);
		default:
			return false;
		}
	}

	@Override
	public String toString() {
		String color;
		color = (this.getColor() == Color.WHITE) ? "W" : "B";
		return "P" + "(" + color + ")";
	}
}
