package game;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import other.Farm;
import engine.backend.GameObjectHandler;
import engine.frontend.Renderable;
import engine.frontend.RenderableImage;

public class Tile implements Renderable {
	
	private Plant plant = new Plant();
	
	private ArrayList<Resource> resources;
	
	private String imagePath = "res/PlontTile.png";
	
	private int x;
	private int y;
	private final int IMAGE_HEIGHT = 128;
	private final int IMAGE_WIDTH = 128;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Tile(int x, int y, Plant p) {
		this.x = x;
		this.y = y;
		setPlant(new File("res/plants.txt"),17);
	}
	
	public String getImagePath() {
		return imagePath;
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
	
	public void setPlant(File file, int plantID) {
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
		try {
			Scanner scan = new Scanner(file);
			boolean searching = true;
			String[] line = new String[8];
			while(searching && scan.hasNextLine()) {
				line = scan.nextLine().split(";");
				if(line[0].equals(plantID))
					searching = false;
			}
			ArrayList<String> attributes = new ArrayList<String>();
			for(int i = 0; i < line.length-2; i++) {
				if(i!=2) {
					attributes.add(line[i]);
				} else {
					
				}
			}
			plant = new Plant(line[line.length-1],attributes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
		Farm.getInfoPanel().setTile(this);
		//InfoPanel panel = new InfoPanel(this);
		//GameObjectHandler.registerGameObject(panel);
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
		new RenderableImage("res/PlontTile.png", x*IMAGE_WIDTH, y*IMAGE_HEIGHT, getLevel()).render(g2d);
		if(plant!=null) {
			new RenderableImage(plant.getImagePath(), x*IMAGE_WIDTH, y*IMAGE_HEIGHT, getLevel()).render(g2d);
		}
	}

	@Override
	public int getLevel() {
		return 1;
	}
	
}
