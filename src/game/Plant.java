package game;

import java.util.ArrayList;

public class Plant {
	
	private ArrayList<Double> attributes;
	private ArrayList<Resource> neededResources;
	private int upgradeLevel;
	private int growthLevel;
	
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
	
	public int getUpgradeLevel() {
		return upgradeLevel;
	}
	
	public void setUpgradeLevel(int upgradeLevel) {
		this.upgradeLevel = upgradeLevel;
	}
	
	public void canHarvest() {
		
	}
}
