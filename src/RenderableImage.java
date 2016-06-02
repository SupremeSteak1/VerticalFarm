import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class RenderableImage implements Renderable {
	
	private String filePath;
	private BufferedImage image;
	private int x;
	private int y;
	
	/**
	 * A RenderableImage is an image that can be rendered using our custom render engine.
	 * @param filePath the path to the image
	 * @param x the starting x coordinate
	 * @param y the starting y coordinate
	 */
	public RenderableImage(String filePath, int x, int y){
		this.filePath = filePath;
		this.x = x;
		this.y = y;
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getFilePath(){
		return filePath;
	}
	
	public void render(Graphics2D g2d) {
		g2d.drawImage(image, x, y, null);
	}
	
}
