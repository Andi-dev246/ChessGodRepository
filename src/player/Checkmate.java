package player;

import java.util.ArrayList;

import board.Board;
import board.Position;
import board.Tile;
import pieces.Piece;
import pieces.PieceType;

public class Checkmate {
	
	public Checkmate() throws Exception{
		throw new RuntimeException("The class Checkmate has no instance variables and a Object of the class is not meant to be created.");
	}
	
	public static boolean isWhiteKingInCheck(Board board) {
		return isKingInCheck(Color.WHITE, board);
	}

	public static boolean isBlackKingInCheck(Board board) {
		return isKingInCheck(Color.BLACK, board);
	}
	
	public static boolean isWhiteKingCheckmate(Board board) {
		return isKingCheckmate(Color.WHITE, board);
	}
	
	public static boolean isBlackKingCheckmate(Board board) {
		return isKingCheckmate(Color.BLACK, board);
	}
	
	
	private static boolean isKingInCheck(Color color, Board board) {
		Position kingPosition = positionOfKingOfColor(color, board);
		boolean isKingInCheck = false;
		
		for(Tile tile: board) {
			Position piecePosition = tile.getPosition();
			if(Player.isValidMove(board, piecePosition, kingPosition)) {
				isKingInCheck = true;
				break;
			}
		}
		
		return isKingInCheck;
	}

	private static Position positionOfKingOfColor(Color color, Board board) {
		Position kingPosition = null;
		for(Tile tile: board) {
			if(tile.getPiece().getPieceType() == PieceType.KING && tile.getPiece().getColor() == color) {
				kingPosition = tile.getPosition();
				break;
			}
		}
		return kingPosition;
	}
	
	private static boolean isKingCheckmate(Color color, Board board) {
		
		boolean firstCondition = isKingInCheck(color, board);
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
			Board board2 = board.copy();
			board2.setPiece(board.getPiece(position), endPosition);
			board2.setPiece(null, position);
			
			Color pieceColor = board.getPiece(position).getColor();
			if(Checkmate.isKingInCheck(pieceColor, board2) != true) {
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
