package model.board;

import java.util.ArrayList;
import java.util.List;

public class BoardHistory {
	private List<Board> boardHistory;
	
	protected BoardHistory() {
		boardHistory = new ArrayList<Board>();
	}
	
	public int getNumberOfTurns() {
		return boardHistory.size();
	}
	
	public void addToHistory(Board board) {
		boardHistory.add(board);
	}
	
	public Board getBoardInTurn(int i) {
		return boardHistory.get(i);
	}
}
