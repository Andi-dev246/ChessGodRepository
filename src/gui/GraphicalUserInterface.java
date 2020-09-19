package gui;


import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.board.Position;


public interface GraphicalUserInterface {
	
	public void addActionListener(ActionListener actionListener, Position position);
	
	public void update();
	
	public JFrame displayText(String text);
}
