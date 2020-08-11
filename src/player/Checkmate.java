package player;

import java.util.ArrayList;

import board.Board;
import board.Position;
import board.Tile;
import pieces.Piece;

public class Checkmate {
	
	public Checkmate() throws Exception{
		throw new RuntimeException("The class Checkmate has no instance variables and a Object of the class is not meant to be created.");
	}
	
	public static boolean isWhiteKingCheckmate(Board board) {
		return isKingCheckmate(Color.WHITE, board);
	}
	
	public static boolean isBlackKingCheckmate(Board board) {
		return isKingCheckmate(Color.BLACK, board);
	}
	
	
	private static boolean isKingCheckmate(Color color, Board board) {
		
		boolean firstCondition = Check.isKingInCheck(color, board);
		boolean secondCondition = kingCanNotBeSaved(color, board);
	
		return firstCondition && secondCondition;
	}

	private static boolean kingCanNotBeSaved(Color color, Board board) {
		boolean kingCanNotBeSaved = true;
		for(Tile tile: board) {
			Piece piece = tile.getPiece();
			Position position = tile.getPosition();
			if(piece.getColor() == color && pieceOnPositionCanSaveKing(position, board)) {
				kingCanNotBeSaved = false;
				break;
			}
		}
		return kingCanNotBeSaved;
	}

	private static boolean pieceOnPositionCanSaveKing(Position position, Board board) {
		ArrayList<Position> reachablePositions = getAllReachablePositions(position, board);
		boolean pieceOnPositionCanSaveKing = false;
		for(Position endPosition: reachablePositions) {
			Board board2 = Board.createEmptyBoard();
			board2.copy(board);
			board2.setPiece(board.getPiece(position), endPosition);
			board2.setPiece(null, position);
			
			Piece dummyPiece = board.getPiece(position);
			Color pieceColor = board.getPiece(position).getColor();
			if(Check.isKingInCheck(pieceColor, board2) != true) {
				pieceOnPositionCanSaveKing = true;
				break;
			}
		}
		return pieceOnPositionCanSaveKing;
	}

	private static ArrayList<Position> getAllReachablePositions(Position position, Board board) {
		ArrayList<Position> reachablePositions = new ArrayList<Position>();
		ArrayList<Position> allPositions = Position.getAllPositionsExcept(position);
		for(Position endPosition: allPositions) {
			if(Player.isValidMove(board, position, endPosition)) {
				reachablePositions.add(endPosition);
			}
		}
		return reachablePositions;
	}
}
