package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import board.Position;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Rook;
import player.Checkmate;

class CheckmateTest {
	
	@Test void checkmateTest() {
		Board board = Board.createEmptyBoard();
		
		board.setPiece(King.createBlackKing(),Position.createPositionFromString("a1"));
		board.setPiece(Rook.createWhiteRook(),Position.createPositionFromString("c1"));
		board.setPiece(Rook.createWhiteRook(),Position.createPositionFromString("c2"));
		
		assertTrue(Checkmate.isBlackKingCheckmate(board));
	}

//	@Test
//	void test() {
//		Board board = Board.createEmptyBoard();
//		
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("a2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("c2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("d2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("e4"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("f2"));
//		board.setPiece(Pawn.createWhitePawn(), Position.createPositionFromString("g2"));
//		
//		board.setPiece(Bishop.createWhiteBishop(),Position.createPositionFromString("b2"));
//		board.setPiece(Bishop.createWhiteBishop(),Position.createPositionFromString("f1"));
//		
//		board.setPiece(Knight.createWhiteKnight(),Position.createPositionFromString("d5"));
//	}

}
