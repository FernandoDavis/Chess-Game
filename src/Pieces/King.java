package Pieces;

import Game.Player;
import Game.Type;

public class King extends Piece {

	Type type;
	
	public King(int x, int y) {
		super(x, y);
		this.type = Type.KING;
	}

	@Override
	public boolean isValidPath(int x2, int y2) {
		return false;
	}

	@Override
	public String getType() {
		return this.type.toString();
	}
	
	public boolean canBeCaptured() {
		return false;
	}
	
	public boolean movedForCastle() {
		return false;
	}
	
}
