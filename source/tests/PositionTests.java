package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import model.board.Position;

class PositionTests {

	@Test
	void createPositionFromStringTest() {
		Position position  = Position.createPositionFromString("a1");

		assertArrayEquals(new int[] { 0, 0 }, position.getPositionAsInteger());
	}
	
	@Test
	void createPositionFromStringTest2() {
		Position position2 = Position.createPositionFromString("h8");
		
		assertArrayEquals(new int[] { 7, 7 }, position2.getPositionAsInteger());
	}
	
	@Test
	void createPositionFromStringTest3() {
		Position position3 = Position.createPositionFromString("e4");
		
		assertArrayEquals(new int[] { 3, 4 }, position3.getPositionAsInteger());
	} 
	
	@Test
	void createPositionFromStringTest4() {
		Position position4 = Position.createPositionFromString("c2");
		
		assertArrayEquals(new int[] { 1, 2 }, position4.getPositionAsInteger());
	}
	
	@Test
	void getPositionAsString() {
		Position position = Position.createPositionFromString("a1");
		
		assertTrue(position.getPositionAsString().equals("a1"));
	}
	
	@Test
	void getPositionAsString2() {
		Position position = Position.createPositionFromString("h3");
		
		assertTrue(position.getPositionAsString().equals("h3"));
	}
	
	@Test
	void getPositionAsString3() {
		Position position = Position.createPositionFromInt(new int[] {4,6});
		assertTrue(position.getPositionAsString().equals("g5"));
	}
}