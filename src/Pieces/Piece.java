package Pieces;

import Game.Player;
import Game.Type;

public abstract class Piece {

	public int x, y;
	
	/**
	 * Constructor for Piece class.
	 * @param x	the x coordinate for the piece.
	 * @param y the y coordinate for the piece.
	 */
	public Piece(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Checks if the path for the piece is valid.
	 * @param x2 the x coordinate for destined location.
	 * @param y2 the y coordinate for destined location.
	 * @return 	returns a boolean that returns true or false.
	 */
	public abstract boolean isValidPath(int x2, int y2);
	
	/**
	 * Gets the type of the piece based on each individual class.
	 * @return returns the type of the piece.
	 */
	public abstract String getType();

}
