package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.ChessMouseListener;
import Pieces.Bishop;
import Pieces.GraphicsManager;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;

public class Board extends JPanel{

	private static final int GRID_X = 25;
	private static final int GRID_Y = 25;
	private static final int INNER_CELL_SIZE = 70;
	private static final int TOTAL_COLUMNS = 8;
	private static final int TOTAL_ROWS = 8; // Last row has only one cell
	public int x = -1;
	public int y = -1;
	public int mouseDownGridX = 0;
	public int mouseDownGridY = 0;
	
	
	/////////////////////////////TEST////////////////////////////
	public Grid[][] board;
	ArrayList<Piece> removedPieces;
	GraphicsManager gm;
	
	public Board() {

		board = new Grid[8][8];
		Color color = null;
		gm = new GraphicsManager();
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(i%2 == 1 && j%2 == 1 || i%2 == 0 && j%2 == 0)
					color = Color.WHITE;
				else
					color = Color.LIGHT_GRAY;
				board[i][j] = new Grid(color, gm);
			}
		}

		for (int i = 0; i < 8; i++) {
			board[i][1].piece = new Pawn(i, 1);
			board[i][6].piece = new Pawn(i, 6);
		}

		//White
		board[1][0].piece = new Knight(1, 0);
		board[6][0].piece = new Knight(6, 0);
		//Black
		board[1][7].piece = new Knight(1, 7);
		board[6][7].piece = new Knight(6, 7);
		
		//White
		board[2][0].piece = new Bishop(2, 0);
		board[5][0].piece = new Bishop(5, 0);
		//Black
		board[2][7].piece = new Bishop(2, 7);
		board[5][7].piece = new Bishop(5, 7);
		
		//White
		board[0][0].piece = new Rook(0, 0);
		board[7][0].piece = new Rook(7, 0);
		//Black
		board[0][7].piece = new Rook(0, 7);
		board[7][7].piece = new Rook(7, 7);
		
		//White
		board[4][0].piece = new King(0, 4);
		board[3][0].piece = new Queen(0, 3);
		//Black
		board[4][7].piece = new King(7, 4);
		board[3][7].piece = new Queen(7, 3);
		
		removedPieces = new ArrayList<Piece>();
		addMouseListener(new ChessMouseListener());
	}

	public void movePiece(int xPiece, int yPiece, int xBoard, int yBoard) {
		// Check if grid[xPiece, yPiece].isValidMove();
		// Check if Player.isChecked()
		// Check if grid[xBoard, yBoard].piece != null and use removePiece(xBoard,
		// yBoard)
		
		if(board[xPiece][yPiece].piece.isValidPath(xBoard, yBoard)) {
			board[xBoard][yBoard].piece = board[xPiece][yPiece].piece;
			board[xPiece][yPiece].piece = null;
		}
	}

	public boolean checkPromote(Piece piece) {
		// getPiece type if piece = pawn, check if move is
		// to backrank then change piece to whatever type player chooses
		return true;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Compute interior coordinates
		Insets myInsets = getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		int x2 = getWidth() - myInsets.right - 1;
		int y2 = getHeight() - myInsets.bottom - 1;
		int width = x2 - x1;
		int height = y2 - y1;

		// Paint the background
		g.setColor(Color.CYAN);
		g.fillRect(x1, y1, width + 1, height + 1);

		// Draw the grid
		g.setColor(Color.BLACK);
		for (int y = 0; y <= TOTAL_ROWS; y++) {
			g.drawLine(x1 + GRID_X, y1 + GRID_Y + (y * (INNER_CELL_SIZE + 1)),
					x1 + GRID_X + ((INNER_CELL_SIZE + 1) * TOTAL_COLUMNS), y1 + GRID_Y + (y * (INNER_CELL_SIZE + 1)));
		}
		for (int x = 0; x <= TOTAL_COLUMNS; x++) {
			g.drawLine(x1 + GRID_X + (x * (INNER_CELL_SIZE + 1)), y1 + GRID_Y,
					x1 + GRID_X + (x * (INNER_CELL_SIZE + 1)), y1 + GRID_Y + ((INNER_CELL_SIZE + 1) * (TOTAL_ROWS)));
		}

		// Paint cell colors
		for (int x = 0; x < TOTAL_COLUMNS; x++) {
			for (int y = 0; y < TOTAL_ROWS; y++) {
				
				Color c = board[x][y].color;
				g.setColor(c);
				g.fillRect(x1 + GRID_X + (x * (INNER_CELL_SIZE + 1)) + 1, y1 + GRID_Y + (y * (INNER_CELL_SIZE + 1)) + 1,
						INNER_CELL_SIZE, INNER_CELL_SIZE);
				if(board[x][y].piece != null) {
					board[x][y].displayPiece(x + GRID_X + (x * (INNER_CELL_SIZE)), y + GRID_Y + (y * (INNER_CELL_SIZE)), g);
				}
			}
		}
	}

	public int getGridX(int x, int y) {
		Insets myInsets = getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		x = x - x1 - GRID_X;
		y = y - y1 - GRID_Y;
		if (x < 0) { // To the left of the grid
			return -1;
		}
		if (y < 0) { // Above the grid
			return -1;
		}
		if ((x % (INNER_CELL_SIZE + 1) == 0) || (y % (INNER_CELL_SIZE + 1) == 0)) { // Coordinate is at an edge; not
																					// inside a cell
			return -1;
		}
		x = x / (INNER_CELL_SIZE + 1);
		y = y / (INNER_CELL_SIZE + 1);
		if (x < 0 || x > TOTAL_COLUMNS-1|| y < 0 || y > TOTAL_ROWS-1) { // Outside the rest of the grid
			return -1;
		}
		return x;
	}

	public int getGridY(int x, int y) {
		Insets myInsets = getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		x = x - x1 - GRID_X;
		y = y - y1 - GRID_Y;
		if (x < 0) { // To the left of the grid
			return -1;
		}
		if (y < 0) { // Above the grid
			return -1;
		}
		if ((x % (INNER_CELL_SIZE + 1) == 0) || (y % (INNER_CELL_SIZE + 1) == 0)) { // Coordinate is at an edge; not
																					// inside a cell
			return -1;
		}
		x = x / (INNER_CELL_SIZE + 1);
		y = y / (INNER_CELL_SIZE + 1);
		if (x < 0 || x > TOTAL_COLUMNS-1 || y < 0 || y > TOTAL_ROWS-1) { // Outside the rest of the grid
			return -1;
		}
		return y;
	}

}
