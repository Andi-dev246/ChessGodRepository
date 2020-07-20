package pieces;

import java.util.ArrayList;

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
		int rowDifference, columnDifference;
		
		rowDifference = Math.abs(end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0]);
		columnDifference = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);
		
		return (rowDifference == 2 && columnDifference == 1) || (rowDifference == 1 && columnDifference == 2);
	}

	@Override
	public ArrayList<Position> drawPath(Position start, Position end) {
		return new ArrayList<Position>();
	}
	
	@Override
	public String toString() {
		String color;
		color = (this.getColor() == Color.WHITE) ? "W" : "B";
		return "Kn"+"("+color+")";
	}
}
