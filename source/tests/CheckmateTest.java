package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.board.Position;
import model.pieces.Bishop;
import model.pieces.King;
import model.pieces.Knight;
import model.pieces.Pawn;
import model.pieces.Queen;
import model.pieces.Rook;

class CheckmateTest {
	
//	@Test void checkmateTest() {
//		Board_2 board = Board_2.createEmptyBoard();
//		
//		board.setPiece(King.createBlackKing(),Position.createPositionFromString("a1"));
//		board.setPiece(Rook.createWhiteRook(),Position.createPositionFromString("c1"));
//		board.setPiece(Rook.createWhiteRook(),Position.createPositionFromString("c2"));
//		
//		assertTrue(Checkmate.isBlackKingCheckmate(board));
//	}
//
//	@Test
//	void checkmateTest2() {
//		Board_2 board = Board_2.createEmptyBoard();
//		
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("a2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("c2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("d2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("e4"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("f2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("g2"));
//		board.setPiece(Bishop.createWhiteBishop(),Position.createPositionFromString("b2"));
//		board.setPiece(Bishop.createWhiteBishop(),Position.createPositionFromString("f1"));
//		board.setPiece(Knight.createWhiteKnight(),Position.createPositionFromString("d5"));
//		board.setPiece(Queen.createWhiteQueen(),Position.createPositionFromString("g4"));
//		board.setPiece(Rook.createWhiteRook(),Position.createPositionFromString("h5"));
//		board.setPiece(King.createWhiteKing(),Position.createPositionFromString("e1"));
//		
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("a7"));
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("b7"));
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("c7"));
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("d6"));
//		board.setPiece(Bishop.createBlackBishop(),Position.createPositionFromString("c8"));
//		board.setPiece(Bishop.createBlackBishop(),Position.createPositionFromString("d4"));
//		board.setPiece(Knight.createBlackKnight(),Position.createPositionFromString("d8"));
//		board.setPiece(Knight.createBlackKnight(),Position.createPositionFromString("d7"));
//		board.setPiece(Rook.createBlackRook(),Position.createPositionFromString("a8"));
//		board.setPiece(King.createBlackKing(),Position.createPositionFromString("e5"));
//		
//		assertTrue(Checkmate.isBlackKingCheckmate(board));
//	}
//
//	@Test
//	void checkmateTest3() {
//		Board_2 board = Board_2.createEmptyBoard();
//		
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("a2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("c2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("d2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("e4"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("f2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("g2"));
//		board.setPiece(Bishop.createWhiteBishop(),Position.createPositionFromString("b2"));
//		board.setPiece(Bishop.createWhiteBishop(),Position.createPositionFromString("f1"));
//		board.setPiece(Knight.createWhiteKnight(),Position.createPositionFromString("d5"));
//		board.setPiece(Queen.createWhiteQueen(),Position.createPositionFromString("g4"));
//		board.setPiece(Rook.createWhiteRook(),Position.createPositionFromString("h5"));
//		board.setPiece(King.createWhiteKing(),Position.createPositionFromString("e1"));
//		
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("a7"));
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("b7"));
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("c7"));
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("d6"));
//		board.setPiece(Bishop.createBlackBishop(),Position.createPositionFromString("c8"));
//		board.setPiece(Bishop.createBlackBishop(),Position.createPositionFromString("d4"));
//		board.setPiece(Knight.createBlackKnight(),Position.createPositionFromString("d8"));
//		board.setPiece(Knight.createBlackKnight(),Position.createPositionFromString("d7"));
//		board.setPiece(Rook.createBlackRook(),Position.createPositionFromString("a8"));
//		board.setPiece(King.createBlackKing(),Position.createPositionFromString("e5"));
//		
//		assertFalse(Checkmate.isWhiteKingCheckmate(board));
//	}
//	@Test
//	void checkmateTest4() {
//		Board_2 board = Board_2.createEmptyBoard();
//		
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("a2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("c2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("d2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("e4"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("f2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("g2"));
//		board.setPiece(Bishop.createWhiteBishop(),Position.createPositionFromString("b2"));
//		board.setPiece(Bishop.createWhiteBishop(),Position.createPositionFromString("f1"));
//		board.setPiece(Knight.createWhiteKnight(),Position.createPositionFromString("d5"));
//		board.setPiece(Queen.createWhiteQueen(),Position.createPositionFromString("g4"));
//		board.setPiece(Rook.createWhiteRook(),Position.createPositionFromString("h5"));
//		board.setPiece(King.createWhiteKing(),Position.createPositionFromString("e1"));
//		
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("a7"));
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("b7"));
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("c7"));
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("d6"));
//		// This Pawn can save King
//		board.setPiece(Pawn.createBlackPawn(),Position.createPositionFromString("f7"));
//		
//		board.setPiece(Bishop.createBlackBishop(),Position.createPositionFromString("c8"));
//		board.setPiece(Bishop.createBlackBishop(),Position.createPositionFromString("d4"));
//		board.setPiece(Knight.createBlackKnight(),Position.createPositionFromString("d8"));
//		board.setPiece(Knight.createBlackKnight(),Position.createPositionFromString("d7"));
//		board.setPiece(Rook.createBlackRook(),Position.createPositionFromString("a8"));
//		board.setPiece(King.createBlackKing(),Position.createPositionFromString("e5"));
//		
//		assertFalse(Checkmate.isBlackKingCheckmate(board));
//	}
	
	
}
