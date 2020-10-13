package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Board;
import model.Player;
import model.board.BoardImplementation;
import model.board.Position;
import model.pieces.King;
import model.pieces.Pawn;
import model.pieces.PieceSetter;
import model.pieces.PieceType;
import model.player.PlayerImplementation;

class StalemateTest {

	@Test
	void stalemateTest() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		pieceSetter.setBlackPiece(PieceType.KING, Position.createPositionFromString("c8"));
		pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("c7"));
		pieceSetter.setWhitePiece(PieceType.KING, Position.createPositionFromString("c6"));
		
		Player player = PlayerImplementation.createBlackPlayer(board);
		
		assertTrue(player.isStalemate());
	}
	
	@Test
	void stalemateTest2() {
		Board board = new BoardImplementation();
		PieceSetter pieceSetter = new PieceSetter(board);
		
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("b1"));
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("b2"));
		pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromString("a2"));
		pieceSetter.setBlackPiece(PieceType.KING, Position.createPositionFromString("a1"));
		
		Player player = PlayerImplementation.createBlackPlayer(board);
		
		assertTrue(player.isStalemate());
	}
}
