package game;

import java.awt.Rectangle;
import java.util.ArrayList;

import other.Utilities;
import engine.backend.GameObject;
import engine.frontend.Renderable;
import engine.frontend.RenderableImage;
import engine.frontend.RenderableText;
import engine.input.Mouse;

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
		RenderableText notice = new RenderableText(""+MarketPanel.getSellingPrice(tile.getPlant()), 660, 575);
		RenderableText growth = new RenderableText("Growth stage "+tile.getPlant().getGrowthLevel()+"/"+tile.getPlant().getGrowthStages(),750,102);
		ArrayList<Renderable> toRender = new ArrayList<Renderable>();
		toRender.add(image);
		toRender.add(tileRender);
		toRender.add(plantRender);
		toRender.add(name);
		toRender.add(notice);
		toRender.add(growth);
		toRender.addAll(renderResources());
		toRender.addAll(Utilities.renderLongText(25, tile.getPlant().getDescription(), 800, 353));
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
	
	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	@Override
	public void update() {
		if(new Rectangle(664, 528, 701, 552).contains(Mouse.getRecentClickLocationOnScreen()) && !tile.getPlant().isEqualTo(Plant.loadPlant(0))) {
			MarketPanel.sell(tile);
		}
	}
	
}
