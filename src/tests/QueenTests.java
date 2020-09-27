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

class QueenTests {

	PieceType queen = PieceType.QUEEN;
	
	@Test
	void upLeft() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromInt(new int[] {2,3});
		Position end = 	 Position.createPositionFromInt(new int[] {0,5});
		
		Piece whiteQueen = pieceSetter.setWhitePiece(queen, start);
		
		assertTrue(whiteQueen.isValidMove(start, end));
	}
	
	@Test
	void upRight() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		Piece whiteQueen = pieceSetter.setWhitePiece(queen, start);
		
		assertTrue(whiteQueen.isValidMove(start, end));
	}
	
	@Test
	void downLeft() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("g7");
		Position end = Position.createPositionFromString("d4");
		
		Piece whiteQueen = pieceSetter.setWhitePiece(queen, start);
		
		assertTrue(whiteQueen.isValidMove(start, end));
	}
	
	@Test
	void downRight() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a8");
		Position end = Position.createPositionFromString("h1");
		
		Piece whiteQueen = pieceSetter.setWhitePiece(queen, start);
		
		assertTrue(whiteQueen.isValidMove(start, end));	}
	
	@Test
	void moveUp() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("a7");
		
		Piece whiteQueen = pieceSetter.setWhitePiece(queen, start);
		
		assertTrue(whiteQueen.isValidMove(start, end));	}
	
	@Test 
	void moveDown() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("b8");
		Position end = Position.createPositionFromString("b2");
		
		Piece whiteQueen = pieceSetter.setWhitePiece(queen, start);
		
		assertTrue(whiteQueen.isValidMove(start, end));	}
	
	@Test
	void moveRight() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("g1");
		
		Piece whiteQueen = pieceSetter.setWhitePiece(queen, start);
		
		assertTrue(whiteQueen.isValidMove(start, end));	}
	
	@Test
	void moveLeft() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("h3");
		Position end = Position.createPositionFromString("a3");
		
		Piece whiteQueen = pieceSetter.setWhitePiece(queen, start);
		
		assertTrue(whiteQueen.isValidMove(start, end));	}
	
	@Test
	void wrongMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("c2");
		
		Piece whiteQueen = pieceSetter.setWhitePiece(queen, start);
		
		assertFalse(whiteQueen.isValidMove(start, end));
	}
}
