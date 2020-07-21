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
		int pathLength, xDirection, yDirection, rowDifference, columnDifference;

		rowDifference = end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0];
		columnDifference = end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1];

		pathLength = Math.max(Math.abs(rowDifference), Math.abs(columnDifference));

		xDirection = (int) Math.signum(columnDifference);
		yDirection = (int) Math.signum(rowDifference);

		for (int i = 1; i < pathLength; i++) {
			int firstCoordinatePathFinder = start.getPositionAsInteger()[0] + i * xDirection;
			int secondCoordinatePathFinder = start.getPositionAsInteger()[1] + i * yDirection;
			Position pathFinder = Position
					.createPositionFromInt(new int[] { firstCoordinatePathFinder, secondCoordinatePathFinder });
			path.add(pathFinder);
		}
		return path;
	}

}
