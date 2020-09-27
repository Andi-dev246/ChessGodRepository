package model.pieces;

import java.util.Collections;
import java.util.List;

import model.Board;
import model.board.Position;
import model.player.ChessColor;

public final class Knight extends PieceImplementation {


	protected Knight(Board board, ChessColor color, Position position) {
		super(board, PieceType.KNIGHT, color, position);
	}
	
	@Override
	public boolean isValidMoveOnBoardInPrinciple(Position start, Position end) {
		int rowDifference, columnDifference;
		
		rowDifference = Math.abs(end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0]);
		columnDifference = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);
		
		return (rowDifference == 2 && columnDifference == 1) || (rowDifference == 1 && columnDifference == 2);
	}
	
	@Override
	public List<Position> drawPath(Position start, Position end) {
		return Collections.emptyList();
	}
}
