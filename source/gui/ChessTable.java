package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.board.Board;
import model.board.Position;
import model.player.Player;

public class ChessTable extends JFrame {

	private static final long serialVersionUID = -3488125002056849561L;
	private Container content;
	private final Board board;
	
	private Color colorDarkGrey = Color.DARK_GRAY;
	private IconInitializer iconInitializer;

	// Components
	private ChessButton[][] tiles = new ChessButton[8][8];
	private ImageIcon blackRook = new ImageIcon(".\\res\\BlackRook.png");

	public ChessTable(Board board, Player whitePlayer, Player blackPlayer) {
		super("ChessGod");
		this.board = board;
		
		iconInitializer = new IconInitializer(board);
		
		content = getContentPane();
		content.setLayout(new GridLayout(8, 8));

		ButtonHandler bh = new ButtonHandler(this);

		// Create EventHandlers

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Position position = Position.createPositionFromInt(new int[] { i, j});
				tiles[i][j] = new ChessButton(position);
				content.add(tiles[i][j]);
				tiles[i][j].addActionListener(bh);
			}
		}
		setIconsOnBoardWhitePerspective();
		setIconImage(blackRook.getImage());
		setSize(800, 800);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	protected ChessButton[][] getTiles() {
		return tiles;
	}
	
	protected Board getBoard() {
		return board;
	}
	//
	public void setIconsOnBoardWhitePerspective() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Position position = Position.createPositionFromInt(new int[] {i, j });
				ImageIcon Ic = iconInitializer.getIconImagesFromBoard(position);
				tiles[7-i][j].setIcon(Ic);
				tiles[7-i][j].setActualPosition(position);
			}
		}
	}
}
