import board.Board;
import board.Position;
import pieces.King;
import pieces.Rook;

public class MainGame {

	public static void main(String[] args) {
		Board board = Board.createEmptyBoard();
		
		board.setPiece(King.createBlackKing(),Position.createPositionFromString("a1"));
		board.setPiece(Rook.createWhiteRook(),Position.createPositionFromString("c1"));
		board.setPiece(Rook.createWhiteRook(),Position.createPositionFromString("c2"));
		
		board.printWhitePerspective();
		Board board2 = board.copy();
		System.out.println();
		board2.printWhitePerspective();
	}

}
