package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.board.Position;

public class ChessButton extends JButton {

	private static final long serialVersionUID = 7406010797024912530L;
	private Position displayedPosition;
	private Position actualPosition;

	ChessButton(Position position) {
		super();
	}

	public Position getDisplayedPosition() {
		return displayedPosition;
	}

	public Position getActualPosition() {
		return actualPosition;
	}

	public void setActualPosition(Position actualPosition) {
		this.actualPosition = actualPosition;
	}
}
