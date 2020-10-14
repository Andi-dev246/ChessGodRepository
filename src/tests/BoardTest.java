package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import model.Board;
import model.Piece;
import model.board.BoardImplementation;
import model.board.Position;
import model.pieces.PieceSetter;
import model.pieces.PieceType;

class BoardTest {

	@Test
	void test() {
		Board board1 = new BoardImplementation();
		Board board2 = new BoardImplementation();
		
		PieceSetter pieceSetter1 = new PieceSetter(board1);
		PieceSetter pieceSetter2 = new PieceSetter(board2);
				
		pieceSetter1.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("a2"));
		pieceSetter1.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("c3"));
		pieceSetter1.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("d4"));
		pieceSetter1.setWhitePiece(PieceType.KING, Position.createPositionFromString("h8"));
		pieceSetter1.setBlackPiece(PieceType.KING, Position.createPositionFromString("e8"));
		
		pieceSetter2.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("a2"));
		pieceSetter2.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("c3"));
		pieceSetter2.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("d4"));
		pieceSetter2.setWhitePiece(PieceType.KING, Position.createPositionFromString("h8"));
		pieceSetter2.setBlackPiece(PieceType.KING, Position.createPositionFromString("e8"));
		
		assertTrue(board1.equals(board2));
	}
	
	@Test
	void test2() {
		Board board1 = new BoardImplementation();
		Board board2 = new BoardImplementation();
		
		PieceSetter pieceSetter1 = new PieceSetter(board1);
		PieceSetter pieceSetter2 = new PieceSetter(board2);
				
		pieceSetter1.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("a2"));
		pieceSetter1.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("c3"));
		pieceSetter1.setBlackPiece(PieceType.BISHOP, Position.createPositionFromString("d4"));
		pieceSetter1.setWhitePiece(PieceType.KING, Position.createPositionFromString("h8"));
		pieceSetter1.setBlackPiece(PieceType.KING, Position.createPositionFromString("e8"));
		
		pieceSetter2.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("a2"));
		pieceSetter2.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("c3"));
		pieceSetter2.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("d4"));
		pieceSetter2.setWhitePiece(PieceType.KING, Position.createPositionFromString("h8"));
		pieceSetter2.setBlackPiece(PieceType.KING, Position.createPositionFromString("e8"));
		
		assertFalse(board1.equals(board2));
	}
	
	@Test
	void test3() {
		Board board1 = new BoardImplementation();
		Board board2 = new BoardImplementation();
		
		PieceSetter pieceSetter1 = new PieceSetter(board1);
		PieceSetter pieceSetter2 = new PieceSetter(board2);
		
		pieceSetter1.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("a2"));
		pieceSetter1.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("c3"));
		pieceSetter1.setWhitePiece(PieceType.KNIGHT, Position.createPositionFromString("d4"));
		pieceSetter1.setWhitePiece(PieceType.KING, Position.createPositionFromString("h8"));
		pieceSetter1.setBlackPiece(PieceType.KING, Position.createPositionFromString("e8"));
		
		pieceSetter2.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("a2"));
		pieceSetter2.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("c3"));
		pieceSetter2.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("d4"));
		pieceSetter2.setWhitePiece(PieceType.KING, Position.createPositionFromString("h8"));
		pieceSetter2.setBlackPiece(PieceType.KING, Position.createPositionFromString("e8"));
		
		assertFalse(board1.equals(board2));
	}
	
	@Test
	void test4() throws Exception {
		Board board1 = new BoardImplementation();
		Board board2 = new BoardImplementation();
		
		PieceSetter pieceSetter1 = new PieceSetter(board1);
		PieceSetter pieceSetter2 = new PieceSetter(board2);
				
		pieceSetter1.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("a2"));
		pieceSetter1.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("c3"));
		pieceSetter1.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("d4"));
		pieceSetter1.setWhitePiece(PieceType.KING, Position.createPositionFromString("h8"));
		pieceSetter1.setBlackPiece(PieceType.KING, Position.createPositionFromString("e8"));
		
		pieceSetter2.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("a2"));
		pieceSetter2.setWhitePiece(PieceType.PAWN, Position.createPositionFromString("c3"));
		pieceSetter2.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("d4"));
		pieceSetter2.setWhitePiece(PieceType.KING, Position.createPositionFromString("h8"));
		pieceSetter2.setBlackPiece(PieceType.KING, Position.createPositionFromString("e8"));
		
		Piece bishop = board1.getPiece(Position.createPositionFromString("d4"));
		bishop.move(Position.createPositionFromString("e5"));
		bishop.move(Position.createPositionFromString("d4"));
		
		assertTrue(board1.equals(board2));
	}
}
