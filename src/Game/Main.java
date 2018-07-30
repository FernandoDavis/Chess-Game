package Game;

import javax.swing.JFrame;

import GUI.ChessMouseAdapter;

public class Main {

	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Chess");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(900, 900);

		Board myPanel = new Board();
		myFrame.add(myPanel);

		ChessMouseAdapter myMouseAdapter = new ChessMouseAdapter();
		myFrame.addMouseListener(myMouseAdapter);

		myFrame.setVisible(true);
		//////////////////////////////////
	}

}
