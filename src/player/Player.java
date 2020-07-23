package player;

import java.util.ArrayList;

import board.Board;
import board.Position;
import exceptions.InvalidMoveException;
import pieces.Piece;

public class Player {

	private Color color;

	private Player(Color color) {
		this.color = color;
	}

	public static Player createWhitePlayer() {
		return new Player(Color.WHITE);
	}

	public static Player createBlackPlayer() {
		return new Player(Color.BLACK);
	}

}
