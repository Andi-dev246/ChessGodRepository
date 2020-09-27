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

class KingTests {

	PieceType king = PieceType.KING;
	PieceType pawn = PieceType.PAWN;


	@Test
	void upLeft() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("c2");
		
		Piece whiteKing = pieceBuilder.setWhitePiece(king, start);

		assertTrue(whiteKing.isValidMove(start, end));
	}

	@Test
	void upRight() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("e2");

		Piece whiteKing = pieceBuilder.setWhitePiece(king, start);

		assertTrue(whiteKing.isValidMove(start, end));
	}

	@Test
	void downLeft() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("d8");
		Position end = Position.createPositionFromString("c7");

		Piece whiteKing = pieceBuilder.setWhitePiece(king, start);

		assertTrue(whiteKing.isValidMove(start, end));
	}

	@Test
	void downRight() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("d8");
		Position end = Position.createPositionFromString("e7");

		Piece whiteKing = pieceBuilder.setWhitePiece(king, start);

		assertTrue(whiteKing.isValidMove(start, end));
	}

	@Test
	void moveUp() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("d2");

		Piece whiteKing = pieceBuilder.setWhitePiece(king, start);

		assertTrue(whiteKing.isValidMove(start, end));
	}

	@Test
	void moveDown() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("d8");
		Position end = Position.createPositionFromString("d7");

		Piece whiteKing = pieceBuilder.setWhitePiece(king, start);

		assertTrue(whiteKing.isValidMove(start, end));
	}

	@Test
	void moveRight() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("e1");

		Piece whiteKing = pieceBuilder.setWhitePiece(king, start);

		assertTrue(whiteKing.isValidMove(start, end));
	}

	@Test
	void moveLeft() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("c1");

		Piece whiteKing = pieceBuilder.setWhitePiece(king, start);

		assertTrue(whiteKing.isValidMove(start, end));
	}

	@Test
	void wrongMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("c2");

		Piece whiteKing = pieceBuilder.setWhitePiece(king, start);

		assertFalse(whiteKing.isValidMove(start, end));
	}

	@Test
	void validKingCapture() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("c3");
		Position end = Position.createPositionFromString("c2");

		Piece whiteKing = pieceBuilder.setWhitePiece(king, start);
		pieceBuilder.setBlackPiece(pawn, start);

		assertTrue(whiteKing.isValidMove(start, end));
	}

	@Test
	void invalidCaptureMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceBuilder = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("c3");
		Position end = Position.createPositionFromString("c2");

		Piece whiteKing = pieceBuilder.setWhitePiece(king, start);
		pieceBuilder.setWhitePiece(pawn, start);

		assertTrue(whiteKing.isValidMove(start, end));
	}
}
