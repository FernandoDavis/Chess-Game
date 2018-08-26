package Pieces;

import Game.Player;
import Game.Type;

public class Bishop extends Piece {

	Type type;
	
	public Bishop(int x, int y) {
		super(x, y);
		this.type = Type.BISHOP;
	}

	@Override
	public boolean isValidPath(int x2, int y2) {
		return false;
	}

	@Override
	public String getType() {
		return this.type.toString();
	}

}
