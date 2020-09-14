package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.ChessGodActionListener;
import model.board.Board;
import model.board.Position;

public class ChessGodGUI extends JFrame implements GraphicalUserInterface {

	private static final long serialVersionUID = -8130375271777322489L;
	private Color colorDarkGrey = Color.DARK_GRAY;
	private ImageIcon blackRook = new ImageIcon(".\\res\\BlackRook.png");
	
	// The associated Board 
	private final Board board;
	
	//private GUI Components
	private Container content;
	private ChessGodButton[][] tiles= new ChessGodButton[8][8];
	private IconInitializer iconInitializer;
	
	public ChessGodGUI (Board board) {
		//Initialize private GUI Components
		this.board = board;
		iconInitializer = new IconInitializer(board);
		content = getContentPane();
		content.setLayout(new GridLayout(8, 8));
		
		//Add Event Handlers
		addEventHandlers();
		
		//Set default Close Operation
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Setup the basic Layout of the Board
		setIconImage(blackRook.getImage());
		setSize(800, 800);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		colorChessBoard();
	}

	private void colorChessBoard() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if((i + j) % 2 == 0) {
					tiles[i][j].setBackground(colorDarkGrey);
				}
			}
		}
	}

	private void addEventHandlers() {
		ChessGodActionListener actionListener = new ChessGodActionListener();
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				tiles[i][j] = new ChessGodButton(Position.createPositionFromInt(new int[] {i,j}));
				tiles[i][j].addActionListener(actionListener);
				
				content.add(tiles[i][j]);
			}
		}
	}
	
	@Override
	public void displayWhitePerspective() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Position position = Position.createPositionFromInt(new int[] {i, j });
				ImageIcon icon = iconInitializer.getIconImagesFromBoard(position);
				
				//The Chess Coordinates are different from the matrix coordinates
				tiles[7-i][j].setIcon(icon);
				tiles[7-i][j].setPosition(position);
			}
		}
	}

	@Override
	public void displayBlackPerspective() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openTextBox(String text) {
		// TODO Auto-generated method stub
		
	}

}
