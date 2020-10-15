package gui;


import javax.swing.JFrame;

import controller.Processor;


public interface GraphicalUserInterface {
	
	public void update();
	
	public JFrame displayText(String text);
	
	public void addProcessor(Processor processor);
}
