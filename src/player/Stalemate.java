package player;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import board.Position;
import board.Tile;
import pieces.Piece;

public class Stalemate {

	private Stalemate() throws Exception {
		throw new RuntimeException("An Intance of stalemate object is not meant to be created.");
	}

	public static boolean isBlackKingStalemate(Board board) {
		return isKingStalemate(board, ChessColor.BLACK);
	}

	public static boolean isWhiteKingStalemate(Board board) {
		return isKingStalemate(board, ChessColor.WHITE);
	}

	private static boolean isKingStalemate(Board board, ChessColor color) {

		boolean firstCondition = !(Check.isKingInCheck(color, board));
		boolean secondCondition = noMovePossible(board, color);

		return firstCondition && secondCondition;
	}

	private static boolean noMovePossible(Board board, ChessColor color) {
		boolean noMovePossible = true;
		List<Position> allLocations = getAllLocationsOfPiecesOfColor(color, board);
		for (Position start : allLocations) {
			if (CanPieceMove(board, start)) {
				noMovePossible = false;
			}
		}
		return noMovePossible;
	}

	private static boolean CanPieceMove(Board board, Position start) {
		boolean canPieceMove = false;
		List<Position> allReachablePositions = Checkmate.getAllReachablePositions(start, board);
		Piece piece = board.getPiece(start);
		ChessColor color = piece.getColor();
		for(Position end: allReachablePositions) {
			Board board2 = Board.createEmptyBoard();
			board2.copy(board);
			board2.setPiece(piece, end);
			board2.setPiece(null, start);
			if(Check.isKingInCheck(color, board2) == false) {
				canPieceMove = true;
				break;
			}
		}
		return canPieceMove;
	}

	private static List<Position> getAllLocationsOfPiecesOfColor(ChessColor color, Board board) {
		List<Position> allLocations = new ArrayList<>();
		for(Tile tile: board) {
			if(board.getPiece(tile.getPosition()).getColor() == color) {
				allLocations.add(tile.getPosition());
			}
		}
		return allLocations;
	}

}