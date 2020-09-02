package pieces;

import board.Board;
import board.Position;
import player.ChessColor;

public final class Queen extends PieceImplementation {


	protected Queen(Board board, ChessColor color, Position position) {
		super(board, PieceType.QUEEN, color, position);
	}

	@Override
	public boolean isValidMoveOnBoardInPrinciple(Position start, Position end) {
		int rowDifference, columnDifference;

		rowDifference = Math.abs(end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0]);
		columnDifference = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);

		boolean movesLikeARook = 	(rowDifference == 0 || columnDifference == 0);
		
		boolean movesLikeABishop = rowDifference == columnDifference;
		
		return movesLikeARook || movesLikeABishop;
	}
}
