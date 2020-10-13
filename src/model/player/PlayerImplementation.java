package model.player;

import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidMoveException;
import model.Board;
import model.Piece;
import model.Player;
import model.board.Position;
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
		checkExceptions(start, end);
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
		return piece.isValidMove(start, end) && !isPlayerInCheckWithPieceOnPosition(piece, end);
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
		return this.isInCheck() && everyMoveResultsInCheck();
	}
	
	@Override
	public boolean isStalemate() {
		return !isInCheck() && (everyMoveResultsInCheck() || isNoMovePossible());
	}
	
	private boolean isNoMovePossible() {
		boolean isNoMovePossible = true;
		for(Piece piece: board) {
			if(piece.getColor() == color && pieceCanMoveSomewhere(piece)) {
				isNoMovePossible = false;
			}
		}
		return isNoMovePossible;
	}

	private boolean pieceCanMoveSomewhere(Piece piece) {
		List<Position> path = getAllReachablePositions(piece);
		return (path.size() > 0);
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

	private void checkExceptions(Position start, Position end) throws InvalidMoveException {
		Piece piece = board.getPiece(start);
		if(board.isEmpty(start)) {
			throw new InvalidMoveException("The field is empty.");
		}
		if(board.getPiece(start).getColor() != color) {
			throw new InvalidMoveException("The Piece has got the wrong color.");
		}
		if(isInCheck() && isPlayerInCheckWithPieceOnPosition(piece, end)) {
			throw new InvalidMoveException("The Piece cannot move to the location. The King is in Check!");
		}
		if(isPlayerInCheckWithPieceOnPosition(piece, end)) {
			throw new InvalidMoveException("The Piece cannot move to the location, because the King would be in Check!");
		}
	}

	private boolean isThereAMoveThatResultsNotInCheckForThisPiece(Piece piece) {
		boolean isThereAMoveThatResultsNotInCheckForThisPiece = false;
		List<Position> allReachablePositions = getAllReachablePositions(piece);
		for(Position position: allReachablePositions) {
			if(!isPlayerInCheckWithPieceOnPosition(piece, position)) {
				isThereAMoveThatResultsNotInCheckForThisPiece = true;
				break;
			}
		}
		return isThereAMoveThatResultsNotInCheckForThisPiece;
	}

	
	private boolean isPlayerInCheckWithPieceOnPosition(Piece piece, Position position) {
		//Clone the Board and Player
		Board clonedBoard = board.clone();
		Player clonedPlayer = new PlayerImplementation(clonedBoard, color);
		Piece clonedPiece = clonedBoard.getPiece(piece.getPosition());
		
		// Move the piece to the reachable Position
		try {
			clonedPiece.move(position);
		} catch (InvalidMoveException e) {
			e.printStackTrace();
		}
		//Check if the King is in Check
		return clonedPlayer.isInCheck();
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
