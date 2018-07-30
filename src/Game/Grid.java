package Game;

import java.awt.Color;
import java.awt.Graphics;

import Pieces.Piece;

public class Grid {

	public PieceColor color;
	public Piece piece;

	Grid() {
		color = null;
		piece = null;
	}

	public void displayPiece(int x, int y, Graphics g) {
		if (piece != null) {
			g.setColor(Color.BLACK);
			g.fillOval(x + 20, y + 20, 10, 10);
		}
	}
}
