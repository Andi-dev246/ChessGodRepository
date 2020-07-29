package player;

import board.Board;
import board.Position;
import board.Tile;
import pieces.PieceType;

public class Check {
	
	public Check() {
		throw new RuntimeException("The class Check is not meant to be created.");
	}

	public static boolean isWhiteKingInCheck(Board board) {
		return isKingInCheck(Color.WHITE, board);
	}

	public static boolean isBlackKingInCheck(Board board) {
		return isKingInCheck(Color.BLACK, board);
	}
	
	protected static boolean isKingInCheck(Color color, Board board) {
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
}
