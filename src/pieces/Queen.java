package pieces;

import board.Position;
import player.ChessColor;

public final class Queen extends Piece {

	private static final long serialVersionUID = -2622469147543093706L;

	private Queen(ChessColor color) {
		super(color, PieceType.QUEEN);
	}

	public static Queen createWhiteQueen() {
		return new Queen(ChessColor.WHITE);
	}

	public static Queen createBlackQueen() {
		return new Queen(ChessColor.BLACK);
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
		color = (this.getColor() == ChessColor.WHITE) ? "W" : "B";
		return "Q" + "(" + color + ")";
	}
}
