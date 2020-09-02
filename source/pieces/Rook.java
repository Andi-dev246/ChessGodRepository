package pieces;

import board.Board;
import board.Position;
import player.ChessColor;

public final class Rook extends PieceImplementation {

	protected Rook(Board board, ChessColor color, Position position) {
		super(board, PieceType.ROOK, color, position);
	}
	
	@Override
	public boolean isValidMoveOnBoardInPrinciple(Position start, Position end) {
		int rowDifference, columnDifference;
		
		rowDifference = Math.abs(end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0]);
		columnDifference = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);
		
		return (rowDifference == 0 || columnDifference == 0);
	}
}
