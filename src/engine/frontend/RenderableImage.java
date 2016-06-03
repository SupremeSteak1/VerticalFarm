package engine.frontend;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Thomas Hayden
 * @version 6/02/16
 */
public class RenderableImage implements Renderable {
	
	private BufferedImage image;
	private int x;
	private int y;
	private int level;
	
	/**
	 * A RenderableImage is an image that can be rendered using our custom render engine.
	 * @param filePath the path to the image
	 * @param x the starting x coordinate
	 * @param y the starting y coordinate
	 */
	public RenderableImage(String filePath, int x, int y, int level){
		this.x = x;
		this.y = y;
		this.level = level;
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Render the given image on the screen using the given graphics object
	 */
	public void render(Graphics2D g2d) {
		g2d.drawImage(image, x, y, null);
	}
	
	public int getLevel() {
		return level;
	}
	
}
