package model.board;

import java.util.Arrays;


public class Position {
	
	int[] position;
	
	private Position (int[] position) {
			this.position = position;
	}
	
	private Position(String string) {
			 this.position = stringToInt(string);
	}
	
	public static Position createPositionFromInt (int[] integer) {
		return new Position(integer);
	}
	
	public static Position createPositionFromString (String string)  {
		return new Position(string);
	}
	
	private static int[] stringToInt (String string) {
			 char secondCoordinateFromString = string.toLowerCase().charAt(0);
			 int firstCoodinateFromString = (int)string.charAt(1)-'0';
			 return new int[] {firstCoodinateFromString-1, Character.compare(secondCoordinateFromString,'a')};
	}
	
	
	private static String intToString(int[] position) {
		char firstCoordinateFromInt = (char)(position[1] + 97);			// The char 'a' has the int value 97
		char secondCoordinateFromInt = (char)(position[0] + '0' + 1);
		
		return String.valueOf(firstCoordinateFromInt) + String.valueOf(secondCoordinateFromInt);
	}
	
	public int[] getPositionAsInteger() {
		return this.position;
	}
	
	public String getPositionAsString() {
		return intToString(this.position);
	}
	
	@Override
	public String toString() {
		return "Position [position=" + Arrays.toString(position) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(position);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (!Arrays.equals(position, other.position))
			return false;
		return true;
	}
}
