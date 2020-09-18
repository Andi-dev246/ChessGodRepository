package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controller;
import exceptions.InvalidMoveException;
import model.board.Board;
import model.board.Position;

public class ChessGodGUI extends JFrame implements GraphicalUserInterface {

	private static final long serialVersionUID = -8130375271777322489L;
	private Color colorDarkGrey = Color.DARK_GRAY;
	private ImageIcon blackRook = new ImageIcon(".\\res\\BlackRook.png");

	// The associated Board
	private final Board board;
	private final Controller controller;

	// private GUI Components
	private Container content;
	private ChessGodButton[][] tiles = new ChessGodButton[8][8];
	private IconInitializer iconInitializer;

	public ChessGodGUI(Board board, Controller controller) {
		// Initialize private GUI Components
		this.board = board;
		this.controller = controller;
		iconInitializer = new IconInitializer(board);
		content = getContentPane();
		content.setLayout(new GridLayout(8, 8));
			
		//Add Buttons 
		addButtons();
		
		// Set default Close Operation
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Setup the basic Layout of the Board
		setIconImage(blackRook.getImage());
		setSize(800, 800);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		colorChessBoard();
		
		//display WhitePerspective
		displayWhitePerspective();
	}
	
	private void addButtons() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				tiles[i][j] = new ChessGodButton(Position.createPositionFromInt(new int[] {i,j}));
				tiles[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ChessGodButton button = (ChessGodButton) e.getSource();
						try {
							controller.processInput(button.getPosition());
							displayWhitePerspective();
						} catch (InvalidMoveException e1) {
							controller.resetInput();
							e1.printStackTrace();
						}
					}
				});
				
				content.add(tiles[i][j]);
			}
		}
	}

	private void colorChessBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					tiles[i][j].setBackground(colorDarkGrey);
				}
			}
		}
	}

	@Override
	public void displayWhitePerspective() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Position position = Position.createPositionFromInt(new int[] { i, j });
				ImageIcon icon = iconInitializer.getIconImagesFromBoard(position);

				// The Chess Coordinates are different from the matrix coordinates
				tiles[7 - i][j].setIcon(icon);
				tiles[7 - i][j].setPosition(position);
			}
		}
	}

	@Override
	public void displayBlackPerspective() {
		// TODO Auto-generated method stub

	}

	@Override
	public JFrame openTextBox(String text) {
		JFrame frame = new JFrame("InfoBox");
	    final JLabel label = new JLabel(text);
	    frame.getContentPane().add(label);

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	    
	    return frame;
	}
}
