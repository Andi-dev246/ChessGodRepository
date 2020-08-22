package main_game;

import java.util.Scanner;

import board.Board;
import board.Position;
import player.Checkmate;
import player.Player;
import player.Stalemate;

public class MainGame {

	public static void main(String[] args) {
		
		Player whitePlayer = Player.createWhitePlayer();
		Player blackPlayer = Player.createBlackPlayer();
		
		Board board = Board.createDefaultBoard();
		
		
		Scanner input = new Scanner(System.in);
		
		do {
			int count = board.getCount();
		   if(count%2 == 0) {
			   
			   board.printWhitePerspective();
			   System.out.println("=================================================");
			   
			   System.out.println("White Player enter a starting poition for a move.");
			   System.out.println("=================================================");
			   
			   String start = input.nextLine();
			   
			   System.out.println("Now enter a end Position");
			   System.out.println("=================================================");
			   
			   String end = input.nextLine();
			   
			   try {
				whitePlayer.movePiece(board, Position.createPositionFromString(start), Position.createPositionFromString(end));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("The Move was not possible. Please enter a valid move.");
				continue;
			}
			   
		   }
		   else {
			   board.printBlackPerspective();
			   System.out.println("=================================================");
			   
			   System.out.println("Black Player enter a starting poition for a move.");
			   System.out.println("=================================================");
			   
			   String start = input.nextLine();
			   
			   System.out.println("Now enter a end Position");
			   System.out.println("=================================================");
			   
			   String end = input.nextLine();
			   
			   try {
				blackPlayer.movePiece(board, Position.createPositionFromString(start), Position.createPositionFromString(end));
			} catch (Exception e) {
				System.out.println("The Move was not possible. Please enter a valid move.");
				System.out.println(e.getMessage());
				continue;
			}
		   }
		} while((Checkmate.isWhiteKingCheckmate(board) || Checkmate.isBlackKingCheckmate(board) || Stalemate.isWhiteKingStalemate(board) || Stalemate.isBlackKingStalemate(board)) == false);
		board.printWhitePerspective();
		System.out.println("The Game is over.");
		input.close();
	}
}
