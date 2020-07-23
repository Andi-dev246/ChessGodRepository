package player;

import java.util.ArrayList;

import board.Board;
import board.Position;
import exceptions.InvalidMoveException;
import pieces.Pawn;
import pieces.Piece;
import pieces.PieceType;

public class Player {

	private Color color;

	private Player(Color color) {
		this.color = color;
	}

	public static Player createWhitePlayer() {
		return new Player(Color.WHITE);
	}

	public static Player createBlackPlayer() {
		return new Player(Color.BLACK);
	}
	
	public static boolean isValidMove(Board board, Position start, Position end) {
		
		Piece piece = board.getPiece(start);
		
		boolean firstCondition = endPositionIsNotOccupiedByPieceOfSameColor(board, end, piece);
		boolean secondCondition = isValidPath(board, start, end);
		boolean thirdCondition = isPathClear(board, start, end);
		
		return firstCondition && secondCondition && thirdCondition;
	}

	private static boolean isValidPath(Board board, Position start, Position end) {
		Piece piece = board.getPiece(start);
		PieceType type = board.getPiece(start).getPieceType();
		switch(type) {
		case PAWN:
			if(board.isEmpty(end)) {
				return piece.isValidPath(start, end);
			} else {
				Pawn pawn = (Pawn) piece;
				return pawn.isValidCaptureMove(start, end);
			}
		default:
			return piece.isValidPath(start, end);
		}
	}

	private static boolean endPositionIsNotOccupiedByPieceOfSameColor(Board board, Position position, Piece piece) {
		if(board.isEmpty(position) == true) {
			return true;
		} else {
			return board.getPiece(position).getColor() != piece.getColor();
		}
	}

	private static boolean isPathClear(Board board, Position start, Position end) {
		Piece piece = board.getPiece(start);
		ArrayList<Position> path = piece.drawPath(start, end);
		
		boolean isPathClear = true;
		for(Position position: path) {
			if(board.isEmpty(position) != true) {
				isPathClear = false;
				break;
			}
		}
		return isPathClear;
	}
	
	public void movePiece(Board board, Position start, Position end) throws Exception{
		this.exceptionCheckPreconditions(board, start, end);
	}
	
	private void exceptionCheckPreconditions(Board board, Position start, Position end) throws Exception{
		exceptionStartAndEndPositionAreEqual(start, end);
		exceptionNoPieceOnStart(board, start);
	}
	
	private static void exceptionNoPieceOnStart(Board board, Position start) throws Exception{
		if(board.isEmpty(start)) {
			throw new InvalidMoveException("There is no piece on starting Position.");
		}
	}
	
	private static void exceptionStartAndEndPositionAreEqual(Position start, Position end) throws Exception{
		if(start.equals(end)) {
			throw new InvalidMoveException("The start and end Position are equal.");
		}
	}
}
