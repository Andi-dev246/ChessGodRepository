package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.board.Position;
import model.pieces.King;
import model.pieces.Pawn;

class StalemateTest {

//	@Test
//	void stalemateTest() {
//		Board_2 board = Board_2.createEmptyBoard();
//		Pawn whitePawn = Pawn.createWhitePawn();
//		King whiteKing = King.createWhiteKing();
//		King blackKing = King.createBlackKing();
//		
//		board.setPiece(blackKing, Position.createPositionFromString("c8"));
//		board.setPiece(whitePawn, Position.createPositionFromString("c7"));
//		board.setPiece(whiteKing, Position.createPositionFromString("c6"));
//		
//		assertTrue(Stalemate.isBlackKingStalemate(board));
//	}
//	
//	@Test
//	void stalemateTest2() {
//		Board_2 board = Board_2.createEmptyBoard();
//		Pawn blackPawn = Pawn.createBlackPawn();
//		Pawn blackPawn2 = Pawn.createBlackPawn();
//		Pawn blackPawn3 = Pawn.createBlackPawn();
//		King blackKing = King.createBlackKing();
//		
//		board.setPiece(blackPawn, Position.createPositionFromString("b1"));
//		board.setPiece(blackPawn2, Position.createPositionFromString("b2"));
//		board.setPiece(blackPawn3, Position.createPositionFromString("a2"));
//		board.setPiece(blackKing, Position.createPositionFromString("a1"));
//		
//		assertTrue(Stalemate.isBlackKingStalemate(board));
//		
//	}
}
