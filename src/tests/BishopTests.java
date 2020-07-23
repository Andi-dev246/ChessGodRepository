package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import board.Board;
import board.Position;
import pieces.Bishop;
import pieces.Pawn;
import player.Player;

class BishopTests {
	
	Bishop whiteBishop = Bishop.createWhiteBishop();
	Bishop blackBishop = Bishop.createBlackBishop();
	
	Pawn whitePawn = Pawn.createWhitePawn();
	Pawn blackPawn = Pawn.createBlackPawn();
	
	@Test
	void upLeft() {
		Position start = Position.createPositionFromInt(new int[] {2,3});
		Position end = 	 Position.createPositionFromInt(new int[] {0,5});
		
		assertTrue(whiteBishop.isValidPath(start, end));
	}
	
	@Test
	void upRight() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		assertTrue(whiteBishop.isValidPath(start, end));
	}
	
	@Test
	void downLeft() {
		Position start = Position.createPositionFromString("g7");
		Position end = Position.createPositionFromString("d4");
		
		assertTrue(whiteBishop.isValidPath(start, end));
	}
	
	@Test
	void downRight() {
		Position start = Position.createPositionFromString("a8");
		Position end = Position.createPositionFromString("h1");
		
		assertTrue(whiteBishop.isValidPath(start, end));
	}
	
	@Test
	void nonValidPath() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h1");
		
		assertFalse(whiteBishop.isValidPath(start, end));
	}
	
	@Test
	void validBishopMove() {
		Board board = Board.createEmptyBoard();
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		board.setPiece(whiteBishop, start);
		
		assertTrue(Player.isValidMove(board, start, end));
		
	}
	
	@Test
	void validCaptureMove() {
		Board board = Board.createEmptyBoard();
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		board.setPiece(whiteBishop, start);
		board.setPiece(blackPawn, end);
		
		assertTrue(Player.isValidMove(board, start, end));
	}
	
	@Test
	void invalidCaptureMove() {
		Board board = Board.createEmptyBoard();
		
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		board.setPiece(whiteBishop, start);
		board.setPiece(whitePawn, end);
		
		assertFalse(Player.isValidMove(board, start, end));
	}
	
	@Test 
	void invalidMoveWithPawnOnPath() {
		Board board = Board.createEmptyBoard();
		
		Position start = Position.createPositionFromString("g7");
		Position end = Position.createPositionFromString("d4");
		
		board.setPiece(whiteBishop, start);
		board.setPiece(blackPawn, Position.createPositionFromString("f6"));
		
		assertFalse(Player.isValidMove(board, start, end));
	}
}
