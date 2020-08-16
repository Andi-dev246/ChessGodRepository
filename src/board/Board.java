package board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Board implements Serializable, Iterable<Tile> {

	private static final long serialVersionUID = 4054077618335187636L;
	private Tile[][] board;
	private List<Board> gameHistory = new ArrayList<Board>();

	private Board() {
		board = new Tile[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.board[i][j] = Tile.createEmptyTile(Position.createPositionFromInt(new int[] { i, j }));
			}
		}

		// Setup all Pawns
		for (int i = 0; i < 8; i++) {
			Position positionWhitePawn = Position.createPositionFromInt(new int[] { 1, i });
			Position positionBlackPawn = Position.createPositionFromInt(new int[] { 6, i });

			this.setPiece(Pawn.createWhitePawn(), positionWhitePawn);
			this.setPiece(Pawn.createBlackPawn(), positionBlackPawn);
		}

		// Setup all Rooks
		this.setPiece(Rook.createWhiteRook(), Position.createPositionFromString("a1"));
		this.setPiece(Rook.createWhiteRook(), Position.createPositionFromString("h1"));
		this.setPiece(Rook.createBlackRook(), Position.createPositionFromString("a8"));
		this.setPiece(Rook.createBlackRook(), Position.createPositionFromString("h8"));

		// Setup all Knights
		this.setPiece(Knight.createWhiteKnight(), Position.createPositionFromString("b1"));
		this.setPiece(Knight.createWhiteKnight(), Position.createPositionFromString("g1"));
		this.setPiece(Knight.createBlackKnight(), Position.createPositionFromString("b8"));
		this.setPiece(Knight.createBlackKnight(), Position.createPositionFromString("g8"));

		// Setup all Bishops
		this.setPiece(Bishop.createWhiteBishop(), Position.createPositionFromString("c1"));
		this.setPiece(Bishop.createWhiteBishop(), Position.createPositionFromString("f1"));
		this.setPiece(Bishop.createBlackBishop(), Position.createPositionFromString("c8"));
		this.setPiece(Bishop.createBlackBishop(), Position.createPositionFromString("f8"));

		// Setup Queens
		this.setPiece(Queen.createWhiteQueen(), Position.createPositionFromString("d1"));
		this.setPiece(Queen.createBlackQueen(), Position.createPositionFromString("d8"));

		// Setup Kings
		this.setPiece(King.createWhiteKing(), Position.createPositionFromString("e1"));
		this.setPiece(King.createBlackKing(), Position.createPositionFromString("e8"));

	}

	public static Board createEmptyBoard() {
		Board board = new Board();
		board.clearBoard();
		return board;
	}

	public static Board createDefaultBoard() {
		return new Board();
	}

	public void clearBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.board[i][j].setPiece(null);
			}
		}
	}
	
	public void copy(Board board) {
		this.clearBoard();
		for(int i=0; i<8 ; i++) {
			for(int j=0; j<8; j++) {
				Piece piece = board.getPiece(Position.createPositionFromInt(new int[] {i,j}));
				this.setPiece(piece, Position.createPositionFromInt(new int[] {i,j}));
			}
		}
	}


	public int getCount() {
		return gameHistory.size();
	}
	
	public Board getBoardAfterTurn(int i) {
		return gameHistory.get(i);
	}

	public void addToHistory() {
		gameHistory.add(this);
	}

	public void setPiece(Piece piece, Position position) {
		board[position.getPositionAsInteger()[0]][position.getPositionAsInteger()[1]].setPiece(piece);
	}

	public Piece getPiece(Position position) {
		return this.board[position.getPositionAsInteger()[0]][position.getPositionAsInteger()[1]].getPiece();
	}
	
	public Tile getTile(Position position) {
		int firstCoordinate = position.getPositionAsInteger()[0]; 
		int secondCoordinate = position.getPositionAsInteger()[1];
		
		return this.board[firstCoordinate][secondCoordinate];
	}
	
	public boolean isEmpty(Position position) {
		return this.getTile(position).isEmpty();
	}

	public void printWhitePerspective() {
		for (int i = 0; i < 8; i++) {
			System.out.printf("%-1s|    ", 8-i);
			for (int j = 0; j < 8; j++) {
				System.out.printf("%-6s", this.board[7 - i][j].toString());
			}
			System.out.println();
			System.out.println();
		}
		System.out.println("____________________________________________________");
		System.out.println("        A     B     C     D     E     F     G     H   ");
	}

	public void printBlackPerspective() {
		for (int i = 0; i < 8; i++) {
			System.out.printf("%-1s|    ", i+1);
			for (int j = 0; j < 8; j++) {
				System.out.printf("%-6s", this.board[i][7-j].toString());
			}
			System.out.println();
			System.out.println();
		}
		System.out.println("____________________________________________________");
		System.out.println("        H     G     F     E     D     C     B     A   ");
	}


	@Override
	public Iterator<Tile> iterator() {

		ArrayList<Tile> myList = new ArrayList<Tile>();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].isEmpty() != true)
					myList.add(board[i][j]);
			}
		}
		return myList.listIterator();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(board);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (!Arrays.deepEquals(board, other.board))
			return false;
		return true;
	}
}
