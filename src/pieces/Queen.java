package pieces;

import board.Position;
import player.Color;

public final class Queen extends Piece {

	private static final long serialVersionUID = -2622469147543093706L;

	private Queen(Color color) {
		super(color, PieceType.QUEEN);
	}

	public static Queen createWhiteQueen() {
		return new Queen(Color.WHITE);
	}

	public static Queen createBlackQueen() {
		return new Queen(Color.BLACK);
	}

	@Override
	public boolean isValidPath(Position start, Position end) {
		int rowDifference, columnDifference;

		rowDifference = Math.abs(end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0]);
		columnDifference = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);

		boolean movesLikeARook = 	(rowDifference == 0 || columnDifference == 0);
		
		boolean movesLikeABishop = rowDifference == columnDifference;
		
		return movesLikeARook || movesLikeABishop;
	}

	@Override
	public String toString() {
		String color;
		color = (this.getColor() == Color.WHITE) ? "W" : "B";
		return "Q" + "(" + color + ")";
	}
}
