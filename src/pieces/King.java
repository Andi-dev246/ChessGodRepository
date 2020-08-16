package pieces;

import board.Position;
import player.ChessColor;

public final class King extends Piece{

	private static final long serialVersionUID = -8777701028261618727L;

	private King(ChessColor color) {
		super(color, PieceType.KING);
	}
	
	public static King createWhiteKing() {
		return new King(ChessColor.WHITE);
	}
	
	public static King createBlackKing() {
		return new King(ChessColor.BLACK);
	}
	
	@Override
	public boolean isValidPath(Position start, Position end) {
		int rowDifference, columnDifference;

		rowDifference = Math.abs(end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0]);
		columnDifference = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);

		return (rowDifference <= 1) && (columnDifference <= 1);
	}
	
	@Override
	public String toString() {
		String color;
		color = (this.getColor() == ChessColor.WHITE) ? "W" : "B";
		return "K"+"("+color+")";
	}
}

