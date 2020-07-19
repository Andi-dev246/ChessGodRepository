package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Position;
import pieces.King;

class KingTests {

	King whiteKing = King.createWhiteKing();
	
	@Test
	void upLeft() {
		Position start = Position.createPositionFromString("d1");
		Position end = 	 Position.createPositionFromString("c2");
		
		assertTrue(whiteKing.isValidPath(start, end));
	}
	
	@Test
	void upRight() {
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("e2");
		
		assertTrue(whiteKing.isValidPath(start, end));
	}
	
	@Test
	void downLeft() {
		Position start = Position.createPositionFromString("d8");
		Position end = Position.createPositionFromString("c7");
		
		assertTrue(whiteKing.isValidPath(start, end));
	}
	
	@Test
	void downRight() {
		Position start = Position.createPositionFromString("d8");
		Position end = Position.createPositionFromString("e7");
		
		assertTrue(whiteKing.isValidPath(start, end));
	}
	
	@Test
	void moveUp() {
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("d2");
		
		assertTrue(whiteKing.isValidPath(start, end));
	}
	
	@Test 
	void moveDown() {
		Position start = Position.createPositionFromString("d8");
		Position end = Position.createPositionFromString("d7");
		
		assertTrue(whiteKing.isValidPath(start, end));
	}
	
	@Test
	void moveRight() {
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("e1");
		
		assertTrue(whiteKing.isValidPath(start, end));
	}
	
	@Test
	void moveLeft() {
		Position start = Position.createPositionFromString("d1");
		Position end = Position.createPositionFromString("c1");
		
		assertTrue(whiteKing.isValidPath(start, end));
	}
	
	@Test
	void wrongMove() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("c2");
		
		assertFalse(whiteKing.isValidPath(start, end));
	}

}
