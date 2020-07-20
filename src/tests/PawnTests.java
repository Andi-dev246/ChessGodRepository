package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Position;
import pieces.Pawn;

class PawnTests {

	Pawn whitePawn = Pawn.createWhitePawn();
	Pawn blackPawn = Pawn.createBlackPawn();
	
	@Test
	void firstBlackPawnMove() {
		Position start = Position.createPositionFromString("a7");
		Position end = Position.createPositionFromString("a5");
		
		assertTrue(blackPawn.isValidPath(start, end));
	}
	
	@Test
	void secondBlackPawnMove() {
		Position start = Position.createPositionFromString("a6");
		Position end = Position.createPositionFromString("a5");
		this.blackPawn.setNumberOfMoves(2);
		
		assertTrue(blackPawn.isValidPath(start, end));
	}

	@Test
	void wrongSecondBlackPawnMove () {
		Position start = Position.createPositionFromString("a6");
		Position end = Position.createPositionFromString("a4");
		this.blackPawn.setNumberOfMoves(2);
		
		assertFalse(blackPawn.isValidPath(start, end));
	}
	
	@Test
	void wrongGeneralBlackPawnMove () {
		Position start = Position.createPositionFromString("a4");
		Position end = Position.createPositionFromString("a5");
		
		assertFalse(blackPawn.isValidPath(start, end));
	}
	
	@Test
	void firstWhitePawnMove() {
		Position start = Position.createPositionFromString("a2");
		Position end = Position.createPositionFromString("a4");
		
		assertTrue(whitePawn.isValidPath(start, end));
	}
	
	@Test
	void secondWhitePawnMove() {
		Position start = Position.createPositionFromString("a4");
		Position end = Position.createPositionFromString("a5");
		this.whitePawn.setNumberOfMoves(2);
		
		assertTrue(whitePawn.isValidPath(start, end));
	}

	@Test
	void wrongSecondWhitePawnMove () {
		Position start = Position.createPositionFromString("a3");
		Position end = Position.createPositionFromString("a5");
		this.whitePawn.setNumberOfMoves(2);
		
		assertFalse(whitePawn.isValidPath(start, end));
	}
	
	@Test
	void wrongGeneralWhitePawnMove () {
		Position start = Position.createPositionFromString("a3");
		Position end = Position.createPositionFromString("a2");
		
		assertFalse(whitePawn.isValidPath(start, end));
	}
}
