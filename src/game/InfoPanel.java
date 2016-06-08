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
		ArrayList<Renderable> toRender = new ArrayList<Renderable>();
		toRender.add(image);
		toRender.add(tileRender);
		toRender.add(plantRender);
		toRender.add(name);
		toRender.addAll(renderResources());
		toRender.addAll(renderLongText(25, tile.getPlant().getDescription(), 800, 353));
		return toRender;
	}
	
	private ArrayList<Renderable> renderResources() {
		ArrayList<Renderable> toRender = new ArrayList<>();
		ArrayList<Resource> res = tile.getPlant().getNeededResources();
		for(int i = 0; i < res.size(); i++){
			Resource r = res.get(i);
			toRender.add(new RenderableText(r.getType().name() + ": " + r.getAmount(), 650, 125 + i*15));
		}
		return toRender;
	}
	
	private ArrayList<Renderable> renderLongText(int width, String text, int x, int y){
		int lines = (int) Math.ceil((double) text.length() / (double) width);
		ArrayList<Renderable> toRender = new ArrayList<>();
		for(int i = 0; i < lines; i++){
			try{
			toRender.add(new RenderableText(text.substring(i*width,(i+1)*width), x, y + i*10));
			}catch(Exception e){
				toRender.add(new RenderableText(text.substring(i*width,text.length()), x, y + i*10));
			}
		}
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
	
}
