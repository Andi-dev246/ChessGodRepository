package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import board.Board;
import board.Position;
import board.Tile;
import pieces.Piece;
import pieces.PieceType;
import player.ChessColor;
import player.Player;

public class ChessTable extends JFrame {

	private static final long serialVersionUID = 4112715978261239436L;
	private Container content;
	private Board board;

	// Components
	private ChessButton[][] tiles = new ChessButton[8][8];

	private Color colorDarkGrey = Color.DARK_GRAY;
	private ImageIcon whiteRook = new ImageIcon(".\\res\\WhiteRook.png");
	private ImageIcon blackRook = new ImageIcon(".\\res\\BlackRook.png");
	private ImageIcon whiteKnight = new ImageIcon(".\\res\\WhiteKnight.png");
	private ImageIcon blackKnight = new ImageIcon(".\\res\\BlackKnight.png");
	private ImageIcon whiteBishop = new ImageIcon(".\\res\\WhiteBishop.png");
	private ImageIcon blackBishop = new ImageIcon(".\\res\\BlackBishop.png");
	private ImageIcon whiteKing = new ImageIcon(".\\res\\WhiteKing.png");
	private ImageIcon blackKing = new ImageIcon(".\\res\\BlackKing.png");
	private ImageIcon whiteQueen = new ImageIcon(".\\res\\WhiteQueen.png");
	private ImageIcon blackQueen = new ImageIcon(".\\res\\BlackQueen.png");
	private ImageIcon whitePawn = new ImageIcon(".\\res\\WhitePawn.png");
	private ImageIcon blackPawn = new ImageIcon(".\\res\\BlackPawn.png");

	public ChessTable(Board board) {
		super("ChessGod");
		this.board = board;

		content = getContentPane();
		content.setLayout(new GridLayout(8, 8));

		ButtonHandler bh = new ButtonHandler();

		// Create EventHandlers

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Position position = Position.createPositionFromInt(new int[] { i, j});
				tiles[i][j] = new ChessButton(position);
				
				if (Tile.getColor(position) == ChessColor.BLACK) {
					tiles[i][j].setBackground(colorDarkGrey);
				}
				content.add(tiles[i][j]);
				tiles[i][j].addActionListener(bh);
			}
		}
		setIconsOnBoardWhitePerspective(board);
		setIconImage(blackRook.getImage());
		setSize(800, 800);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setIconsOnBoardWhitePerspective(Board board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Position position = Position.createPositionFromInt(new int[] {i, j });
				ImageIcon Ic = getIconImagesFromBoard(position, board);
				tiles[7-i][j].setIcon(Ic);
				tiles[7-i][j].setActualPosition(position);
			}
		}
	}


	private ImageIcon getIconImagesFromBoard(Position position, Board board) {
		Tile tile = board.getTile(position);
		ImageIcon pieceIcon = null;
		if (tile.isEmpty() == false) {
			Piece piece = tile.getPiece();
			ChessColor color = piece.getColor();
			PieceType pieceType = piece.getPieceType();
			switch (pieceType) {
			case BISHOP:
				if (color == ChessColor.WHITE) {
					pieceIcon = initImageIcon(whiteBishop);
					break;
				} else {
					pieceIcon = initImageIcon(blackBishop);
					break;
				}
			case KING:
				if (color == ChessColor.WHITE) {
					pieceIcon = initImageIcon(whiteKing);
					break;
				} else {
					pieceIcon = initImageIcon(blackKing);
					break;
				}
			case KNIGHT:
				if (color == ChessColor.WHITE) {
					pieceIcon = initImageIcon(whiteKnight);
					break;
				} else {
					pieceIcon = initImageIcon(blackKnight);
					break;
				}
			case PAWN:
				if (color == ChessColor.WHITE) {
					pieceIcon = initImageIcon(whitePawn);
					break;
				} else {
					pieceIcon = initImageIcon(blackPawn);
					break;
				}
			case QUEEN:
				if (color == ChessColor.WHITE) {
					pieceIcon = initImageIcon(whiteQueen);
					break;
				} else {
					pieceIcon = initImageIcon(blackQueen);
					break;
				}
			case ROOK:
				if (color == ChessColor.WHITE) {
					pieceIcon = initImageIcon(whiteRook);
					break;
				} else {
					pieceIcon = initImageIcon(blackRook);
					break;
				}
			default:
				return null;
			}

		}
		return pieceIcon;
	}

	private ImageIcon initImageIcon(ImageIcon ic) {
		ImageIcon pieceIcon;
		Image im = ic.getImage();
		Image newIm = im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon wk = new ImageIcon(newIm);
		pieceIcon = wk;
		return pieceIcon;
	}

	private class ButtonHandler implements ActionListener {

		private Position firstClick = null;
		private Position secondClick = null;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			Position position = getPositionOfSource(source);
			if (firstClick == null && !board.isEmpty(position)) {
				firstClick = position;
			} else if (firstClick != null && secondClick == null) {
				secondClick = position;
				processInput(board, firstClick, secondClick);
			}
		}

		private Position getPositionOfSource(Object source) {
			Position position = null;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (source == tiles[i][j]) {
						position = tiles[i][j].getActualPosition();
					}
				}
			}
			return position;
		}

		private void processInput(Board board, Position firstClick, Position secondClick) {
			Player whitePlayer = Player.createWhitePlayer();
			Player blackPlayer = Player.createBlackPlayer();
			if (board.getCount() % 2 == 0) {
				try {
					whitePlayer.movePiece(board, firstClick, secondClick);
					setIconsOnBoardWhitePerspective(board);
					resetClicks();
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
					resetClicks();
				}
			} else {
				try {
					blackPlayer.movePiece(board, firstClick, secondClick);
					setIconsOnBoardWhitePerspective(board);
					resetClicks();
				} catch (Exception e) {
					System.out.println(e.getMessage());
					resetClicks();
				}
			}
		}

		private void resetClicks() {
			this.firstClick = null;
			this.secondClick = null;
		}
	}
	
	private class ChessButton extends JButton {

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
}
