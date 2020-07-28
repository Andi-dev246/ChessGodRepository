package pieces;

import java.io.Serializable;
import java.util.ArrayList;

import board.Position;
import player.Color;

public abstract class Piece implements Serializable {


	private static final long serialVersionUID = -8866279910626551589L;
	private int numberOfMoves;
	private Color color;
	protected PieceType pieceType;

	protected Piece(Color color, PieceType type) {
		this.color = color;
		setNumberOfMoves(0);
		this.pieceType = type;
	}

	public int getNumberOfMoves() {
		return numberOfMoves;
	}

	public void setNumberOfMoves(int numberOfMoves) {
		this.numberOfMoves = numberOfMoves;
	}

	public Color getColor() {
		return color;
	}

	public PieceType getPieceType() {
		return pieceType;
	}

	public abstract boolean isValidPath(Position start, Position end);

	public ArrayList<Position> drawPath(Position start, Position end) {
		ArrayList<Position> path = new ArrayList<Position>();
		// Method should return a empty list if is Valid Path is false otherwise there can be a crash in Checkmate.isKingInCheck
		if(this.isValidPath(start, end) == false) {
			return path;
		}
		
		int pathLength, rowDirection, columnDirection, rowDifference, columnDifference;

		rowDifference = end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0];
		columnDifference = end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1];

		pathLength = Math.max(Math.abs(rowDifference), Math.abs(columnDifference));

		rowDirection = (int) Math.signum(rowDifference);
		columnDirection = (int) Math.signum(columnDifference);

		for (int i = 1; i < pathLength; i++) {
			int firstCoordinatePathFinder = start.getPositionAsInteger()[0] + i * rowDirection;
			int secondCoordinatePathFinder = start.getPositionAsInteger()[1] + i * columnDirection;
			Position pathFinder = Position.createPositionFromInt(new int[] { firstCoordinatePathFinder, secondCoordinatePathFinder });
			path.add(pathFinder);
		}
		return path;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + numberOfMoves;
		result = prime * result + ((pieceType == null) ? 0 : pieceType.hashCode());
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
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		if (numberOfMoves != other.numberOfMoves)
			return false;
		if (pieceType != other.pieceType)
			return false;
		return true;
	}
}
