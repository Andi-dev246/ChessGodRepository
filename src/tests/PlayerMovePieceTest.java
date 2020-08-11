package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import board.Board;
import board.Position;
import pieces.PieceType;
import player.Player;

class PlayerMovePieceTest {

	@Test
	void test() {
		Position start = Position.createPositionFromString("d2");
		Position end = Position.createPositionFromString("d4");
		
		Player whitePlayer = Player.createWhitePlayer();
		Board board = Board.createDefaultBoard();
		
		try {
			whitePlayer.movePiece(board, start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertFalse(board.isEmpty(end));
		assertTrue(board.getPiece(end).getPieceType() == PieceType.PAWN);
		
	}
}
