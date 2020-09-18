package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import controller.Controller;
import controller.ControllerImplementation;
import gui.GraphicalUserInterface;
import model.board.Board;
import model.board.BoardImplementation;
import model.board.Position;
import model.pieces.PieceSetter;
import model.pieces.PieceType;
import model.player.Player;
import model.player.PlayerImplementation;

class CheckmateTest {
	
	@Test void checkmateTest() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		pieceSetter.setBlackPiece(PieceType.KING, Position.createPositionFromString("a1"));
		pieceSetter.setWhitePiece(PieceType.ROOK, Position.createPositionFromString("c1"));
		pieceSetter.setWhitePiece(PieceType.ROOK, Position.createPositionFromString("c2"));
		
		Player blackPlayer = PlayerImplementation.createBlackPlayer(board);
		assertTrue(blackPlayer.isCheckmate());
	}

	@Test
	void checkmateTest2() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);

		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("a2"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("c2"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("d2"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("e4"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("f2"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("g2"));
		pieceSetter.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("b2"));
		pieceSetter.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("f1"));
		pieceSetter.setWhitePiece(PieceType.KNIGHT, Position.createPositionFromString("d5"));
		pieceSetter.setWhitePiece(PieceType.QUEEN, Position.createPositionFromString("g4"));
		pieceSetter.setWhitePiece(PieceType.ROOK, Position.createPositionFromString("h5"));
		pieceSetter.setWhitePiece(PieceType.KING, Position.createPositionFromString("e1"));
		
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("a7"));
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("b7"));
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("c7"));
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("d6"));
		pieceSetter.setBlackPiece(PieceType.BISHOP, Position.createPositionFromString("c8"));
		pieceSetter.setBlackPiece(PieceType.BISHOP, Position.createPositionFromString("d4"));
		pieceSetter.setBlackPiece(PieceType.KNIGHT, Position.createPositionFromString("d8"));
		pieceSetter.setBlackPiece(PieceType.KNIGHT, Position.createPositionFromString("d7"));
		pieceSetter.setBlackPiece(PieceType.ROOK, Position.createPositionFromString("a8"));
		pieceSetter.setBlackPiece(PieceType.KING, Position.createPositionFromString("e5"));
		
		Player blackPlayer = PlayerImplementation.createBlackPlayer(board);
		
		assertTrue(blackPlayer.isCheckmate());
	}

	@Test
	void checkmateTest3() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("a2"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("c2"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("d2"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("e4"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("f2"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("g2"));
		pieceSetter.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("b2"));
		pieceSetter.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("f1"));
		pieceSetter.setWhitePiece(PieceType.KNIGHT, Position.createPositionFromString("d5"));
		pieceSetter.setWhitePiece(PieceType.QUEEN, Position.createPositionFromString("g4"));
		pieceSetter.setWhitePiece(PieceType.ROOK, Position.createPositionFromString("h5"));
		pieceSetter.setWhitePiece(PieceType.KING, Position.createPositionFromString("e1"));
		
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("a7"));
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("b7"));
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("c7"));
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("d6"));
		pieceSetter.setBlackPiece(PieceType.BISHOP, Position.createPositionFromString("c8"));
		pieceSetter.setBlackPiece(PieceType.BISHOP, Position.createPositionFromString("d4"));
		pieceSetter.setBlackPiece(PieceType.KNIGHT, Position.createPositionFromString("d8"));
		pieceSetter.setBlackPiece(PieceType.KNIGHT, Position.createPositionFromString("d7"));
		pieceSetter.setBlackPiece(PieceType.ROOK, Position.createPositionFromString("a8"));
		pieceSetter.setBlackPiece(PieceType.KING, Position.createPositionFromString("e5"));
		
		Player whitePlayer = PlayerImplementation.createWhitePlayer(board);
		
		assertFalse(whitePlayer.isCheckmate());
	}
	@Test
	void checkmateTest4() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
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
	}
	
	
}
