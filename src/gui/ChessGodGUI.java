package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.board.Board;
import model.board.Position;
import model.player.ChessColor;

public class ChessGodGUI extends JFrame implements GraphicalUserInterface {

	private static final long serialVersionUID = -8130375271777322489L;
	private Color colorDarkGrey = Color.DARK_GRAY;
	private ImageIcon blackRook = new ImageIcon(".\\res\\BlackRook.png");

	// The associated Board
	@SuppressWarnings("unused")
	private final Board board;

	// private GUI Components
	private Container content;
	private ChessGodButton[][] tiles = new ChessGodButton[8][8];
	private IconInitializer iconInitializer;
	private ChessColor defaultDisplayedColorPerspective; 

	public ChessGodGUI(Board board) {
		// Initialize private GUI Components
		this.board = board;
		iconInitializer = new IconInitializer(board);
		content = getContentPane();
		content.setLayout(new GridLayout(8, 8));
		addButtons();
		defaultDisplayedColorPerspective = ChessColor.WHITE;
			
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

	private void displayWhitePerspective() {
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

	
	private void displayBlackPerspective() {
		// TODO Auto-generated method stub

	}

	@Override
	public JFrame displayText(String text) {
		JFrame frame = new JFrame("InfoBox");
	    final JLabel label = new JLabel();
	    label.setText(text);
	    label.setHorizontalAlignment(SwingConstants.CENTER);
	    frame.getContentPane().add(label);

	    frame.pack();
	    frame.setVisible(true);
	    frame.setLocationRelativeTo(this);
	    frame.setSize(450,150);
	    
	    return frame;
	}

	@Override
	public void addActionListener(ActionListener actionListener, Position position) {
		for(ChessGodButton[] tiles_row: tiles) {
			for(ChessGodButton tile : tiles_row) {
				if(tile.getPosition().equals(position)) {
					tile.addActionListener(actionListener);
				}
			}
		}
	}

	@Override
	public void update() {
		if(defaultDisplayedColorPerspective == ChessColor.BLACK) {
			displayWhitePerspective();
		} else {
			displayWhitePerspective();
		}
	}
}
