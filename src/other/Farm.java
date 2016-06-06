package other;

import engine.backend.GameObject;
import engine.frontend.Renderable;
import engine.input.Mouse;
import game.Tile;

import java.awt.Point;
import java.util.ArrayList;

public class Farm implements GameObject{

	public static int FLOOR_SIZE = 5; 
	
	private Tile[][] tiles;
	
	private int currentFloor;
	
	private final long CLICK_DELAY = 100;
	
	public Farm() {
		tiles = new Tile[FLOOR_SIZE][FLOOR_SIZE];
		currentFloor = 0;
		for(int x = 0; x < FLOOR_SIZE; x++) {
			for(int y = 0; y < FLOOR_SIZE; y++) {
				tiles[x][y] = new Tile(x,y);
			}
		}
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

	public void update() {
		long lastClickTime = Mouse.getLastClickTime();
		Point lastClickPlace = Mouse.getRecentClickLocationOnScreen();
		//if(lastClickTime+CLICK_DELAY>System.currentTimeMillis())
		//	System.out.println(lastClickPlace.toString());
		if(lastClickPlace.x != 0 && lastClickPlace.y != 0) {
			tiles[lastClickPlace.x / 128][lastClickPlace.y / 128].onClick();
		}
		for(Tile[] a : tiles){
			for(Tile t : a){
				t.update();
			}
		}
	}
	
	
	
}
