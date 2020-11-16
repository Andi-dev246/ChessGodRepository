package controller;

import exceptions.InvalidMoveException;
import gui.GraphicalUserInterface;
import model.Board;
import model.Player;
import model.board.Position;
import model.pieces.PieceSetter;
import model.pieces.PieceType;

public class Processor {
	
	private final Board board;
	private Player firstPlayer;
	private Player secondPlayer;
	private GraphicalUserInterface gui;
	PieceSetter pieceSetter;
	
	// Positions for processing the Player input
	private Position firstInput;
	private Position secondInput;
	
	
	public Processor(Board board) {
		this.board = board;
		pieceSetter = new PieceSetter(board);
		resetInput();
	}

	public void processInput(Position position) {
		setInput(position);
		if(firstInput != null && secondInput != null) {
			if((board.getNumberOfTurns() % 2) == 0) {
					try {
						firstPlayer.movePiece(firstInput, secondInput);
						if(secondPlayer.isCheckmate()) {
							gui.displayText("The Black Player is checkmate. White has won!");
						} else if(secondPlayer.isStalemate()) {
							gui.displayText("Stalemate! The Game is over.");
						}
					} catch (InvalidMoveException e) {
						if(firstPlayer.isCheckmate()) {
							gui.displayText("White is checkmate the Game is over.");
						} else {
							gui.displayText(e.getMessage());
						}
					} catch(Exception e) {
						gui.displayText("An unknown Error has occured.");
					}
			} else {
					try {
						secondPlayer.movePiece(firstInput, secondInput);
						if(firstPlayer.isCheckmate()) {
							gui.displayText("The White Player is checkmate. Black has won!");
						} else if (firstPlayer.isStalemate()){
							gui.displayText("Stalemate! The Game is over.");
						}
					} catch (InvalidMoveException e) {
						if(secondPlayer.isCheckmate()) {
							gui.displayText("Black is checkmate the Game is over.");
						} else {
							gui.displayText(e.getMessage());
						}
					} catch(Exception e) {
						gui.displayText("An unknown Error has occured.");
					}
			}
			resetInput();
			gui.update();
		}
	}

	private void setInput(Position position) {
		if(firstInput == null && !board.isEmpty(position)) {
			firstInput = position;
		} else if (firstInput != null && secondInput == null){
			secondInput = position;
		} else {
			resetInput();
		}
	}

	public void resetInput() {
		firstInput = null;
		secondInput = null;
	}

	public void addGUI(GraphicalUserInterface gui) {
		this.gui = gui;
		gui.addProcessor(this);
	}

	public void addFirstPlayer(Player player) {
		firstPlayer = player;
		
	}

	public void addSecondPlayer(Player player) {
		secondPlayer = player;
	}
	
	public void setupDefaultBoard() {
		clearBoard();
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
		
		gui.update();
	}
	
	private void clearBoard() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				pieceSetter.setNull(Position.createPositionFromInt(new int[] {i,j}));
			}
		}
	}
}
