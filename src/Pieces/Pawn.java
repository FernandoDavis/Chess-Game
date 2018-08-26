package Pieces;

import java.awt.image.BufferedImage;

import Game.PieceColor;
import Game.Player;
import Game.Type;

public class Pawn extends Piece {

	Type type;
	
	public Pawn(int x, int y) {
		super(x, y);
		this.type = Type.PAWN;
	}

	@Override
	public boolean isValidPath(int x2, int y2) {
		return true;
	}

	@Override
	public String getType() {
		return this.type.toString();
	}
	
	public boolean enPassantMove() {
		return false; //If piece moved twice and its the first move of the piece, set it to true
	}
	
	public int checkFirstMove() {
		return 0; //if it moves once, return 1, if it moves twice return 2
	}

	
	
}
