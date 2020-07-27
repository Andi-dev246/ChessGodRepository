package board;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

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
	private int count;

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
		this.setPiece(Queen.createWhiteQueen(), Position.createPositionFromString("e1"));
		this.setPiece(Queen.createBlackQueen(), Position.createPositionFromString("e8"));

		// Setup Kings
		this.setPiece(King.createWhiteKing(), Position.createPositionFromString("d1"));
		this.setPiece(King.createBlackKing(), Position.createPositionFromString("d8"));

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
	
	public Board copy() {
		Board copyBoard = Board.createEmptyBoard();
		for(int i=0, j=0; i<8 && j<8; i++, j++) {
			Position position = Position.createPositionFromInt(new int[] {i,j});
			copyBoard.setPiece(this.getPiece(position), position);
		}
		return copyBoard;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
			for (int j = 0; j < 8; j++) {
				System.out.printf("%-6s", this.board[7 - i][7 - j].toString());
			}
			System.out.println();
			System.out.println();
		}
	}

	public void printBlackPerspective() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%-6s", this.board[i][j].toString());
			}
			System.out.println();
			System.out.println();
		}
	}

	public void saveBoard() {
		try (FileOutputStream fs = new FileOutputStream("ChessGod.data")) {

			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(this);
			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Board loadBoard() {
		try (FileInputStream fs = new FileInputStream("ChessGod.data")) {

			ObjectInputStream os = new ObjectInputStream(fs);
			Board board = (Board) os.readObject();
			os.close();

			return board;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Board.createDefaultBoard();
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
}
