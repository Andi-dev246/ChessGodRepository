package pieces;

import board.Position;
import player.Color;

public final class Queen extends Piece{

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
		return "Q"+"("+color+")";
	}
}
