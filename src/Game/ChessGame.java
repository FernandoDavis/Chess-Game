package Game;

import java.util.HashMap;
import java.util.Map;

public class ChessGame {

	Map<Player, int[][]> moveHistory;
	Board chessBoard;
	Player player1, player2;
	HashMap<Player, String> pieceColor;

	public boolean isGameOver() {
		return isStaleMate() || isCheckMate();
	}

	public boolean isStaleMate() {
		return false;
	}

	public boolean isCheckMate() {
		return false;
	}

	public void startGame() {
		Board chessBoard = new Board();
		// player1 = new Player("Fernando");
		// player2 = new Player("Player2");
		while (!isGameOver()) {

		}
	}

	public void selectPieceType(Player player, Player player2) {
		int choice = 0;
		// Input type using a button from GUI
		switch (choice) {
		case 0:
			pieceColor.put(player, "white");
			pieceColor.put(player2, "black");
			break;
		case 1:
			pieceColor.put(player, "black");
			pieceColor.put(player2, "white");
			break;
		default:
			break;
		}
	}

	public void movesMade(Map<Player, int[][]> history) {

	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
}
