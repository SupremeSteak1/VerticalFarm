package engine.frontend;

import java.awt.Graphics2D;

public class RenderableText implements Renderable {

	private String text;
	private int x;
	private int y;
	
	public RenderableText(String s, int x, int y) {
		this.text = s;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void render(Graphics2D g2d) {
		g2d.drawString(text, x, y);
	}

	@Override
	public int getLevel() {
		return 1;
	}

}
