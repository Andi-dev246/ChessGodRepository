package model.pieces;

import model.Board;
import model.board.Position;
import model.player.ChessColor;

public final class Bishop extends PieceImplementation {


	public Bishop(Board board, ChessColor color, Position position) {
		super(board, PieceType.BISHOP, color, position);
	}
	
	@Override
	public boolean isValidMoveOnBoardInPrinciple(Position start, Position end) {
		int rowDifference, columnDifference;
		
		rowDifference = Math.abs(end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0]);
		columnDifference = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);
		
		return rowDifference == columnDifference;
	}
	
	@Override
	public void cloneOnBoard(Board board) {
		PieceImplementation clonedPiece = new Bishop(board, getColor(), getPosition());
		clonedPiece.setHasPieceBeenMoved(this.getHasPieceBeenMoved());
	}
}
