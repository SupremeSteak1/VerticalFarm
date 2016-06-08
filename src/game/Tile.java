package game;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import engine.frontend.Renderable;
import engine.frontend.RenderableImage;
import other.Farm;

public class Tile implements Renderable {
	
	private Plant plant = Plant.loadPlant(0);
	
	private ArrayList<Resource> resources;
	
	private String imagePath = "res/tileImage.png";
	
	private boolean hasResources;
	
	private int x;
	private int y;
	private final int IMAGE_HEIGHT = 128;
	private final int IMAGE_WIDTH = 128;
	
	private int growTimer;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		hasResources = false;
	}
	
	public Tile(int x, int y, Plant p) {
		this.x = x;
		this.y = y;
		setPlant(p);
		hasResources = false;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void update() {
		if(hasResources) {
			System.out.println("Getting HERE");
			int randomTemp = new Random().nextInt(50);
			if(randomTemp == 42){
				System.out.println("Plant has grown");
				plant.grow();
			}
		}
	}
	
	public void setHasResources(boolean value){
		hasResources = value;
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
	
	public void setPlant(int plantID) {
		//Attributes:
		/*
		* 0 = PlantID
		* 1 = Plant Name
		* 2 = Water Needed
		* 3 = Fertilizer Needed
		* 4 = Number of Growth Stages
		* 5 = Base Buy Price
		* 6 = Base Sell Price
		*/
		plant = Plant.loadPlant(plantID);
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
		Farm.getInfoPanel().setTile(this);
	}

	@Override
	public void render(Graphics2D g2d) {
		new RenderableImage(imagePath, x*IMAGE_WIDTH, y*IMAGE_HEIGHT, getLevel()).render(g2d);
		if(plant!=null) {
			new RenderableImage(plant.getImagePath(), x*IMAGE_WIDTH, y*IMAGE_HEIGHT, getLevel()).render(g2d);
		}
	}

	@Override
	public int getLevel() {
		return 1;
	}
	
}
