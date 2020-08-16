package pieces;

import board.Position;
import player.ChessColor;

public final class Rook extends Piece{

	private static final long serialVersionUID = 3065523308359553685L;

	private Rook(ChessColor color) {
		super(color, PieceType.ROOK);
	}
	
	public static Rook createWhiteRook() {
		return new Rook(ChessColor.WHITE);
	}
	
	public static Rook createBlackRook() {
		return new Rook(ChessColor.BLACK);
	}

	@Override
	public boolean isValidPath(Position start, Position end) {
		int rowDifference, columnDifference;
		
		rowDifference = Math.abs(end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0]);
		columnDifference = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);
		
		return (rowDifference == 0 || columnDifference == 0);
	}

	@Override
	public String toString() {
		String color;
		color = (this.getColor() == ChessColor.WHITE) ? "W" : "B";
		return "R"+"("+color+")";
	}
}
