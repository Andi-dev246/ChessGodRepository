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
}
