package model.pieces;

import model.Board;
import model.board.Position;
import model.player.ChessColor;

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
	
	@Override
	public void cloneOnBoard(Board board) {
		PieceImplementation clonedPiece = new Rook(board, getColor(), getPosition());
		clonedPiece.setHasPieceBeenMoved(this.getHasPieceBeenMoved());
	}
}
