package model.pieces;

import model.board.Board;
import model.board.Position;
import model.player.ChessColor;

public final class Pawn extends PieceImplementation {

	public Pawn(Board board, ChessColor color, Position position) {
		super(board, PieceType.PAWN, color, position);
	}

	@Override
	public boolean isValidMoveOnBoardInPrinciple(Position start, Position end) {
		int rowDifference, columnDifference;
		rowDifference = end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0];
		columnDifference = end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1];

		if (board.isEmpty(end)) {
			switch (this.getColor()) {
			case BLACK:
				if (hasPieceBeenMoved) {
					return (rowDifference == -1) && (columnDifference == 0);

				} else {
					return (rowDifference == -1 || rowDifference == -2) && (columnDifference == 0);
				}
			case WHITE:
				if (hasPieceBeenMoved) {
					return (rowDifference == 1) && (columnDifference == 0);
				} else {
					return (rowDifference == 1 || rowDifference == 2) && (columnDifference == 0);
				}
			default:
				return false;
			}
		} else {
			switch (this.getColor()) {
			case BLACK:
				return (rowDifference == -1) && (columnDifference == 1);
			case WHITE:
				return (rowDifference == 1) && (columnDifference == 1);
			default:
				return false;
			}
		}
	}
}
