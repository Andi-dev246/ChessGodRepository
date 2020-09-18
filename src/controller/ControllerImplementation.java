package controller;

import exceptions.InvalidMoveException;
import model.board.Board;
import model.board.Position;
import model.player.Player;

public class ControllerImplementation implements Controller {
	
	private final Board board;
	private final Player firstPlayer;
	private final Player secondPlayer;
	
	// Positions for processing the Player input
	private Position firstInput;
	private Position secondInput;
	
	
	public ControllerImplementation(Board board ,Player first, Player second) {
		this.board = board;
		
		firstPlayer = first;
		secondPlayer = second;
		
		resetInput();
	}


	@Override
	public void processInput(Position position) throws InvalidMoveException {
		setInput(position);
		if(firstInput != null && secondInput != null) {
			if((board.getNumberOfTurns() % 2) == 0) {
					firstPlayer.movePiece(firstInput, secondInput);
					resetInput();
			} else {
					secondPlayer.movePiece(firstInput, secondInput);
					resetInput();
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


	public void resetInput() {
		firstInput = null;
		secondInput = null;
	}
}
