package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.board.Position;

public class ButtonHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private Position firstClick = null;
	private Position secondClick = null;
	
	private ChessTable chessTable;

	public ButtonHandler(ChessTable table) {
		chessTable = table;
	}
//	
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object source = e.getSource();
//		Board board = chessTable.getBoard();
//
//		Position position = getPositionOfSource(source);
//		if (firstClick == null && !board.isEmpty(position)) {
//			firstClick = position;
//		} else if (firstClick != null && secondClick == null) {
//			secondClick = position;
//			processInput(firstClick, secondClick);
//		}
//	}
//	
//	private Position getPositionOfSource(Object source) {
//		ChessButton[][] tiles = chessTable.getTiles();
//		
//		Position position = null;
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				if (source == tiles[i][j]) {
//					position = tiles[i][j].getActualPosition();
//				}
//			}
//		}
//		return position;
//	}
//	
//	private void processInput(Position firstClick, Position secondClick) {
//		Board board = chessTable.getBoard();
//		Player whitePlayer = chessTable.getWhitePlayer();
//		Player blackPlayer = chessTable.getBlackPlayer();
//		
//		if (board.getNumberOfTurns() % 2 == 0) {
//			try {
//				whitePlayer.movePiece(firstClick, secondClick);
//				chessTable.setIconsOnBoardWhitePerspective();
//				resetClicks();
//				
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//				resetClicks();
//			}
//		} else {
//			try {
//				blackPlayer.movePiece(firstClick, secondClick);
//				chessTable.setIconsOnBoardWhitePerspective();
//				resetClicks();
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//				resetClicks();
//			}
//		}
//	}
//	
//	private void resetClicks() {
//		this.firstClick = null;
//		this.secondClick = null;
//	}
}
