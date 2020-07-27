package player;

import board.Board;
import board.Position;
import board.Tile;
import pieces.Piece;
import pieces.PieceType;
import player.Color;
import player.Player;

public class Checkmate {
	
	public Checkmate() throws Exception{
		throw new RuntimeException("The class Checkmate has no instance and a Object of the class is not meant to be created.");
	}
	
	public static boolean isWhiteKingInCheck(Board board) {
		return isKingInCheck(Color.WHITE, board);
	}

	public static boolean isBlackKingInCheck(Board board) {
		return isKingInCheck(Color.BLACK, board);
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
}
