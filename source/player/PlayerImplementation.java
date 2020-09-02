package player;

import board.Board;
import board.Position;
import exceptions.InvalidMoveException;

public class PlayerImplementation implements Player {
	 
	private ChessColor color;
	private final Board board;

	private PlayerImplementation(Board board, ChessColor color) {
		this.color = color;
		this.board = board;
	}

	@Override
	public void movePiece(Position start, Position end) throws InvalidMoveException {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isInCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCheckmate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStalemate() {
		// TODO Auto-generated method stub
		return false;
	}
}
