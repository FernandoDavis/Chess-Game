package Pieces;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;

public class GraphicsManager {

	private BufferedImage pawnImage;
	
	public GraphicsManager() {
		try {
			this.pawnImage = ImageIO.read(getClass().getResource("/Images/pawnImage.JPG"));
		} catch (Exception e) {
			System.out.println("Error loading image. ");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void drawPawn(Pawn pawn, Graphics2D g2d, int x, int y) {
		g2d.drawImage(pawnImage, x, y, null);
	}
}
