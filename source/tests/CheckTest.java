package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Position;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;

class CheckTest {
	
//	King whiteKing = King.createWhiteKing();
//	King blackKing = King.createBlackKing();
//	
//	@Test
//	void whiteKingInCheckTest() {
//		Board_2 board = Board_2.createEmptyBoard();
//		
//		Knight blackKnight = Knight.createBlackKnight();
//		
//		board.setPiece(blackKnight, Position.createPositionFromString("e3"));
//		board.setPiece(whiteKing, Position.createPositionFromString("g4"));
//		
//		assertTrue(Check.isWhiteKingInCheck(board));
//	}
//
//	@Test
//	void whiteKingIsNotInCheckTest() {
//		Board_2 board = Board_2.createEmptyBoard();
//		
//		Knight blackKnight = Knight.createBlackKnight();
//		
//		board.setPiece(blackKnight, Position.createPositionFromString("e3"));
//		board.setPiece(whiteKing, Position.createPositionFromString("g3"));
//		
//		assertFalse(Check.isWhiteKingInCheck(board));
//	}
//
//	@Test
//	void whiteKingIsNotInCheckTest2() {
//		Board_2 board = Board_2.createEmptyBoard();
//		
//		Knight whiteKnight = Knight.createWhiteKnight();
//		
//		board.setPiece(whiteKnight, Position.createPositionFromString("e3"));
//		board.setPiece(whiteKing, Position.createPositionFromString("g4"));
//		
//		assertFalse(Check.isWhiteKingInCheck(board));
//	}
//	
//	@Test
//	void whiteKingInCheckTest2() {
//		Board_2 board = Board_2.createEmptyBoard();
//		
//		Queen blackQueen= Queen.createBlackQueen();
//		
//		board.setPiece(blackQueen, Position.createPositionFromString("f5"));
//		board.setPiece(whiteKing, Position.createPositionFromString("h3"));
//		
//		assertTrue(Check.isWhiteKingInCheck(board));
//	}
//	
//	@Test
//	void whiteKingIsNotInCheckTest3() {
//		Board_2 board = Board_2.createEmptyBoard();
//		
//		Queen blackQueen = Queen.createBlackQueen();
//		Pawn whitePawn = Pawn.createWhitePawn();
//		
//		board.setPiece(blackQueen, Position.createPositionFromString("f5"));
//		board.setPiece(whitePawn, Position.createPositionFromString("g4"));
//		board.setPiece(whiteKing, Position.createPositionFromString("h3"));
//		
//		assertFalse(Check.isWhiteKingInCheck(board));
//	}
}