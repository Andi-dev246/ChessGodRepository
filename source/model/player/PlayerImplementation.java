package model.player;

import exceptions.InvalidMoveException;
import model.board.Board;
import model.board.Position;
import model.pieces.Piece;
import model.pieces.PieceType;

public class PlayerImplementation implements Player {
	 
	private ChessColor color;
	private final Board board;

	private PlayerImplementation(Board board, ChessColor color) {
		this.color = color;
		this.board = board;
	}
	
	@Override
	public ChessColor getColor() {
		return color;
	}
	
	public static Player createWhitePlayer(Board board) {
		return new PlayerImplementation(board, ChessColor.WHITE);
	}
	
	public static Player createBlackPlayer(Board board) {
		return new PlayerImplementation(board, ChessColor.BLACK);
	}

	@Override
	public void movePiece(Position start, Position end) throws InvalidMoveException {
		checkPreconditions(start);
		Piece piece = board.getPiece(start);
		if(isValidPlayerMove(start, end)) {
			board.addToHistory();
			piece.move(end);
		} else {
			throw new InvalidMoveException("This Move is Invalid.");
		}
	}

	private boolean isValidPlayerMove(Position start, Position end) {
		Piece piece = board.getPiece(start);
		//TODO Check needs to be implemented as well and the condition needs to be checked.
		return piece.isValidMove(start, end);
	}

	private void checkPreconditions(Position start) throws InvalidMoveException {
		if(board.isEmpty(start)) {
			throw new InvalidMoveException("The field is empty.");
		}
		if(board.getPiece(start).getColor() != color) {
			throw new InvalidMoveException("The Piece has got the wrong color.");
		}
	}

	@Override
	public boolean isInCheck() {
		boolean isInCheck = false;
		Position kingPosition = getKingPosition();
		for(Piece piece: board) {
			Position piecePosition = piece.getPosition();
			if(piece.isValidMove(piecePosition, kingPosition)) {
				isInCheck = true;
				break;
			}
		}
		return isInCheck;
	}


	@Override
	public boolean isCheckmate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStalemate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Position getKingPosition() {
		Position kingPosition = null;
		for(Piece piece: board) {
			if(piece.getType() == PieceType.KING && piece.getColor() == color) {
				kingPosition = piece.getPosition();
				break;
			} 
		}
		return kingPosition;
	}
}
