package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Pieces.GraphicsManager;
import Pieces.Pawn;
import Pieces.Piece;

public class Grid {

	public Color color;
	public Piece piece;
	GraphicsManager gm;
	
	public Grid(Color color, GraphicsManager gm) {
		this.color = color;
		this.piece = null;
		this.gm = gm;
	}

	public void displayPiece(int x, int y, Graphics g) {
		if (piece != null) {
			g.setColor(Color.BLACK);
			if(piece.getType() == Type.PAWN.toString())
				gm.drawPawn((Pawn) piece, (Graphics2D) g, x, y);
			else
				g.drawString(piece.getType().substring(0,1), x+30, y+30);
			
		}
	}
}
