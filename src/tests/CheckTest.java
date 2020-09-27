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

class CheckTest {
	
	@Test
	void whiteKingInCheckTest() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		Player whitePlayer = PlayerImplementation.createWhitePlayer(board);
		
		pieceSetter.setBlackPiece(PieceType.KNIGHT, Position.createPositionFromString("e3"));
		pieceSetter.setWhitePiece(PieceType.KING, Position.createPositionFromString("g4"));
		
		
		assertTrue(whitePlayer.isInCheck());
	}

	@Test
	void whiteKingIsNotInCheckTest() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		Player whitePlayer = PlayerImplementation.createWhitePlayer(board);
		
		pieceSetter.setBlackPiece(PieceType.KNIGHT, Position.createPositionFromString("e3"));
		pieceSetter.setWhitePiece(PieceType.KING, Position.createPositionFromString("g3"));
		
		assertFalse(whitePlayer.isInCheck());
	}

	@Test
	void whiteKingIsNotInCheckTest2() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		Player whitePlayer = PlayerImplementation.createWhitePlayer(board);
		
		pieceSetter.setWhitePiece(PieceType.KNIGHT, Position.createPositionFromString("e3"));
		pieceSetter.setWhitePiece(PieceType.KING, Position.createPositionFromString("g3"));
		
		assertFalse(whitePlayer.isInCheck());
	}
	
	@Test
	void whiteKingInCheckTest2() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		Player whitePlayer = PlayerImplementation.createWhitePlayer(board);
		
		pieceSetter.setBlackPiece(PieceType.QUEEN, Position.createPositionFromString("f5"));
		pieceSetter.setWhitePiece(PieceType.KING, Position.createPositionFromString("h3"));
		
		assertTrue(whitePlayer.isInCheck());
	}
	
	@Test
	void whiteKingIsNotInCheckTest3() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		Player whitePlayer = PlayerImplementation.createWhitePlayer(board);
		
		pieceSetter.setBlackPiece(PieceType.QUEEN, Position.createPositionFromString("f5"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("g43"));
		pieceSetter.setWhitePiece(PieceType.KING, Position.createPositionFromString("h3"));
		
		assertFalse(whitePlayer.isInCheck());
	}
}