package gui;

import javax.swing.JButton;

import model.board.Position;

public class ChessGodButton extends JButton {
	
	//The Button has other matrix coordinates than displayed coordinates. 
	//So we keep track of the actual position of the tile although the displayed may change.
	private Position position;
	
	public ChessGodButton(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
