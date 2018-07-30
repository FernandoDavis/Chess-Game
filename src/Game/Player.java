package Game;

import java.util.List;

public class Player {
	
	String name;
	Board chessBoard;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	List<String> matchesPlayed;
	
	Player(String name, Board board){
		this.name = name;
		this.chessBoard = board;
	}

	/**
	 * @return the noOfWins.
	 */
	public int getNoOfWins() {
		return noOfWins;
	}

	/**
	 * @param noOfWins the noOfWins to set.
	 */
	public void setNoOfWins(int noOfWins) {
		this.noOfWins = noOfWins;
	}

	/**
	 * @return the noOfLosses.
	 */
	public int getNoOfLosses() {
		return noOfLosses;
	}

	/**
	 * @param noOfLosses the noOfLosses to set.
	 */
	public void setNoOfLosses(int noOfLosses) {
		this.noOfLosses = noOfLosses;
	}

	/**
	 * @return the noOfDraws.
	 */
	public int getNoOfDraws() {
		return noOfDraws;
	}

	/**
	 * @param noOfDraws the noOfDraws to set.
	 */
	public void setNoOfDraws(int noOfDraws) {
		this.noOfDraws = noOfDraws;
	}

	/**
	 * @return the matchesPlayed.
	 */
	public List<String> getMatchesPlayed() {
		return matchesPlayed;
	}

	/**
	 * @param matchesPlayed	the matchesPlayed to be add.
	 */
	public void addMatchesPlayed(String matchesPlayed) {
		this.matchesPlayed.add(matchesPlayed);
	}
	
	public boolean offerDraw() {
		return false;
	}
	
//	public boolean isChecked() {
//		if(chessBoard.)
//		return false;
//	}
}
