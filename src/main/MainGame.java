package main;

import controller.Controller;
import controller.ControllerImplementation;
import gui.ChessGodGUI;
import gui.GraphicalUserInterface;
import model.board.Board;
import model.board.BoardImplementation;
import model.board.Position;
import model.pieces.PieceSetter;
import model.pieces.PieceType;
import model.player.Player;
import model.player.PlayerImplementation;

public class MainGame {

	public static void main(String[] args) {
		
		Board board = setupBoard();
		
		Player whitePlayer = PlayerImplementation.createWhitePlayer(board);
		Player blackPlayer = PlayerImplementation.createBlackPlayer(board);
		
		Controller controller = new ControllerImplementation(board, whitePlayer, blackPlayer);
		
		GraphicalUserInterface gui = new ChessGodGUI(board, controller);
		
	}


	private static Board setupBoard() {
		
		Board board = new BoardImplementation();
		
		PieceSetter pieceSetter = new PieceSetter(board);
		
		//Setup Pieces
		
		//Set black and white Pawns on Board
		for(int i=0; i<8; i++) {
			pieceSetter.setWhitePiece(PieceType.PAWN, Position.createPositionFromInt(new int[] {1, i}));
			pieceSetter.setBlackPiece(PieceType.PAWN, Position.createPositionFromInt(new int[] {6, i}));
		}
		
		//Set up all white Pieces in the first row
		pieceSetter.setWhitePiece(PieceType.ROOK, Position.createPositionFromString("a1"));
		pieceSetter.setWhitePiece(PieceType.KNIGHT, Position.createPositionFromString("b1"));
		pieceSetter.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("c1"));
		pieceSetter.setWhitePiece(PieceType.QUEEN, Position.createPositionFromString("d1"));
		pieceSetter.setWhitePiece(PieceType.KING, Position.createPositionFromString("e1"));
		pieceSetter.setWhitePiece(PieceType.BISHOP, Position.createPositionFromString("f1"));
		pieceSetter.setWhitePiece(PieceType.KNIGHT, Position.createPositionFromString("g1"));
		pieceSetter.setWhitePiece(PieceType.ROOK, Position.createPositionFromString("h1"));
		
		//Set up all black Pieces in the last row
		pieceSetter.setBlackPiece(PieceType.ROOK, Position.createPositionFromString("a8"));
		pieceSetter.setBlackPiece(PieceType.KNIGHT, Position.createPositionFromString("b8"));
		pieceSetter.setBlackPiece(PieceType.BISHOP, Position.createPositionFromString("c8"));
		pieceSetter.setBlackPiece(PieceType.QUEEN, Position.createPositionFromString("d8"));
		pieceSetter.setBlackPiece(PieceType.KING, Position.createPositionFromString("e8"));
		pieceSetter.setBlackPiece(PieceType.BISHOP, Position.createPositionFromString("f8"));
		pieceSetter.setBlackPiece(PieceType.KNIGHT, Position.createPositionFromString("g8"));
		pieceSetter.setBlackPiece(PieceType.ROOK, Position.createPositionFromString("h8"));
		
		return board;
	}
}
