package controller;

import exceptions.InvalidMoveException;
import model.board.Position;

public interface Controller {
	
	public void processInput(Position position) throws InvalidMoveException;
	
	public void resetInput();

}