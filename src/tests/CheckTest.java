package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import board.Position;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import player.Checkmate;

class CheckTest {
	
	King whiteKing = King.createWhiteKing();
	King blackKing = King.createBlackKing();
	
	@Test
	void whiteKingInCheckTest() {
		Board board = Board.createEmptyBoard();
		
		Knight blackKnight = Knight.createBlackKnight();
		
		board.setPiece(blackKnight, Position.createPositionFromString("e3"));
		board.setPiece(whiteKing, Position.createPositionFromString("g4"));
		
		assertTrue(Checkmate.isWhiteKingInCheck(board));
	}

	@Test
	void whiteKingIsNotInCheckTest() {
		Board board = Board.createEmptyBoard();
		
		Knight blackKnight = Knight.createBlackKnight();
		
		board.setPiece(blackKnight, Position.createPositionFromString("e3"));
		board.setPiece(whiteKing, Position.createPositionFromString("g3"));
		
		assertFalse(Checkmate.isWhiteKingInCheck(board));
	}

	@Test
	void whiteKingIsNotInCheckTest2() {
		Board board = Board.createEmptyBoard();
		
		Knight whiteKnight = Knight.createWhiteKnight();
		
		board.setPiece(whiteKnight, Position.createPositionFromString("e3"));
		board.setPiece(whiteKing, Position.createPositionFromString("g4"));
		
		assertFalse(Checkmate.isWhiteKingInCheck(board));
	}
	
	@Test
	void whiteKingInCheckTest2() {
		Board board = Board.createEmptyBoard();
		
		Queen blackQueen= Queen.createBlackQueen();
		
		board.setPiece(blackQueen, Position.createPositionFromString("f5"));
		board.setPiece(whiteKing, Position.createPositionFromString("h3"));
		
		assertTrue(Checkmate.isWhiteKingInCheck(board));
	}
	
	@Test
	void whiteKingIsNotInCheckTest3() {
		Board board = Board.createEmptyBoard();
		
		Queen blackQueen = Queen.createBlackQueen();
		Pawn whitePawn = Pawn.createWhitePawn();
		
		board.setPiece(blackQueen, Position.createPositionFromString("f5"));
		board.setPiece(whitePawn, Position.createPositionFromString("g4"));
		board.setPiece(whiteKing, Position.createPositionFromString("h3"));
		
		assertFalse(Checkmate.isWhiteKingInCheck(board));
	}
}