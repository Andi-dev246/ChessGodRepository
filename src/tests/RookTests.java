package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Position;
import pieces.Rook;

class RookTests {

	Rook whiteRook = Rook.createWhiteRook();
	
	@Test
	void moveUp() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("a7");
		
		assertTrue(whiteRook.isValidPath(start, end));
	}
	
	@Test 
	void moveDown() {
		Position start = Position.createPositionFromString("b8");
		Position end = Position.createPositionFromString("b2");
		
		assertTrue(whiteRook.isValidPath(start, end));
	}
	
	@Test
	void moveRight() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("g1");
		
		assertTrue(whiteRook.isValidPath(start, end));
	}
	
	@Test
	void moveLeft() {
		Position start = Position.createPositionFromString("h3");
		Position end = Position.createPositionFromString("a3");
		
		assertTrue(whiteRook.isValidPath(start, end));
	}

	@Test
	void wrongMove() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		assertFalse(whiteRook.isValidPath(start, end));
	}
}
