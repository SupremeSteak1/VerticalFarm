package game;

import java.util.ArrayList;

public class Tile {
	
	private Plant plant;
	
	private ArrayList<Resource> resources;
	
	public Tile() {
		
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
	
	/**
	 * Returns if the plant can grow with the current resources or not
	 * @return if the plant can grow
	 */
	public boolean canPlantGrow(){
		if(isEmpty()) return false;
		return true; //TODO: Fix
	}
	
}
