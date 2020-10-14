package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.InvalidMoveException;
import gui.GraphicalUserInterface;
import model.Board;
import model.Player;
import model.board.Position;

public class Processor {
	
	private final Board board;
	private Player firstPlayer;
	private Player secondPlayer;
	private GraphicalUserInterface gui;
	
	// Positions for processing the Player input
	private Position firstInput;
	private Position secondInput;
	
	
	public Processor(Board board) {
		this.board = board;
		resetInput();
	}

	public void processInput(Position position) {
		setInput(position);
		if(firstInput != null && secondInput != null) {
			if((board.getNumberOfTurns() % 2) == 0) {
					try {
						firstPlayer.movePiece(firstInput, secondInput);
						if(secondPlayer.isCheckmate()) {
							gui.displayText("The Black Player is checkmate. White has won!");
						} else if(secondPlayer.isStalemate()) {
							gui.displayText("Stalemate! The Game is over.");
						}
					} catch (InvalidMoveException e) {
						if(firstPlayer.isCheckmate()) {
							gui.displayText("White is checkmate the Game is over.");
						} else {
							gui.displayText(e.getMessage());
						}
					} catch(Exception e) {
						gui.displayText("An unknown Error has occured.");
					}
			} else {
					try {
						secondPlayer.movePiece(firstInput, secondInput);
						if(firstPlayer.isCheckmate()) {
							gui.displayText("The White Player is checkmate. Black has won!");
						} else if (firstPlayer.isStalemate()){
							gui.displayText("Stalemate! The Game is over.");
						}
					} catch (InvalidMoveException e) {
						if(secondPlayer.isCheckmate()) {
							gui.displayText("Black is checkmate the Game is over.");
						} else {
							gui.displayText(e.getMessage());
						}
					} catch(Exception e) {
						gui.displayText("An unknown Error has occured.");
					}
			}
			resetInput();
			gui.update();
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

	public void addGUI(GraphicalUserInterface gui) {
		this.gui = gui;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				Position position = Position.createPositionFromInt(new int[] {i,j});
				gui.addActionListener(new ButtonHandler(position), position);
			}
		}
	}

	public void addFirstPlayer(Player player) {
		firstPlayer = player;
		
	}

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
