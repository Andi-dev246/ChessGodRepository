package board;

import pieces.Piece;

public class BoardImplementation implements Board {
	
	private Piece[][] board; 
	private BoardHistory boardHistory;
	
	public BoardImplementation() {
		board = new Piece[8][8];
		boardHistory = new BoardHistory();
	}

	@Override
	public Piece getPiece(Position position) {
		int row = position.getPositionAsInteger()[0];
		int column = position.getPositionAsInteger()[1];
		
		return board[row][column];
	}

	@Override
	public void setPiece(Piece piece, Position position) {
		int row = position.getPositionAsInteger()[0];
		int column = position.getPositionAsInteger()[1];
		
		board[row][column] = piece;
	}

	@Override
	public boolean isEmpty(Position position) {
		return this.getPiece(position) == null;
	}

	@Override
	public int getNumberOfTurns() {
		return boardHistory.getNumberOfTurns();
	}

}
