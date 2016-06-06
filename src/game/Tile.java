package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import engine.frontend.Renderable;
import engine.frontend.RenderableImage;

public class Tile implements Renderable {
	
	private Plant plant;
	
	private ArrayList<Resource> resources;
	
	private int x;
	private int y;
	private final int IMAGE_HEIGHT = 128;
	private final int IMAGE_WIDTH = 128;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		
	}
	
	/**
	 * Add a resource to the available resources for the tile
	 * @param r the resource to be added
	 */
	public void addResource(Resource r) {
		resources.add(r);
	}
	
	/**
	 * Remove a resource if available
	 * @param r the resource to be removed
	 * @return if it could be removed
	 */
	public boolean removeResource(Resource r) {
		return resources.remove(r);
	}
	
	/**
	 * Sets the plant on this tile to a new one
	 * @param plant the plant to be placed on this tile
	 */
	public void setPlant(Plant plant) {
		this.plant = plant;
		plant.setTile(this);
	}
	
	/**
	 * Gets the current plant on this tile. Returns null if no plant.
	 * @return the plant on this tile
	 */
	public Plant getPlant() {
		return plant;
	}
	
	/**
	 * Returns true if there is no plant in the tile
	 * @return if the tile is empty or not
	 */
	public boolean isEmpty() {
		return plant==null;
	}
	
	public void onClick() {
		System.out.println(this.x + " " + this.y);
	}
	
	/**
	 * Returns if the plant can grow with the current resources or not
	 * @return if the plant can grow
	 */
	public boolean canPlantGrow(){
		if(isEmpty()) return false;
		return true; //TODO: Fix
	}

	@Override
	public void render(Graphics2D g2d) {
		new RenderableImage("res/PlontTile.png", x*IMAGE_WIDTH, y*IMAGE_HEIGHT, getLevel()).render(g2d);;
	}

	@Override
	public int getLevel() {
		return 1;
	}
	
}
