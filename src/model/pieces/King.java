package model.pieces;

import model.board.Board;
import model.board.Position;
import model.player.ChessColor;

public final class King extends PieceImplementation{

	protected King(Board board, ChessColor color, Position position) {
		super(board, PieceType.KING, color, position);
	}
	
	@Override
	public boolean isValidMoveOnBoardInPrinciple(Position start, Position end) {
		int rowDifference, columnDifference;

		rowDifference = Math.abs(end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0]);
		columnDifference = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);

		return (rowDifference <= 1) && (columnDifference <= 1);
	}
}

