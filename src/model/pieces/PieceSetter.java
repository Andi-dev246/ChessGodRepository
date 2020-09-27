package model.pieces;

import exceptions.InvalidPieceException;
import model.Board;
import model.Piece;
import model.board.Position;
import model.player.ChessColor;

public class PieceSetter {
	
	private final Board board;
	private final ChessColor white = ChessColor.WHITE;
	private final ChessColor black = ChessColor.BLACK;
	
	public PieceSetter(Board board) {
		this.board = board;
	}
	
	public Piece setWhitePiece(PieceType type, Position position) {
		switch(type) {
		case BISHOP:
			return new Bishop(board, white, position);
		case KING:
			return new King(board, white, position);
		case KNIGHT:
			return new Knight(board, white, position);
		case PAWN:
			return new Pawn(board, white, position);
		case QUEEN:
			return new Queen(board, white, position);
		case ROOK:
			return new Rook(board, white, position);
		default:
			throw new InvalidPieceException("This Piece does not exist.");
		}
	}
	
	public Piece setBlackPiece(PieceType type, Position position) {
		switch(type) {
		case BISHOP:
			return new Bishop(board, black, position);
		case KING:
			return new King(board, black, position);
		case KNIGHT:
			return new Knight(board, black, position);
		case PAWN:
			return new Pawn(board, black, position);
		case QUEEN:
			return new Queen(board, black, position);
		case ROOK:
			return new Rook(board, black, position);
		default:
			throw new InvalidPieceException("This Piece does not exist.");
		}
	}
}
