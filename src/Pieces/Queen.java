package Pieces;

import Game.Player;
import Game.Type;

public class Queen extends Piece {

	Type type;
	
	public Queen(int x, int y) {
		super(x, y);
		this.type = Type.QUEEN;
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
