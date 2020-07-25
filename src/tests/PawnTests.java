package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import board.Position;
import pieces.Pawn;
import pieces.Queen;
import player.Player;

class PawnTests {

	Pawn whitePawn = Pawn.createWhitePawn();
	Pawn blackPawn = Pawn.createBlackPawn();
	Queen whiteQueen = Queen.createWhiteQueen();
	Queen blackQueen = Queen.createBlackQueen();

	@Test
	void firstBlackPawnMove() {
		Position start = Position.createPositionFromString("a7");
		Position end = Position.createPositionFromString("a5");

		assertTrue(blackPawn.isValidPath(start, end));
	}

	@Test
	void secondBlackPawnMove() {
		Position start = Position.createPositionFromString("a6");
		Position end = Position.createPositionFromString("a5");
		
		Pawn blackPawn_2 = Pawn.createBlackPawn();
		blackPawn_2.setNumberOfMoves(1);

		assertTrue(blackPawn_2.isValidPath(start, end));
	}

	@Test
	void wrongSecondBlackPawnMove() {
		Position start = Position.createPositionFromString("a6");
		Position end = Position.createPositionFromString("a4");
		
		Pawn blackPawn_2 = Pawn.createBlackPawn();
		blackPawn_2.setNumberOfMoves(1);

		assertFalse(blackPawn_2.isValidPath(start, end));
	}

	@Test
	void wrongGeneralBlackPawnMove() {
		Position start = Position.createPositionFromString("a4");
		Position end = Position.createPositionFromString("a5");

		assertFalse(blackPawn.isValidPath(start, end));
	}

	@Test
	void firstWhitePawnMove() {
		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("a4");

		assertTrue(whitePawn.isValidPath(start, end));
	}

	@Test
	void secondWhitePawnMove() {
		Position start = Position.createPositionFromString("a4");
		Position end = Position.createPositionFromString("a5");
		
		Pawn whitePawn_2 = Pawn.createWhitePawn();
		whitePawn_2.setNumberOfMoves(1);

		assertTrue(whitePawn_2.isValidPath(start, end));
	}

	@Test
	void wrongSecondWhitePawnMove() {
		Position start = Position.createPositionFromString("a3");
		Position end = Position.createPositionFromString("a5");
		
		Pawn whitePawn_2 = Pawn.createWhitePawn();
		whitePawn_2.setNumberOfMoves(1);

		assertFalse(whitePawn_2.isValidPath(start, end));
	}

	@Test
	void wrongGeneralWhitePawnMove() {
		Position start = Position.createPositionFromString("a3");
		Position end = Position.createPositionFromString("a2");

		assertFalse(whitePawn.isValidPath(start, end));
	}

	@Test
	void isValidMoveWhitePawn() {
		Board board = Board.createEmptyBoard();

		Pawn whitePawn_2 = Pawn.createWhitePawn();
		whitePawn_2.setNumberOfMoves(0);

		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("a4");

		board.setPiece(whitePawn_2, start);

		assertTrue(Player.isValidMove(board, start, end));
	}

	@Test
	void isValidCaptureMoveWhitePawn() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("b3");

		board.setPiece(whitePawn, start);
		board.setPiece(blackPawn, end);

		assertTrue(Player.isValidMove(board, start, end));
	}

	@Test
	void isInValidCaptureMoveWhitePawn() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("b3");

		board.setPiece(whitePawn, start);
		board.setPiece(whiteQueen, end);

		assertFalse(Player.isValidMove(board, start, end));
	}

	@Test
	void isInValidCaptureMoveWhitePawn_2() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("a3");

		board.setPiece(whitePawn, start);
		board.setPiece(blackPawn, end);

		assertFalse(Player.isValidMove(board, start, end));
	}

	@Test
	void isPieceInWayWhitePawn() {
		Board board = Board.createEmptyBoard();

		Pawn whitePawn_2 = Pawn.createWhitePawn();
		whitePawn_2.setNumberOfMoves(0);

		Position start = Position.createPositionFromString("a2");
		Position inBetween = Position.createPositionFromString("a3");
		Position end = Position.createPositionFromString("a4");

		board.setPiece(whitePawn_2, start);
		board.setPiece(blackPawn, inBetween);

		assertFalse(Player.isValidMove(board, start, end));
	}

	@Test
	void isEndPositionOccupiedByOwnPieceWhitePawn() {
		Board board = Board.createEmptyBoard();

		Pawn whitePawn_2 = Pawn.createWhitePawn();
		whitePawn_2.setNumberOfMoves(0);

		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("a4");

		board.setPiece(whitePawn_2, start);
		board.setPiece(whiteQueen, end);

		assertFalse(Player.isValidMove(board, start, end));
	}

	@Test
	void isValidMoveBlackPawn() {
		Board board = Board.createEmptyBoard();

		Pawn blackPawn_2 = Pawn.createBlackPawn();
		blackPawn_2.setNumberOfMoves(0);

		Position start = Position.createPositionFromString("a7");
		Position end = Position.createPositionFromString("a5");

		board.setPiece(blackPawn_2, start);

		assertTrue(Player.isValidMove(board, start, end));
	}

	@Test
	void isValidCaptureMoveBlackPawn() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("a7");
		Position end = Position.createPositionFromString("b6");

		board.setPiece(blackPawn, start);
		board.setPiece(whitePawn, end);

		assertTrue(Player.isValidMove(board, start, end));
	}

	@Test
	void isInValidCaptureMoveBlackPawn() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("a7");
		Position end = Position.createPositionFromString("b6");

		board.setPiece(blackPawn, start);
		board.setPiece(blackQueen, end);

		assertFalse(Player.isValidMove(board, start, end));
	}

	@Test
	void isInValidCaptureMoveBlackPawn_2() {
		Board board = Board.createEmptyBoard();

		Position start = Position.createPositionFromString("a7");
		Position end = Position.createPositionFromString("a6");

		board.setPiece(blackPawn, start);
		board.setPiece(whitePawn, end);

		assertFalse(Player.isValidMove(board, start, end));
	}

	@Test
	void isPieceInWayBlackPawn() {
		Board board = Board.createEmptyBoard();

		Pawn blackPawn_2 = Pawn.createBlackPawn();
		blackPawn_2.setNumberOfMoves(0);

		Position start = Position.createPositionFromString("a7");
		Position inBetween = Position.createPositionFromString("a6");
		Position end = Position.createPositionFromString("a5");

		board.setPiece(blackPawn_2, start);
		board.setPiece(whitePawn, inBetween);

		assertFalse(Player.isValidMove(board, start, end));
	}

	@Test
	void isEndPositionOccupiedByOwnPieceBlackPawn() {
		Board board = Board.createEmptyBoard();

		Pawn blackPawn_2 = Pawn.createBlackPawn();
		blackPawn_2.setNumberOfMoves(0);

		Position start = Position.createPositionFromString("a7");
		Position end = Position.createPositionFromString("a5");

		board.setPiece(blackPawn_2, start);
		board.setPiece(blackQueen, end);

		assertFalse(Player.isValidMove(board, start, end));
	}
}
