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
import exceptions.InvalidMoveException;
import pieces.PieceType;
import player.ChessColor;
import player.Player;

public class ChessTable extends JFrame {

	//TODO muss komplett überarbeitet werden 
	
//	private static final long serialVersionUID = -3488125002056849561L;
//	private Container content;
//	private final Board board;
//	private Color colorDarkGrey = Color.DARK_GRAY;
//	private IconInitializer iconInitializer;
//
//	// Components
//	private ChessButton[][] tiles = new ChessButton[8][8];
//	private ImageIcon blackRook = new ImageIcon(".\\res\\BlackRook.png");
//
//	public ChessTable(Board board) {
//		super("ChessGod");
//		this.board = board;
//		iconInitializer = new IconInitializer(board);
//		
//		content = getContentPane();
//		content.setLayout(new GridLayout(8, 8));
//
//		ButtonHandler bh = new ButtonHandler();
//
//		// Create EventHandlers
//
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				Position position = Position.createPositionFromInt(new int[] { i, j});
//				tiles[i][j] = new ChessButton(position);
//				
//				if (Tile.getColor(position) == ChessColor.BLACK) {
//					tiles[i][j].setBackground(colorDarkGrey);
//				}
//				content.add(tiles[i][j]);
//				tiles[i][j].addActionListener(bh);
//			}
//		}
//		setIconsOnBoardWhitePerspective(board);
//		setIconImage(blackRook.getImage());
//		setSize(800, 800);
//		setResizable(false);
//		setVisible(true);
//		setLocationRelativeTo(null);
//
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//	}
//
//	private void setIconsOnBoardWhitePerspective() {
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				Position position = Position.createPositionFromInt(new int[] {i, j });
//				ImageIcon Ic = iconInitializer.getIconImagesFromBoard(position);
//				tiles[7-i][j].setIcon(Ic);
//				tiles[7-i][j].setActualPosition(position);
//			}
//		}
//	}
//
//	private class ButtonHandler implements ActionListener {
//
//		private Position firstClick = null;
//		private Position secondClick = null;
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			Object source = e.getSource();
//
//			Position position = getPositionOfSource(source);
//			if (firstClick == null && !board.isEmpty(position)) {
//				firstClick = position;
//			} else if (firstClick != null && secondClick == null) {
//				secondClick = position;
//				processInput(board, firstClick, secondClick);
//			}
//		}
//
//		private Position getPositionOfSource(Object source) {
//			Position position = null;
//			for (int i = 0; i < 8; i++) {
//				for (int j = 0; j < 8; j++) {
//					if (source == tiles[i][j]) {
//						position = tiles[i][j].getActualPosition();
//					}
//				}
//			}
//			return position;
//		}
//
//		private void processInput(Position firstClick, Position secondClick) {
//			Player whitePlayer = new Player() {
//				
//				@Override
//				public void movePiece(Position start, Position end) throws InvalidMoveException {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public boolean isStalemate() {
//					// TODO Auto-generated method stub
//					return false;
//				}
//				
//				@Override
//				public boolean isInCheck() {
//					// TODO Auto-generated method stub
//					return false;
//				}
//				
//				@Override
//				public boolean isCheckmate() {
//					// TODO Auto-generated method stub
//					return false;
//				}
//			};
//			
//			
//			Player blackPlayer = new Player() {
//				
//				@Override
//				public void movePiece(Position start, Position end) throws InvalidMoveException {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public boolean isStalemate() {
//					// TODO Auto-generated method stub
//					return false;
//				}
//				
//				@Override
//				public boolean isInCheck() {
//					// TODO Auto-generated method stub
//					return false;
//				}
//				
//				@Override
//				public boolean isCheckmate() {
//					// TODO Auto-generated method stub
//					return false;
//				}
//			};
//			if (board.getCount() % 2 == 0) {
//				try {
//					whitePlayer.movePiece(board, firstClick, secondClick);
//					setIconsOnBoardWhitePerspective(board);
//					resetClicks();
//					
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//					resetClicks();
//				}
//			} else {
//				try {
//					blackPlayer.movePiece(board, firstClick, secondClick);
//					setIconsOnBoardWhitePerspective(board);
//					resetClicks();
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//					resetClicks();
//				}
//			}
//		}
//
//		private void resetClicks() {
//			this.firstClick = null;
//			this.secondClick = null;
//		}
//	}
//	
//	private class ChessButton extends JButton {
//
//		private static final long serialVersionUID = 7406010797024912530L;
//		private Position displayedPosition;
//		private Position actualPosition;
//		
//		ChessButton(Position position) {
//			super();
//		}
//
//		public Position getDisplayedPosition() {
//			return displayedPosition;
//		}
//
//		public Position getActualPosition() {
//			return actualPosition;
//		}
//
//		public void setActualPosition(Position actualPosition) {
//			this.actualPosition = actualPosition;
//		}
//	}
}
