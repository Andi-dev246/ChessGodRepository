package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import board.Position;
import pieces.Queen;

class QueenTests {

	Queen whiteQueen = Queen.createWhiteQueen();
	
	@Test
	void upLeft() {
		Position start = Position.createPositionFromInt(new int[] {2,3});
		Position end = 	 Position.createPositionFromInt(new int[] {0,5});
		
		assertTrue(whiteQueen.isValidPath(start, end));
	}
	
	@Test
	void upRight() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("h8");
		
		assertTrue(whiteQueen.isValidPath(start, end));
	}
	
	@Test
	void downLeft() {
		Position start = Position.createPositionFromString("g7");
		Position end = Position.createPositionFromString("d4");
		
		assertTrue(whiteQueen.isValidPath(start, end));
	}
	
	@Test
	void downRight() {
		Position start = Position.createPositionFromString("a8");
		Position end = Position.createPositionFromString("h1");
		
		assertTrue(whiteQueen.isValidPath(start, end));
	}
	
	@Test
	void moveUp() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("a7");
		
		assertTrue(whiteQueen.isValidPath(start, end));
	}
	
	@Test 
	void moveDown() {
		Position start = Position.createPositionFromString("b8");
		Position end = Position.createPositionFromString("b2");
		
		assertTrue(whiteQueen.isValidPath(start, end));
	}
	
	@Test
	void moveRight() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("g1");
		
		assertTrue(whiteQueen.isValidPath(start, end));
	}
	
	@Test
	void moveLeft() {
		Position start = Position.createPositionFromString("h3");
		Position end = Position.createPositionFromString("a3");
		
		assertTrue(whiteQueen.isValidPath(start, end));
	}
	
	@Test
	void wrongMove() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("c2");
		
		assertFalse(whiteQueen.isValidPath(start, end));
	}
	
	@Test
	void upLeftDrawPath() {
		Position start = Position.createPositionFromInt(new int[] {2,3});
		Position end = 	 Position.createPositionFromInt(new int[] {0,5});
		
		ArrayList<Position> myList = new ArrayList<Position>();
		
		myList.add(Position.createPositionFromInt(new int[] {1,4}));
		
		assertTrue(whiteQueen.drawPath(start,end).equals(myList));
	}
	
	@Test
	void upRightDrawPath() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("d4");
		
		ArrayList<Position> myList = new ArrayList<Position>();
		
		myList.add(Position.createPositionFromString("b2"));
		myList.add(Position.createPositionFromString("c3"));
		
		assertTrue(whiteQueen.drawPath(start, end).equals(myList));
	}
	
	@Test
	void downLeftdrawPath() {
		Position start = Position.createPositionFromString("g7");
		Position end = Position.createPositionFromString("d4");
		
		ArrayList<Position> myList = new ArrayList<Position>();
		
		myList.add(Position.createPositionFromString("f6"));
		myList.add(Position.createPositionFromString("e5"));
		
		assertTrue(whiteQueen.drawPath(start, end).equals(myList));
	}
}
