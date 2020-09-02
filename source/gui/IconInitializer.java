package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import board.Board;
import board.Position;
import pieces.Piece;
import pieces.PieceType;
import player.ChessColor;

public class IconInitializer {
	
	
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
	
	private final Board board;
	
	public IconInitializer(Board board) {
		this.board = board;
	}
	
	
	public ImageIcon getIconImagesFromBoard(Position position) {
		ImageIcon pieceIcon = null;
		if (board.isEmpty(position) == false) {
			Piece piece = board.getPiece(position);
			ChessColor color = piece.getColor();
			PieceType pieceType = piece.getType();
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

}
