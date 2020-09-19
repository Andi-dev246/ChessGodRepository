package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.InvalidMoveException;
import gui.GraphicalUserInterface;
import model.board.Board;
import model.board.Position;
import model.player.Player;

public class ProcessorImplementation implements Processor {
	
	private final Board board;
	private Player firstPlayer;
	private Player secondPlayer;
	private GraphicalUserInterface gui;
	
	// Positions for processing the Player input
	private Position firstInput;
	private Position secondInput;
	
	
	public ProcessorImplementation(Board board) {
		this.board = board;
		resetInput();
	}

	@Override
	public void processInput(Position position) {
		setInput(position);
		if(firstInput != null && secondInput != null) {
			if((board.getNumberOfTurns() % 2) == 0) {
					try {
						firstPlayer.movePiece(firstInput, secondInput);
					} catch (InvalidMoveException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					resetInput();
					gui.update();
			} else {
					try {
						secondPlayer.movePiece(firstInput, secondInput);
					} catch (InvalidMoveException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					resetInput();
					gui.update();
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

	@Override
	public void addGUI(GraphicalUserInterface gui) {
		this.gui = gui;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				Position position = Position.createPositionFromInt(new int[] {i,j});
				gui.addActionListener(new ButtonHandler(position), position);
			}
		}
	}

	@Override
	public void addFirstPlayer(Player player) {
		firstPlayer = player;
		
	}

	@Override
	public void addSecondPlayer(Player player) {
		secondPlayer = player;
	}
	
	private class ButtonHandler implements ActionListener {
		
		final Position position;
		
		public ButtonHandler(Position position) {
			this.position = position;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			processInput(position);
		}
	}
}
