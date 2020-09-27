package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Board;
import model.Piece;
import model.board.BoardImplementation;
import model.board.Position;
import model.pieces.PieceSetter;
import model.pieces.PieceType;

class RookTests {

	PieceType rook = PieceType.ROOK;
	
	@Test
	void moveUp() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("a7");
		
		Piece whiteRook = pieceSetter.setWhitePiece(rook, start);
		
		assertTrue(whiteRook.isValidMove(start, end));
	}
	
	@Test 
	void moveDown() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("b8");
		Position end = Position.createPositionFromString("b2");
		
		Piece whiteRook = pieceSetter.setWhitePiece(rook, start);
		
		assertTrue(whiteRook.isValidMove(start, end));
	}
	
	@Test
	void moveRight() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("g1");
		
		Piece whiteRook = pieceSetter.setWhitePiece(rook, start);
		
		assertTrue(whiteRook.isValidMove(start, end));
	}
	
	@Test
	void moveLeft() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("h3");
		Position end = Position.createPositionFromString("a3");
		
		Piece whiteRook = pieceSetter.setWhitePiece(rook, start);
		
		assertTrue(whiteRook.isValidMove(start, end));
	}

	@Test
	void wrongMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		Piece whiteRook = pieceSetter.setWhitePiece(rook, start);
		
		assertFalse(whiteRook.isValidMove(start, end));
	}
}
