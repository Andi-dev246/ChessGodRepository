package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import board.Board;
import board.Position;
import pieces.Knight;
import pieces.Pawn;
import player.Player;

class KnightTests {

	Knight blackKnight = Knight.createBlackKnight();
	Knight whiteKnight = Knight.createWhiteKnight();

	Pawn whitePawn = Pawn.createWhitePawn();
	Pawn blackPawn = Pawn.createBlackPawn();

	@Test
	void upLeft() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("e7");

		assertTrue(whiteKnight.isValidPath(start, end));
	}

	@Test
	void upRight() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("g7");

		assertTrue(whiteKnight.isValidPath(start, end));
	}

	@Test
	void downLeft() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("e3");

		assertTrue(whiteKnight.isValidPath(start, end));
	}

	@Test
	void downRight() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("g3");

		assertTrue(whiteKnight.isValidPath(start, end));
	}

	@Test
	void leftUp() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("d6");

		assertTrue(whiteKnight.isValidPath(start, end));
	}

	@Test
	void leftDown() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("d4");

		assertTrue(whiteKnight.isValidPath(start, end));
	}

	@Test
	void rightUp() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h6");

		assertTrue(whiteKnight.isValidPath(start, end));
	}

	@Test
	void rightDown() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h4");

		assertTrue(whiteKnight.isValidPath(start, end));
	}

	@Test
	void wrongMove() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("c1");

		assertFalse(whiteKnight.isValidPath(start, end));
	}

	@Test
	void drawPath() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("c1");

		assertTrue(whiteKnight.drawPath(start, end).isEmpty());
	}

	@Test
	void validKnightMove() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h4");

		board.setPiece(whiteKnight, start);

		assertTrue(Player.isValidMove(board, start, end));
	}
	
	@Test
	void validKnightMoveOverAnotherPiece() {
		Board board = Board.createEmptyBoard();
		
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h4");
		
		board.setPiece(whiteKnight, start);
		board.setPiece(whitePawn, Position.createPositionFromString("g4"));
		
		assertTrue(Player.isValidMove(board, start, end));
	}

	@Test
	void isvalidCaptureMove() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h4");

		board.setPiece(whiteKnight, start);
		board.setPiece(blackPawn, end);

		assertTrue(Player.isValidMove(board, start, end));
	}

	@Test
	void isInValidCaptureMove() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h4");

		board.setPiece(whiteKnight, start);
		board.setPiece(whitePawn, end);

		assertFalse(Player.isValidMove(board, start, end));
	}
	
	
}
