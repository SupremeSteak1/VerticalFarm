package game;

import java.util.ArrayList;

public class Plant {
	
	private ArrayList<Double> attributes;
	private ArrayList<Resource> neededResources;
	private int upgradeLevel;
	private int growthLevel;
	
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
