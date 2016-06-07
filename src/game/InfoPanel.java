package game;

import java.awt.Point;
import java.util.ArrayList;

import engine.backend.GameObject;
import engine.frontend.Renderable;
import engine.frontend.RenderableImage;
import engine.frontend.RenderableText;

public class InfoPanel implements GameObject {
	
	private Tile tile;
	
	public InfoPanel(Tile t) {
		tile = t;
	}
	
	@Override
	public ArrayList<Renderable> render() {
		RenderableImage image = new RenderableImage("res/VerticalFarmInfoPanel.png", 650, 10, 1);
		RenderableImage tileRender = new RenderableImage(tile.getImagePath(), 655, 356, 1);
		RenderableImage plantRender = new RenderableImage(tile.getPlant().getImagePath(), 655, 356, 1);
		RenderableText name = new RenderableText(tile.getPlant().getAttributes().get(1), 660, 48);
		RenderableText description = new RenderableText(tile.getPlant().getDescription(), 800, 353);
		ArrayList<Renderable> toRender = new ArrayList<Renderable>();
		toRender.add(image);
		toRender.add(tileRender);
		toRender.add(plantRender);
		toRender.add(name);
		toRender.add(description);
		return toRender;
	}
	
	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	@Override
	public void update() {
		
	}
	
	public void onClick(Point p) {
		
	}
	
}
