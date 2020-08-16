package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import board.Board;
import board.Position;
import board.Tile;
import pieces.Piece;
import pieces.PieceType;
import player.ChessColor;

public class ChessTable extends JFrame {
		
	private Container content;
	
	// Components
	private JButton[][] tiles = new JButton[8][8];
	
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
		
		content = getContentPane();
		content.setLayout(new GridLayout(8,8));
		
		//Create EventHandlers
		
		for(int i=0; i<8; i++ ) {
			for(int j=0; j<8; j++) {
				tiles[i][j] = new JButton();
				Position position = Position.createPositionFromInt(new int[] {i,j});
				if(Tile.getColor(position) == ChessColor.BLACK) {
					tiles[i][j].setBackground(colorDarkGrey);
				}
				content.add(tiles[i][j]);
				
				ImageIcon Ic = getIconImagesFromBoard(position, board);
				tiles[i][j].setIcon(Ic);
				
			}
		}
		setIconImage(blackRook.getImage());
		setSize(800,800);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	private ImageIcon getIconImagesFromBoard(Position position, Board board) {
			Tile tile = board.getTile(position);
			ImageIcon pieceIcon = null;
			if(tile.isEmpty() == false) {
				Piece piece = tile.getPiece();
				ChessColor color = piece.getColor();
				PieceType pieceType = piece.getPieceType();
				switch (pieceType) {
				case BISHOP:
					if(color == ChessColor.WHITE) {
						Image im = whiteBishop.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon wk =  new ImageIcon(newIm);
						pieceIcon = wk;
						break;
					} else {
						Image im = blackBishop.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon wk =  new ImageIcon(newIm);
						pieceIcon = wk;
						break;
					}
				case KING:
					if(color == ChessColor.WHITE) {
						Image im = whiteKing.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon wk =  new ImageIcon(newIm);
						pieceIcon = wk;
						break;
					} else {
						Image im = blackKing.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon wk =  new ImageIcon(newIm);
						pieceIcon = wk;
						break;
					}
				case KNIGHT:
					if(color == ChessColor.WHITE) {
						Image im = whiteKnight.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon wk =  new ImageIcon(newIm);
						pieceIcon = wk;
						break;
					} else {
						Image im = blackKnight.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon wk =  new ImageIcon(newIm);
						pieceIcon = wk;
						break;
					}
				case PAWN:
					if(color == ChessColor.WHITE) {
						Image im = whitePawn.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon wk =  new ImageIcon(newIm);
						pieceIcon = wk;
						break;
					} else {
						Image im = blackPawn.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon wk =  new ImageIcon(newIm);
						pieceIcon = wk;
						break;
					}
				case QUEEN:
					if(color == ChessColor.WHITE) {
						Image im = whiteQueen.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon wk =  new ImageIcon(newIm);
						pieceIcon = wk;
						break;
					} else {
						Image im = blackQueen.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon wk =  new ImageIcon(newIm);
						pieceIcon = wk;
						break;
					}
				case ROOK:
					if(color == ChessColor.WHITE) {
						Image im = whiteRook.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon wr =  new ImageIcon(newIm);
						pieceIcon = wr;
						break;
					} else {
						Image im = blackRook.getImage();
						Image newIm =im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						ImageIcon br =  new ImageIcon(newIm);
						pieceIcon = br;
						break;
					}
				default:
					return null;
				}
				
			}
			return pieceIcon;
		}
	
	}
