package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import board.Board;
import board.BoardImplementation;
import board.Position;
import pieces.Piece;
import pieces.PieceSetter;
import pieces.PieceType;

class BishopTests {
	
	PieceType bishop = PieceType.BISHOP;
	PieceType pawn = PieceType.PAWN;
	
	
	@Test
	void upLeft() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromInt(new int[] {2,3});
		Position end = 	 Position.createPositionFromInt(new int[] {0,5});
		
		Piece whiteBishop = pieceBuilder.setWhitePiece(bishop, start);
		
		assertTrue(whiteBishop.isValidMove(start, end));
	}
	
	@Test
	void upRight() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		Piece whiteBishop = pieceBuilder.setWhitePiece(bishop, start);
		
		assertTrue(whiteBishop.isValidMove(start, end));
	}
	
	@Test
	void downLeft() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("g7");
		Position end = Position.createPositionFromString("d4");
		
		Piece whiteBishop = pieceBuilder.setWhitePiece(bishop, start);
		
		assertTrue(whiteBishop.isValidMove(start, end));
	}
	
	@Test
	void downRight() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a8");
		Position end = Position.createPositionFromString("h1");
		
		Piece whiteBishop = pieceBuilder.setWhitePiece(bishop, start);
		
		assertTrue(whiteBishop.isValidMove(start, end));
	}
	
	@Test
	void nonValidPath() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h1");
		
		Piece whiteBishop = pieceBuilder.setWhitePiece(bishop, start);
		
		assertFalse(whiteBishop.isValidMove(start, end));
	}
	
	
	@Test
	void validCaptureMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		Piece whiteBishop = pieceBuilder.setWhitePiece(bishop, start);
		pieceBuilder.setBlackPiece(pawn, end);
		
		assertTrue(whiteBishop.isValidMove(start, end));
	}
	
	@Test
	void invalidCaptureMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		Piece whiteBishop = pieceBuilder.setWhitePiece(bishop, start);
		pieceBuilder.setWhitePiece(pawn, end);
		
		assertFalse(whiteBishop.isValidMove(start, end));
	}
	
	@Test 
	void invalidMoveWithPawnOnPath() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("g7");
		Position end = Position.createPositionFromString("d4");
		
		Piece whiteBishop = pieceBuilder.setWhitePiece(bishop, start);
		pieceBuilder.setWhitePiece(pawn, Position.createPositionFromString("f6"));
		
		assertFalse(whiteBishop.isValidMove(start, end));
	}
}
