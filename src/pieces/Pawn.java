package pieces;

import board.Position;
import player.ChessColor;
<<<<<<< HEAD
import player.Player;
import board.Board;
import java.util.Scanner;
=======
>>>>>>> branch 'master' of https://github.com/Andi-dev246/ChessGodRepository.git

public final class Pawn extends Piece {

	private static final long serialVersionUID = -9017915203779009904L;

	private Pawn(ChessColor color) {
		super(color, PieceType.PAWN);
	}

	public static Pawn createWhitePawn() {
		return new Pawn(ChessColor.WHITE);
	}

	public static Pawn createBlackPawn() {
		return new Pawn(ChessColor.BLACK);
	}

	@Override
	public boolean isValidPath(Position start, Position end) {
		int rowDifference, columnDifference;

		rowDifference = end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0];
		columnDifference = end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1];

		switch (this.getColor()) {
		case BLACK:
			if (this.getNumberOfMoves() == 0) {
				return (rowDifference == -1 || rowDifference == -2) && (columnDifference == 0);
			} else {
				return (rowDifference == -1) && (columnDifference == 0);
			}
		case WHITE:
			if (this.getNumberOfMoves() == 0) {
				return (rowDifference == 1 || rowDifference == 2) && (columnDifference == 0);
			} else {
				return (rowDifference == 1) && (columnDifference == 0);
			}
		default:
			return false;
		}
	}

	public boolean isValidCaptureMove(Position start, Position end) {
		int rowDifference, columnDifference;

		rowDifference = end.getPositionAsInteger()[0] - start.getPositionAsInteger()[0];
		columnDifference = Math.abs(end.getPositionAsInteger()[1] - start.getPositionAsInteger()[1]);

		switch (this.getColor()) {
		case BLACK:
			return (rowDifference == -1) && (columnDifference == 1);
		case WHITE:
			return (rowDifference == 1) && (columnDifference == 1);
		default:
			return false;
		}
	}

	private boolean isMorphPossible(Position end) {
		boolean morphPossible = true;
		int rowPosition;

		rowPosition = end.getPositionAsInteger()[0];

		switch (this.getColor()) {

		case BLACK:
			if (rowPosition == 0) {
				return morphPossible;
			}

		case WHITE:
			if (rowPosition == 7) {
				return morphPossible;
			}

		default:
			return false;
		}
	}

	public Piece pawnMorph(Board board, Position end, PieceType pieceType) {

		if (isMorphPossible(end) == true) {
			switch (this.getColor()) {

			case BLACK:

				switch (pieceType) {
				case BISHOP:
					return Bishop.createBlackBishop();
				case KNIGHT:
					return Knight.createBlackKnight();
				case QUEEN:
					return Queen.createBlackQueen();
				case ROOK:
					return Rook.createBlackRook();
				default:
					return this;
				}

			case WHITE:

				switch (pieceType) {
				case BISHOP:
					return Bishop.createBlackBishop();
				case KNIGHT:
					return Knight.createBlackKnight();
				case QUEEN:
					return Queen.createBlackQueen();
				case ROOK:
					return Rook.createBlackRook();
				default:
					return this;
				}
			}
		} else {
			return this;
		}
		return null;
	}

	@Override
	public String toString() {
		String color;
		color = (this.getColor() == ChessColor.WHITE) ? "W" : "B";
		return "P" + "(" + color + ")";
	}
}
