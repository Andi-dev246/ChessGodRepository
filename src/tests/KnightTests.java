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

class KnightTests {

	PieceType knight = PieceType.KNIGHT;
	PieceType pawn = PieceType.PAWN;

	@Test
	void upLeft() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("e7");

		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);

		assertTrue(whiteKnight.isValidMove(start, end));
	}

	@Test
	void upRight() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("g7");

		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);

		assertTrue(whiteKnight.isValidMove(start, end));
	}

	@Test
	void downLeft() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("e3");

		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);

		assertTrue(whiteKnight.isValidMove(start, end));
	}

	@Test
	void downRight() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("g3");

		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);

		assertTrue(whiteKnight.isValidMove(start, end));
	}

	@Test
	void leftUp() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("d6");

		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);

		assertTrue(whiteKnight.isValidMove(start, end));
	}

	@Test
	void leftDown() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("d4");

		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);

		assertTrue(whiteKnight.isValidMove(start, end));
	}

	@Test
	void rightUp() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h6");

		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);

		assertTrue(whiteKnight.isValidMove(start, end));
	}

	@Test
	void rightDown() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h4");

		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);

		assertTrue(whiteKnight.isValidMove(start, end));
	}

	@Test
	void wrongMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("c1");

		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);

		assertFalse(whiteKnight.isValidMove(start, end));
	}

	@Test
	void validKnightMoveOverAnotherPiece() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("b1");
		Position end = Position.createPositionFromString("c3");
		
		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);
		pieceBuilder.setWhitePiece(pawn, Position.createPositionFromString("b2"));

		assertTrue(whiteKnight.isValidMove(start, end));
	}

	@Test
	void isvalidCaptureMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h4");

		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);
		pieceBuilder.setBlackPiece(pawn, end);

		assertTrue(whiteKnight.isValidMove(start, end));
	}

	@Test
	void isInValidCaptureMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h4");

		Piece whiteKnight = pieceBuilder.setWhitePiece(knight, start);
		pieceBuilder.setWhitePiece(pawn, end);

		assertFalse(whiteKnight.isValidMove(start, end));
	}
}
