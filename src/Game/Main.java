package Game;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Chess");
		Board board = new Board();
		myFrame.add(board);
		myFrame.setSize(640, 660);
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setVisible(true);
	}

}
