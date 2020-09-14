package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import exceptions.InvalidMoveException;
import model.board.Board;
import model.board.BoardImplementation;
import model.board.Position;
import model.pieces.Piece;
import model.pieces.PieceSetter;
import model.pieces.PieceType;

class PawnTests {

	PieceType pawn = PieceType.PAWN;
	PieceType queen = PieceType.QUEEN;

	@Test
	void firstBlackPawnMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a7");
		Position end = Position.createPositionFromString("a5");
		
		Piece blackPawn = pieceSetter.setBlackPiece(pawn, start);

		assertTrue(blackPawn.isValidMove(start, end));
	}

	@Test
	void secondBlackPawnMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a6");
		Position end = Position.createPositionFromString("a5");
		
		Piece blackPawn = pieceSetter.setBlackPiece(pawn, start);

		assertTrue(blackPawn.isValidMove(start, end));
	}

	@Test
	void wrongSecondBlackPawnMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a6");
		Position inBetween = Position.createPositionFromString("a5");
		Position end = Position.createPositionFromString("a3");
		
		Piece blackPawn = pieceSetter.setBlackPiece(pawn, start);
		try {
			blackPawn.move(inBetween);
		} catch (InvalidMoveException e) {
			e.printStackTrace();
		}

		assertFalse(blackPawn.isValidMove(inBetween, end));
	}

	@Test
	void wrongGeneralBlackPawnMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a4");
		Position end = Position.createPositionFromString("a5");

		Piece blackPawn = pieceSetter.setBlackPiece(pawn, start);

		assertFalse(blackPawn.isValidMove(start, end));
	}

	@Test
	void firstWhitePawnMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("a4");

		Piece whitePawn = pieceSetter.setWhitePiece(pawn, start);

		assertTrue(whitePawn.isValidMove(start, end));
	}

	@Test
	void secondWhitePawnMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start_0 = Position.createPositionFromString("a2");
		Position end_0 = Position.createPositionFromString("a4");
		Position start = end_0;
		Position end = Position.createPositionFromString("a5");
		
		Piece whitePawn = pieceSetter.setWhitePiece(pawn, start_0);
		try {
			whitePawn.move(end_0);
		} catch (InvalidMoveException e) {
			e.printStackTrace();
		}
		assertTrue(whitePawn.isValidMove(start, end));
	}

	@Test
	void wrongSecondWhitePawnMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start_0 = Position.createPositionFromString("a2");
		Position end_0 = Position.createPositionFromString("a3");
		Position start = end_0;
		Position end = Position.createPositionFromString("a5");
		
		Piece whitePawn = pieceSetter.setWhitePiece(pawn, start_0);
		try {
			whitePawn.move(end_0);
		} catch (InvalidMoveException e) {
			e.printStackTrace();
		}
		assertFalse(whitePawn.isValidMove(start, end));
	}

	@Test
	void wrongGeneralWhitePawnMove() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a3");
		Position end = Position.createPositionFromString("a2");

		Piece whitePawn = pieceSetter.setWhitePiece(pawn, start);

		assertFalse(whitePawn.isValidMove(start, end));
	}

	@Test
	void isValidCaptureMoveWhitePawn() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("b3");

		Piece whitePawn = pieceSetter.setWhitePiece(pawn, start);
		pieceSetter.setBlackPiece(pawn, end);

		assertTrue(whitePawn.isValidMove(start, end));
	}

	@Test
	void isInvalidCaptureMoveWhitePawn() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("b3");

		Piece whitePawn = pieceSetter.setWhitePiece(pawn, start);
		pieceSetter.setWhitePiece(queen, end);

		assertFalse(whitePawn.isValidMove(start, end));
	}

	@Test
	void isInvalidCaptureMoveWhitePawn_2() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("a3");

		Piece whitePawn = pieceSetter.setWhitePiece(pawn, start);
		pieceSetter.setBlackPiece(pawn, end);

		assertFalse(whitePawn.isValidMove(start, end));
	}

	@Test
	void isPieceInWayWhitePawn() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a2");
		Position inBetween = Position.createPositionFromString("a3");
		Position end = Position.createPositionFromString("a4");

		Piece whitePawn = pieceSetter.setWhitePiece(pawn, start);
		pieceSetter.setWhitePiece(pawn, inBetween);
		
		assertFalse(whitePawn.isValidMove(start, end));
	}

	@Test
	void isEndPositionOccupiedByOwnPieceWhitePawn() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("a4");

		Piece whitePawn = pieceSetter.setWhitePiece(pawn, start);
		pieceSetter.setWhitePiece(pawn, end);
		
		assertFalse(whitePawn.isValidMove(start, end));
	}

	@Test
	void isValidCaptureMoveBlackPawn() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a7");
		Position end = Position.createPositionFromString("b6");

		Piece blackPawn = pieceSetter.setBlackPiece(pawn, start);
		pieceSetter.setWhitePiece(pawn, end);

		assertTrue(blackPawn.isValidMove(start, end));
	}

	@Test
	void isInvalidCaptureMoveBlackPawn() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		Position start = Position.createPositionFromString("a7");
		Position end = Position.createPositionFromString("b6");

		Piece blackPawn = pieceSetter.setBlackPiece(pawn, start);
		pieceSetter.setBlackPiece(queen, end);

		assertFalse(blackPawn.isValidMove(start, end));
	}
}
