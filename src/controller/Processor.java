package controller;

import exceptions.InvalidMoveException;
import gui.GraphicalUserInterface;
import model.board.Position;
import model.player.Player;

public interface Processor {
	
	public void addGUI(GraphicalUserInterface gui);
	
	public void addFirstPlayer(Player player);
	
	public void addSecondPlayer(Player player);
	
	public void processInput(Position position) throws InvalidMoveException;
	
	public void resetInput();

}