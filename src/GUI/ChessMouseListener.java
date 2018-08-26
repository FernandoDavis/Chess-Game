package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;

import Game.Board;
import Pieces.Piece;

public class ChessMouseListener implements MouseListener {
	boolean firstClick = false;
	Piece piece;
	int oldX = -1;
	int oldY = -1;
	public void mouseClicked(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			Board myPanel = (Board) myFrame.getContentPane().getComponent(0); 
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Out of bounds.
			} 
			else {
				if(!firstClick) {
					firstClick = true;
					//Have some sort of mechanism to see if clicked tile is actually active
					System.out.println("First: " + oldX + " " + oldY + " -- " + gridX + " " + gridY);
					piece = myPanel.board[gridX][gridY].piece;
					oldX = gridX;
					oldY = gridY;
					//Show valid moves
					//piece.displayMoves();
				}
				else {
					System.out.println("Second: " + oldX + " " + oldY + " -- " + gridX + " " + gridY);

					firstClick = false;
					//if valid
					if(piece != null && piece.isValidPath(gridX, gridY)) {
						myPanel.board[gridX][gridY].piece = piece;
						myPanel.board[oldX][oldY].piece = null;
						oldX = -1;
						oldY = -1;
						piece = null;
					}
					else {
						oldX = -1;
						oldY = -1;
						piece = null;
					}
				}

			}
			myPanel.repaint();
			break;

		default:
			break;
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}