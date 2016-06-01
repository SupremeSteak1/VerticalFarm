import java.awt.Graphics2D;


public class RenderableOval implements Renderable {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public RenderableOval(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void render(Graphics2D g2d) {
		g2d.drawOval(x, y, width, height);
	}
}
