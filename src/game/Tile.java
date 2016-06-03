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
	
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	
	public Plant getPlant() {
		return plant;
	}
	
	public boolean isEmpty() {
		return plant==null;
	}
	
	public boolean canPlantGrow(){
		
	}
	
}
