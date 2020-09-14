package controller;

import exceptions.InvalidMoveException;
import gui.ChessGodGUI;
import gui.GraphicalUserInterface;
import model.board.Board;
import model.board.Position;
import model.player.Player;

public class ControllerImplementation implements Controller {
	
	private final GraphicalUserInterface gui;
	private final Board board;
	private final Player firstPlayer;
	private final Player secondPlayer;
	
	// Positions for processing the Player input
	private Position firstInput;
	private Position secondInput;
	
	
	public ControllerImplementation(ChessGodGUI chessGodGUI, Board board ,Player first, Player second) {
		this.board = board;
		this.gui = chessGodGUI;
		
		firstPlayer = first;
		secondPlayer = second;
		
		resetInput();
	}


	@Override
	public void processInput(Position position) {
		setInput(position);
		if(firstInput != null && secondInput != null) {
			if(board.getNumberOfTurns() % 2 == 0) {
				try {
					firstPlayer.movePiece(firstInput, secondInput);
					gui.displayWhitePerspective();
				} catch (InvalidMoveException e) {
					gui.openTextBox(e.getMessage());
				}
			} else {
				try {
					secondPlayer.movePiece(firstInput, secondInput);
				} catch (InvalidMoveException e) {
					gui.openTextBox(e.getMessage());
				}
			}
		}
	}


	private void setInput(Position position) {
		if(firstInput == null && !board.isEmpty(position)) {
			firstInput = position;
		} else if (firstInput != null && secondInput == null){
			secondInput = position;
		} else {
			resetInput();
		}
	}


	private void resetInput() {
		firstInput = null;
		secondInput = null;
	}
}
