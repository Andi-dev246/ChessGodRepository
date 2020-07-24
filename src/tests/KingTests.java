package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import board.Position;
import pieces.King;
import pieces.Pawn;
import player.Player;

class KingTests {

	King blackKing = King.createBlackKing();
	King whiteKing = King.createWhiteKing();

	Pawn whitePawn = Pawn.createWhitePawn();
	Pawn blackPawn = Pawn.createBlackPawn();

	@Test
	void upLeft() {
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("c2");

		assertTrue(whiteKing.isValidPath(start, end));
	}

	@Test
	void upRight() {
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("e2");

		assertTrue(whiteKing.isValidPath(start, end));
	}

	@Test
	void downLeft() {
		Position start = Position.createPositionFromString("d8");
		Position end = Position.createPositionFromString("c7");

		assertTrue(whiteKing.isValidPath(start, end));
	}

	@Test
	void downRight() {
		Position start = Position.createPositionFromString("d8");
		Position end = Position.createPositionFromString("e7");

		assertTrue(whiteKing.isValidPath(start, end));
	}

	@Test
	void moveUp() {
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("d2");

		assertTrue(whiteKing.isValidPath(start, end));
	}

	@Test
	void moveDown() {
		Position start = Position.createPositionFromString("d8");
		Position end = Position.createPositionFromString("d7");

		assertTrue(whiteKing.isValidPath(start, end));
	}

	@Test
	void moveRight() {
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("e1");

		assertTrue(whiteKing.isValidPath(start, end));
	}

	@Test
	void moveLeft() {
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("c1");

		assertTrue(whiteKing.isValidPath(start, end));
	}

	@Test
	void wrongMove() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("c2");

		assertFalse(whiteKing.isValidPath(start, end));
	}

	@Test
	void validKingMove() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("c3");
		Position end = Position.createPositionFromString("c2");

		board.setPiece(whiteKing, start);

		assertTrue(Player.isValidMove(board, start, end));
	}

	@Test
	void validKingCapture() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("c3");
		Position end = Position.createPositionFromString("c2");

		board.setPiece(whiteKing, start);
		board.setPiece(blackPawn, end);

		assertTrue(Player.isValidMove(board, start, end));
	}

	@Test
	void inValidCaptureMove() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("c3");
		Position end = Position.createPositionFromString("c2");

		board.setPiece(whiteKing, start);
		board.setPiece(whitePawn, end);

		assertFalse(Player.isValidMove(board, start, end));
	}
}
