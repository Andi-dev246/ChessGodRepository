package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;

import org.junit.jupiter.api.Test;

import board.Position;
import exceptions.InvalidPositionException;

class PositionTests {

	@Test
	void createPositionFromStringTest() {
		Position position  = Position.createPositionFromString("a1");

		assertArrayEquals(new int[] { 0, 0 }, position.getIntegerPosition());
	}
	
	@Test
	void createPositionFromStringTest2() {
		Position position2 = Position.createPositionFromString("h8");
		
		assertArrayEquals(new int[] { 7, 7 }, position2.getIntegerPosition());
	}
	
	@Test
	void createPositionFromStringTest3() {
		Position position3 = Position.createPositionFromString("e4");
		
		assertArrayEquals(new int[] { 3, 4 }, position3.getIntegerPosition());
	} 
	
	@Test
	void createPositionFromStringTest4() {
		Position position4 = Position.createPositionFromString("c2");
		
		assertArrayEquals(new int[] { 1, 2 }, position4.getIntegerPosition());
	}
	
	@Test
	void createPositionFromStringTest5() {
		Position position  = Position.createPositionFromString("g5");

		assertArrayEquals(new int[] { 4, 6 }, position.getIntegerPosition());
	}
	
	@Test
	void PositionIsValidPositionTest() {

		InvalidPositionException exception = assertThrows(InvalidPositionException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
			Position.exceptionPositionIsInvalid(new int [] {1,8});
			}
		});
		String expectedMessage = "This Position is invalid.";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	void PositionIsValidPositionTest2() {

		InvalidPositionException exception = assertThrows(InvalidPositionException.class, () -> {
			Position.exceptionPositionIsInvalid(new int[] {1,2,3});
		}
				);
		String expectedMessage = "This Position has more than two coordinates.";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
}