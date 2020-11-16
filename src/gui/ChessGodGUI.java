package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import controller.Processor;
import model.Board;
import model.board.Position;
import model.player.ChessColor;

public class ChessGodGUI extends JFrame implements GraphicalUserInterface {

	private static final long serialVersionUID = -8130375271777322489L;
	private Color colorDarkGrey = Color.DARK_GRAY;
	private ImageIcon blackRook = new ImageIcon(".\\res\\BlackRook.png");

	// The associated Board
	@SuppressWarnings("unused")
	private final Board board;
	private Processor processor;

	// private GUI Components
	private Container content;
	private JButton[][] tiles = new JButton[8][8];
	private IconInitializer iconInitializer;
	private ChessColor defaultDisplayedColorPerspective; 
	
	//Menu
	JMenuBar menuBar;
	JMenu menuView, menuGame;
	JMenuItem menuItem;

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
		
		//Setup Menu
		createMenu();

		// Setup the basic Layout of the Board
		setIconImage(blackRook.getImage());
		// Height needs a little bit higher because of the menu bar
		setSize(800, 810);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		colorChessBoard();
		
		
		//display WhitePerspective
		displayWhitePerspective();
	}

	private void createMenu() {
		menuBar = new JMenuBar();
		menuView = new JMenu("View");
		menuGame = new JMenu("Game");
		setJMenuBar(menuBar);
		menuBar.add(menuGame);
		menuBar.add(menuView);
		
		JMenuItem whitePerspective = new JMenuItem("White Perspective");
		JMenuItem blackPerspective = new JMenuItem("Black Perspective");
		whitePerspective.addActionListener((e) -> setDefaultDisplayedColorPerspective(ChessColor.WHITE));
		blackPerspective.addActionListener((e) -> setDefaultDisplayedColorPerspective(ChessColor.BLACK));
		
		menuView.add(whitePerspective);
		menuView.add(blackPerspective);
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
				if ((i + j) % 2 == 1) {
					tiles[i][j].setBackground(colorDarkGrey);
				}
			}
		}
	}

	public void displayWhitePerspective() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Position position = Position.createPositionFromInt(new int[] { i, j });
				ImageIcon icon = iconInitializer.getIconImagesFromBoard(position);

				// The Chess Coordinates are different from the matrix coordinates
				JButton tile = tiles[7 - i][j];
				tile.setIcon(icon);
				activateActionListener(tile ,ChessColor.WHITE);
			}
		}
	}

	
	private void activateActionListener(JButton tile, ChessColor color) {
		 ActionListener[] actionListeners = tile.getActionListeners();
		for(ActionListener ac: actionListeners) {
			if(ac.getClass() == ButtonHandler.class) {
				ButtonHandler bh = (ButtonHandler) ac;
				if(bh.getColor() == color) {
					bh.setActivated(true);
				} else {
					bh.setActivated(false);
				}
			}
		}
	}

	public void displayBlackPerspective() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Position position = Position.createPositionFromInt(new int[] { i, j });
				ImageIcon icon = iconInitializer.getIconImagesFromBoard(position);

				// The Chess Coordinates are different from the matrix coordinates
				JButton tile = tiles[i][7-j];
				tile.setIcon(icon);
				activateActionListener(tile ,ChessColor.BLACK);
			}
		}
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
	public void update() {
		if(defaultDisplayedColorPerspective == ChessColor.BLACK) {
			displayBlackPerspective();
		} else {
			displayWhitePerspective();
		}
	}

	@Override
	public void addProcessor(Processor processor) {
		this.processor = processor;
		addActionListenersWhitePerspective();
		addActionListenersBlackPerspective();
	}
	
	private void addActionListenersBlackPerspective() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				Position position = Position.createPositionFromInt(new int[] {i,j});
				ButtonHandler bh = new ButtonHandler(position, ChessColor.BLACK);
				tiles[i][7-j].addActionListener(bh);
			}
		}
	}

	private void addActionListenersWhitePerspective() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				Position position = Position.createPositionFromInt(new int[] {i,j});
				ButtonHandler bh = new ButtonHandler(position, ChessColor.WHITE);
				bh.setActivated(true);
				tiles[7-i][j].addActionListener(bh);
			}
		}
	}
	
	private void setDefaultDisplayedColorPerspective(ChessColor color) {
		defaultDisplayedColorPerspective = color;
		update();
	}
	
	private class ButtonHandler implements ActionListener {
		
		Position actualPosition;
		
		private boolean isActivated;
		
		// The Color specifies in which perspective the ButtonHandler shall be activated
		ChessColor color;
		
		public ButtonHandler(Position position, ChessColor color) {
			actualPosition = position;
			this.color = color;
			setActivated(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(isActivated) {
				processor.processInput(actualPosition);
			} 
		}

		public void setActivated(boolean isActivated) {
			this.isActivated = isActivated;
		}

		public ChessColor getColor() {
			return color;
		}
	}
}
