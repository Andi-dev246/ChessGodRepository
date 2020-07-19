package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Position;
import pieces.Bishop;

class BishopTests {

	Bishop whiteBishop = Bishop.createWhiteBishop();
	
	@Test
	void upLeft() {
		Position start = Position.createPositionFromInt(new int[] {2,3});
		Position end = 	 Position.createPositionFromInt(new int[] {0,5});
		
		assertTrue(whiteBishop.isValidPath(start, end));
	}
	
	@Test
	void upRight() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		assertTrue(whiteBishop.isValidPath(start, end));
	}
	
	@Test
	void downLeft() {
		Position start = Position.createPositionFromString("g7");
		Position end = Position.createPositionFromString("d4");
		
		assertTrue(whiteBishop.isValidPath(start, end));
	}
	
	@Test
	void downRight() {
		Position start = Position.createPositionFromString("a8");
		Position end = Position.createPositionFromString("h1");
		
		assertTrue(whiteBishop.isValidPath(start, end));
	}
	
	@Test
	void nonValidPath() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h1");
		
		assertFalse(whiteBishop.isValidPath(start, end));
	}
}
