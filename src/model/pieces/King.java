package model.pieces;

import exceptions.InvalidMoveException;
import model.Board;
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

		return (rowDifference <= 1) && (columnDifference <= 1) || isValidRochade(start, end);
	}
	
	@Override
	public void move(Position end) throws InvalidMoveException {
		if(isValidRochade(this.getPosition(), end)) {
			Position rookStartPositionInRochade = getRookPositionInRochade(this.getPosition(), end);
			Position rookEndPositionInRochade = this.drawPath(this.getPosition(), end).get(0);
			PieceImplementation rook = (PieceImplementation) board.getPiece(rookStartPositionInRochade);
			
			//Move King
			super.move(end);
			
			//Move Rook
			board.setPiece(rook,rookEndPositionInRochade);
			board.setPiece(null, rookStartPositionInRochade);
			rook.setHasPieceBeenMoved(true);
			rook.setPosition(rookEndPositionInRochade);
			
		} else {
			super.move(end);
		}
	}
	
	private boolean isValidRochade(Position start, Position end) {
		return areStartAndEndPositionValidForRochade(start, end) && haveKingAndRockNotBeenMoved(start, end) && isPathClearAndSafeForRochade(start, end);
	}

	private boolean areStartAndEndPositionValidForRochade(Position start, Position end) {
		if(pieceColor == ChessColor.WHITE) {
			return start.equals(Position.createPositionFromString("e1")) && (end.equals(Position.createPositionFromString("c1")) || end.equals(Position.createPositionFromString("g1")));
		} else {
			return start.equals(Position.createPositionFromString("e8")) && (end.equals(Position.createPositionFromString("c8")) || end.equals(Position.createPositionFromString("g8")));
		}
	}

	private boolean isPathClearAndSafeForRochade(Position start, Position end) {
		//TODO method is not yet implemented
		return true;
	}

	private boolean haveKingAndRockNotBeenMoved(Position start, Position end) {
		Position rookPosition = getRookPositionInRochade(start, end);
		return !hasPieceBeenMoved && hasRockBeenMoved(rookPosition);
	}

	private boolean hasRockBeenMoved(Position rookPosition) {
		return !board.isEmpty(rookPosition) && !((PieceImplementation)board.getPiece(rookPosition)).getHasPieceBeenMoved();
	}
	
	private Position getRookPositionInRochade(Position start, Position end) {
		int row = start.getPositionAsInteger()[0];
		if(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1] > 0) {
			return Position.createPositionFromInt(new int[] {row, 7});
		} else {
			return Position.createPositionFromInt(new int[] {row, 0});
		}
	}
	
	@Override
	public void cloneOnBoard(Board board) {
		PieceImplementation clonedPiece = new King(board, getColor(), getPosition());
		clonedPiece.setHasPieceBeenMoved(this.getHasPieceBeenMoved());
	}
}

