package other;

import java.awt.Point;
import java.util.ArrayList;

import engine.backend.GameObject;
import engine.frontend.Renderable;
import engine.input.Mouse;
import game.InfoPanel;
import game.MarketPanel;
import game.Plant;
import game.Resource;
import game.Tile;

public class Farm implements GameObject{

	public static int FLOOR_SIZE = 5; 
	
	private Tile[][] tiles;
	
	private int currentFloor;
	
	private final long CLICK_DELAY = 100;
	private final long GROWTH_RATE_MILLIS = 1000;
	private final long MARKET_RATE_MILLIS = 10000;
	private long growthTime = 0;
	private long marketTime = 0;
	private Point lastClick;
	
	private static InfoPanel panel;
	private static MarketPanel market;
	
	public Farm() {
		panel = new InfoPanel(new Tile(0,0));
		market = new MarketPanel(this);
		tiles = new Tile[FLOOR_SIZE][FLOOR_SIZE];
		currentFloor = 0;
		for(int x = 0; x < FLOOR_SIZE; x++) {
			for(int y = 0; y < FLOOR_SIZE; y++) {
				tiles[x][y] = new Tile(x,y);
				/* DEBUG PURPOSES ONLY
				   switch(x) {
				case 1:
					//System.out.println("Tile (" + x + ", " + y + ") assigned with id 17");
					tiles[x][y] = new Tile(x,y,Plant.loadPlant(17));
					break;
				case 2:
					//System.out.println("Tile (" + x + ", " + y + ") assigned with id 18");
					tiles[x][y] = new Tile(x,y,Plant.loadPlant(18));
					break;
				case 3:
					//System.out.println("Tile (" + x + ", " + y + ") assigned with id 16");
					tiles[x][y] = new Tile(x,y,Plant.loadPlant(16));
					break;
				}
				*/
			}
		}
		lastClick = new Point(0,0);
	}

	public ArrayList<Renderable> render() {
		ArrayList<Renderable> toRender = new ArrayList<>();
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				toRender.add(tiles[x][y]);
			}
		}
		return toRender;
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
	
	public void giveResources() {
		//System.out.println("TEST");
		boolean[][] resourcesGiven = market.distributeResources();
		for(int i = 0; i < tiles.length; i++){
			for(int c = 0; c < tiles[0].length; c++){
				if(resourcesGiven[i][c])
					System.out.println("AHHHHHHHHHHHHH");
				tiles[i][c].setHasResources(resourcesGiven[i][c]);
			}
		}
	}
	
	public void update() {
		if(growthTime + GROWTH_RATE_MILLIS < System.currentTimeMillis()) {
			giveResources();
			for(int i = 0; i < tiles.length; i++) {
				for(int j = 0; j < tiles[0].length; j++) {
					//tiles[i][j].getPlant().grow();
				}
			}
			growthTime = System.currentTimeMillis();
		}
		if(marketTime + MARKET_RATE_MILLIS < System.currentTimeMillis()) {
			MarketPanel.changePriceModify();
			marketTime = System.currentTimeMillis();
		}
		Point click = handleClick();
		if(click.x <= 640 && click.y <= 640 && click.x >= 0 && click.y >= 0) {
			tiles[click.x/128][click.y/128].onClick();
			lastClick = click;
		} else {
			tiles[lastClick.x/128][lastClick.y/128].onClick();
		}
		for(Tile[] a : tiles){
			for(Tile t : a){
				t.update();
			}
		}
	}
	
	public Point handleClick() {
		long lastClickTime = Mouse.getLastClickTime();
		Point lastClickPlace = Mouse.getRecentClickLocationOnScreen();
		//if(lastClickTime+CLICK_DELAY>System.currentTimeMillis())
		//	System.out.println(lastClickPlace.toString());
		if(lastClickPlace.x != 0 && lastClickPlace.y != 0) {
			return new Point(lastClickPlace.x, lastClickPlace.y);
		}
		return new Point(-1,-1);
	}
	
	public static InfoPanel getInfoPanel() {
		return panel;
	}
	
	public static MarketPanel getMarketPanel(){
		return market;
	}
}
