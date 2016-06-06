package game;

import java.util.ArrayList;

public class Plant {
	
	private ArrayList<Double> attributes;
	private ArrayList<Resource> neededResources;
	private int upgradeLevel;
	private int growthLevel;
	
	private Tile tile;
	
	//Attributes:
	/* indices yo
	 * 0 = PlantID
	 * 1 = Plant Name
	 * 2 = Water Needed
	 * 3 = Fertilizer Needed
	 * 4 = Number of Growth Stages
	 * 5 = Base Buy Price
	 * 6 = Base Sell Price
	 */
	
	public Plant() {
		attributes = new ArrayList<Double>();
		neededResources = new ArrayList<Resource>();
		upgradeLevel = 0;
		growthLevel = 0;
	}
	
	public void setTile(Tile t){
		this.tile = t;
	}
	
	public void upgrade(){
		this.upgradeLevel++;
		attributes.set(2, attributes.get(2) + Math.log(attributes.get(2) + 2));
		attributes.set(3, attributes.get(3) + Math.log(attributes.get(3) + 2));
		attributes.set(6, attributes.get(6) + Math.log(attributes.get(6) + 2));
	}
	
	public int getUpgradeLevel() {
		return upgradeLevel;
	}
	
	public void setUpgradeLevel(int upgradeLevel) {
		this.upgradeLevel = upgradeLevel;
	}
	
	public void canHarvest() {
		
	}
}
