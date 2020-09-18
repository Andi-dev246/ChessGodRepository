package model.player;

import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidMoveException;
import model.board.Board;
import model.board.Position;
import model.pieces.Piece;
import model.pieces.PieceType;

public class PlayerImplementation implements Player {
	 
	private ChessColor color;
	private final Board board;

	private PlayerImplementation(Board board, ChessColor color) {
		this.color = color;
		this.board = board;
	}
	
	public static Player createWhitePlayer(Board board) {
		return new PlayerImplementation(board, ChessColor.WHITE);
	}
	
	public static Player createBlackPlayer(Board board) {
		return new PlayerImplementation(board, ChessColor.BLACK);
	}

	@Override
	public ChessColor getColor() {
		return color;
	}
	
	@Override
	public void movePiece(Position start, Position end) throws InvalidMoveException {
		checkPreconditions(start);
		Piece piece = board.getPiece(start);
		if(isValidPlayerMove(start, end)) {
			board.addToHistory();
			piece.move(end);
		} else {
			throw new InvalidMoveException("This Move is Invalid.");
		}
	}

	private boolean isValidPlayerMove(Position start, Position end) {
		Piece piece = board.getPiece(start);
		//TODO Check needs to be implemented as well and the condition needs to be checked.
		return piece.isValidMove(start, end);
	}


	@Override
	public boolean isInCheck() {
		boolean isInCheck = false;
		Position kingPosition = getKingPosition();
		for(Piece piece: board) {
			Position piecePosition = piece.getPosition();
			if(piece.isValidMove(piecePosition, kingPosition)) {
				isInCheck = true;
				break;
			}
		}
		return isInCheck;
	}

	@Override
	public boolean isCheckmate() {
		
		boolean firstCondition = this.isInCheck();
		boolean secondCondition = everyMoveResultsInCheck();
		
		return firstCondition && secondCondition;
	}
	
	@Override
	public boolean isStalemate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void checkPreconditions(Position start) throws InvalidMoveException {
		if(board.isEmpty(start)) {
			throw new InvalidMoveException("The field is empty.");
		}
		if(board.getPiece(start).getColor() != color) {
			throw new InvalidMoveException("The Piece has got the wrong color.");
		}
	}

	private boolean everyMoveResultsInCheck() {
		boolean everyMoveResultsInCheck = true;
		for(Piece piece: board) {
			if((piece.getColor() == color) && isThereAMoveThatResultsNotInCheckForThisPiece(piece)) {
				everyMoveResultsInCheck = false;
				break;
			}
		}
		return everyMoveResultsInCheck;
	}

	private boolean isThereAMoveThatResultsNotInCheckForThisPiece(Piece piece) {
		boolean isThereAMoveThatResultsNotInCheckForThisPiece = false;
		List<Position> allReachablePositions = getAllReachablePositions(piece);
		for(Position position: allReachablePositions) {
			if(isPlayerInCheckWithPieceOnPosition(piece, position)) {
				isThereAMoveThatResultsNotInCheckForThisPiece = true;
				break;
			}
		}
		return isThereAMoveThatResultsNotInCheckForThisPiece;
	}

	
	private boolean isPlayerInCheckWithPieceOnPosition(Piece piece, Position position) {
		//Get the initial Position and Data
		Position start = piece.getPosition();
		boolean hasPieceBeenMoved = piece.getHasPieceBeenMoved();
		
		// Get Piece on position in case that the piece beats a enemy piece there. Only Enemypieces are relevant because
		// otherwise the isValidPath method would return false
		Piece enemyPiece = board.getPiece(position);
		
		// Move the piece to the reachable Position
		try {
			piece.move(position);
		} catch (InvalidMoveException e) {
			e.printStackTrace();
		}
		//Check if the King is still in Check
		boolean isPlayerInCheckWithPieceOnPosition = !this.isInCheck();
		
		//Move the piece back on the initial Position
		try {
			piece.move(start);
			piece.setHasPieceBeenMoved(hasPieceBeenMoved);
			board.setPiece(enemyPiece,position);
		} catch (InvalidMoveException e) {
			e.printStackTrace();
		}
		
		return isPlayerInCheckWithPieceOnPosition;
	}

	private List<Position> getAllReachablePositions(Piece piece) {
		List<Position> allReachablePositions = new ArrayList<>();
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				Position position = Position.createPositionFromInt(new int[] {i,j});
				if(piece.isValidMove(piece.getPosition(), position)) {
					allReachablePositions.add(position);
				}
			}
		}
		return allReachablePositions;
	}

	private Position getKingPosition() {
		Position kingPosition = null;
		for(Piece piece: board) {
			if(piece.getType() == PieceType.KING && piece.getColor() == color) {
				kingPosition = piece.getPosition();
				break;
			} 
		}
		return kingPosition;
	}
}
