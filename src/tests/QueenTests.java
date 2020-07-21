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
	
	@Test
	void downRightdrawPath() {
		Position start = Position.createPositionFromString("a8");
		Position end = Position.createPositionFromString("h1");
		
		ArrayList<Position> myList = new ArrayList<Position>();
		
		myList.add(Position.createPositionFromString("b7"));
		myList.add(Position.createPositionFromString("c6"));
		myList.add(Position.createPositionFromString("d5"));
		myList.add(Position.createPositionFromString("e4"));
		myList.add(Position.createPositionFromString("f3"));
		myList.add(Position.createPositionFromString("g2"));
		
		assertTrue(whiteQueen.drawPath(start, end).equals(myList));
	}
	
	@Test
	void moveUpDrawPath() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("a7");
		
		ArrayList<Position> myList = new ArrayList<Position>();
		
		myList.add(Position.createPositionFromString("a2"));
		myList.add(Position.createPositionFromString("a3"));
		myList.add(Position.createPositionFromString("a4"));
		myList.add(Position.createPositionFromString("a5"));
		myList.add(Position.createPositionFromString("a6"));
		
		assertTrue(whiteQueen.drawPath(start, end).equals(myList));
	}
	
	@Test 
	void moveDownDrawPath() {
		Position start = Position.createPositionFromString("b8");
		Position end = Position.createPositionFromString("b2");
		
		ArrayList<Position> myList = new ArrayList<Position>();
		
		myList.add(Position.createPositionFromString("b7"));
		myList.add(Position.createPositionFromString("b6"));
		myList.add(Position.createPositionFromString("b5"));
		myList.add(Position.createPositionFromString("b4"));
		myList.add(Position.createPositionFromString("b3"));
		
		assertTrue(whiteQueen.drawPath(start, end).equals(myList));
	}
	
	@Test
	void moveRightDrawPath() {
		Position start = Position.createPositionFromString("a1");
		Position end = Position.createPositionFromString("g1");
		
		ArrayList<Position> myList = new ArrayList<Position>();
		
		myList.add(Position.createPositionFromString("b1"));
		myList.add(Position.createPositionFromString("c1"));
		myList.add(Position.createPositionFromString("d1"));
		myList.add(Position.createPositionFromString("e1"));
		myList.add(Position.createPositionFromString("f1"));
		
		assertTrue(whiteQueen.drawPath(start, end).equals(myList));
	}
	
	@Test
	void moveLeftDrawPath() {
		Position start = Position.createPositionFromString("h3");
		Position end = Position.createPositionFromString("a3");
		
		ArrayList<Position> myList = new ArrayList<Position>();
		
		myList.add(Position.createPositionFromString("g3"));
		myList.add(Position.createPositionFromString("f3"));
		myList.add(Position.createPositionFromString("e3"));
		myList.add(Position.createPositionFromString("d3"));
		myList.add(Position.createPositionFromString("c3"));
		myList.add(Position.createPositionFromString("b3"));
		
		assertTrue(whiteQueen.drawPath(start, end).equals(myList));
	}
}
