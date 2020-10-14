package model.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import model.Board;
import model.Piece;

public class BoardImplementation implements Board, Cloneable {
	
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
	
	@Override
	public Board clone() {
		Board clonedBoard = new BoardImplementation();
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				Position position = Position.createPositionFromInt(new int[]{i,j});
				if(!isEmpty(position)) {
					getPiece(position).cloneOnBoard(clonedBoard);
				}
			}
		}
		return clonedBoard;
	}
	
	public Board getBoardInTurn(int i) {
		return boardHistory.getBoardInTurn(i);
	}
	
	@Override
	public Iterator<Piece> iterator() {
		List<Piece> pieceList = new ArrayList<>();
		for(Piece[] pieceRow: board) {
			for(Piece piece: pieceRow) {
				if(piece != null) {
					pieceList.add(piece);
				}
			}
		}
		return pieceList.iterator();
	}

	@Override
	public void addToHistory() {
		boardHistory.addToHistory(clone());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(board);
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
		BoardImplementation other = (BoardImplementation) obj;
		if (!Arrays.deepEquals(board, other.board))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardImplementation [board=" + Arrays.deepToString(board) + "]";
	}
	
}
