package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Board;
import model.Player;
import model.board.BoardImplementation;
import model.board.Position;
import model.pieces.PieceSetter;
import model.pieces.PieceType;
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
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("f7"));	//This Pawn can save the King
		pieceSetter.setBlackPiece(PieceType.BISHOP, Position.createPositionFromString("c8"));
		pieceSetter.setBlackPiece(PieceType.BISHOP, Position.createPositionFromString("d4"));
		pieceSetter.setBlackPiece(PieceType.KNIGHT, Position.createPositionFromString("d8"));
		pieceSetter.setBlackPiece(PieceType.KNIGHT, Position.createPositionFromString("d7"));
		pieceSetter.setBlackPiece(PieceType.ROOK, Position.createPositionFromString("a8"));
		pieceSetter.setBlackPiece(PieceType.KING, Position.createPositionFromString("e5"));
		
		Player blackPlayer = PlayerImplementation.createBlackPlayer(board);
		
		assertFalse(blackPlayer.isCheckmate());
	}
	
	
}
