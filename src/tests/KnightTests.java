package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Position;
import pieces.Knight;

class KnightTests {

	Knight whiteKnight = Knight.createWhiteKnight();
	
	@Test
	void upLeft() {
		Position start = Position.createPositionFromString("f5");
		Position end = 	 Position.createPositionFromString("e7");
		
		assertTrue(whiteKnight.isValidPath(start, end));
	}
	
	@Test
	void upRight() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("g7");
		
		assertTrue(whiteKnight.isValidPath(start, end));
	}
	
	@Test
	void downLeft() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("e3");
		
		assertTrue(whiteKnight.isValidPath(start, end));
	}
	
	@Test
	void downRight() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("g3");
		
		assertTrue(whiteKnight.isValidPath(start, end));
	}
	
	@Test
	void leftUp() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("d6");
		
		assertTrue(whiteKnight.isValidPath(start, end));
	}
	
	@Test 
	void leftDown() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("d4");
		
		assertTrue(whiteKnight.isValidPath(start, end));
	}
	
	@Test
	void rightUp() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h6");
		
		assertTrue(whiteKnight.isValidPath(start, end));
	}
	
	@Test
	void rightDown() {
		Position start = Position.createPositionFromString("f5");
		Position end = Position.createPositionFromString("h4");
		
		assertTrue(whiteKnight.isValidPath(start, end));
	}
	
	@Test
	void wrongMove() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("c1");
		
		assertFalse(whiteKnight.isValidPath(start, end));
	}


}
