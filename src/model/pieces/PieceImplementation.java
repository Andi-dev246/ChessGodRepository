package model.pieces;

import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidMoveException;
import model.Board;
import model.Piece;
import model.board.Position;
import model.player.ChessColor;

public abstract class PieceImplementation implements Piece {
	
	protected final ChessColor pieceColor;
	protected final PieceType type;
	protected final Board board;
	protected boolean hasPieceBeenMoved;
	protected Position piecePosition;
	
	protected PieceImplementation (Board board, PieceType type, ChessColor pieceColor, Position position) {
		hasPieceBeenMoved = false;
		piecePosition = position;
		this.pieceColor = pieceColor;
		this.type = type;
		this.board = board;
		this.board.setPiece(this, piecePosition);
	}
	
	public boolean getHasPieceBeenMoved() {
		return hasPieceBeenMoved;
	}
	
	public void setHasPieceBeenMoved(boolean hasPieceBeenMoved) {
		this.hasPieceBeenMoved = hasPieceBeenMoved;
	}
	
	public Position getPosition() {
		return piecePosition;
	}

	protected void setPosition(Position piecePosition) {
		this.piecePosition = piecePosition;
	}

	public ChessColor getColor() {
		return pieceColor;
	}

	public PieceType getType() {
		return this.type;
	}
	
	public abstract boolean isValidMoveOnBoardInPrinciple(Position start, Position end);
	
	protected List<Position> drawPath(Position start, Position end) {
		List<Position> path = new ArrayList<Position>();
		// Method should return a empty list if isValidPathOnBoard is false otherwise there can be a crash in Checkmate.isKingInCheck
		if(this.isValidMoveOnBoardInPrinciple(start, end) == false) {
			return path;
		} else {
			int pathLength, rowDirection, columnDirection, rowDifference, columnDifference;

			rowDifference = end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0];
			columnDifference = end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1];

			pathLength = Math.max(Math.abs(rowDifference), Math.abs(columnDifference));

			rowDirection = (int) Math.signum(rowDifference);
			columnDirection = (int) Math.signum(columnDifference);

			for (int i = 1; i < pathLength; i++) {
				int firstCoordinatePathFinder = start.getPositionAsInteger()[0] + i*rowDirection;
				int secondCoordinatePathFinder = start.getPositionAsInteger()[1] + i*columnDirection;
				Position pathFinder = Position.createPositionFromInt(new int[] { firstCoordinatePathFinder, secondCoordinatePathFinder});
				path.add(pathFinder);
			}
			return path;
		}
	}
	
	public boolean isValidMove(Position start, Position end) {
		
		boolean firstCondition = endPositionIsNotOccupiedByPieceOfSameColor(end);
		boolean secondCondition = isValidMoveOnBoardInPrinciple(start, end);
		boolean thirdCondition = isPathClear(start, end);
		
		return firstCondition && secondCondition && thirdCondition;
	}
	

	public void move(Position end) throws InvalidMoveException {
		checkPreconditions(end);
		
		board.setPiece(null, piecePosition);
		board.setPiece(this, end);
		this.setPosition(end);
		hasPieceBeenMoved = true;
	}
	
	private void checkPreconditions(Position end) throws InvalidMoveException{
		//TODO is missing
	}

	private boolean isPathClear(Position start, Position end) {
		List<Position> path = this.drawPath(start, end);
		
		boolean isPathClear = true;
		for(Position position: path) {
			if(board.isEmpty(position) != true) {
				isPathClear = false;
				break;
			}
		}
		return isPathClear;
	}
	
	private boolean endPositionIsNotOccupiedByPieceOfSameColor(Position end) {
		if(board.isEmpty(end)) {
			return true;
		} else {
			return board.getPiece(end).getColor() != this.getColor();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pieceColor == null) ? 0 : pieceColor.hashCode());
		result = prime * result + ((piecePosition == null) ? 0 : piecePosition.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PieceImplementation other = (PieceImplementation) obj;
		if (pieceColor != other.pieceColor)
			return false;
		if (piecePosition == null) {
			if (other.piecePosition != null)
				return false;
		} else if (!piecePosition.equals(other.piecePosition))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
