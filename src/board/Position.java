package board;

import java.io.Serializable;

import exceptions.InvalidPositionException;

public class Position implements Serializable{
	
	private static final long serialVersionUID = 4153102677384358856L;
	
	int[] position;
	
	private Position (int[] position) {
		try {
			exceptionPositionIsInvalid(position);
			this.position = position;
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	private Position(String string) {
		try {
			exceptionPositionIsInvalid(stringToInt(string));
			 this.position = stringToInt(string);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public static Position createPositionFromInt (int[] integer) {
		return new Position(integer);
	}
	
	public static Position createPositionFromString (String string)  {
		return new Position(string);
	}
	
	private static int[] stringToInt (String string) throws Exception{
			 exceptionPositionDoesNotHaveTwoCoordinates(string);	
			 char secondCoordinateFromString = string.toLowerCase().charAt(0);
			 int firstCoodinateFromString = (int)string.charAt(1)-'0';
			 return new int[] {firstCoodinateFromString-1, Character.compare(secondCoordinateFromString,'a')};
	}
	
	private static String intToString(int[] position) {
		char firstCoordinateFromInt = (char)(position[1] + 97);
		char secondCoordinateFromInt = (char)(position[0] + '0' + 1);
		
		return String.valueOf(firstCoordinateFromInt) + String.valueOf(secondCoordinateFromInt);
	}
	
	public int[] getPositionAsInteger() {
		return this.position;
	}
	
	public String getPositionAsString() {
		return intToString(this.position);
	}
	
	public static void exceptionPositionIsInvalid(int [] position) throws Exception {
		if(position.length != 2) {
			throw new InvalidPositionException("This Position has more than two coordinates.");
		}
		else if(isOutOfBounds(position)) {
			throw new InvalidPositionException();
		}
	}
	
	private static boolean isOutOfBounds(int [] position) {
		return position[0]<0 || position[0]>7 || position[1]<0 || position[1]>7;
	}
	
	
	private static void exceptionPositionDoesNotHaveTwoCoordinates(String position) throws Exception {
		if(2 != position.length())
			throw new InvalidPositionException("This Position does not have two unique coordinates.");
	}
}
