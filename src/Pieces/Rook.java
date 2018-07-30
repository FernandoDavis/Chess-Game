package Pieces;

import Game.Player;
import Game.Type;

public class Rook extends Piece {

	Type type;
	
	public Rook(int x, int y) {
		super(x, y);
		this.type = Type.ROOK;
	}

	@Override
	public boolean isValidPath(int x2, int y2) {
		return false;
	}

	@Override
	public Type getType() {
		return this.type;
	}

}
