package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Plant {
	
	private ArrayList<String> attributes;
	private ArrayList<Resource> neededResources;
	private int upgradeLevel;
	private int growthLevel;
	
	private Tile tile;
	
	private String imagePath = "res/TestPlant.png";
	
	//Attributes:
	/* indices yo
	 * 0 = PlantID
	 * 1 = Plant Name
	 * 2 = Growth Stage Number
	 * 3 = Buy price
	 * 4 = Sell price
	 * 5 = Description
	 * 6 = Image file path
	 */
	
	public Plant() {
		attributes = new ArrayList<String>();
		attributes.add("0");
		attributes.add("Test plont");
		neededResources = new ArrayList<Resource>();
		upgradeLevel = 0;
		growthLevel = 0;
	}
	
	public Plant(String imagePath) {
		this.imagePath = imagePath;
		attributes = new ArrayList<String>();
		attributes.add("0");
		attributes.add("Test plont");
		neededResources = new ArrayList<Resource>();
		upgradeLevel = 0;
		growthLevel = 0;
	}
	
	public Plant(String imagePath, ArrayList<String> attributes) {
		this.imagePath = imagePath;
		this.attributes = new ArrayList<String>();
		this.attributes.addAll(attributes);
		neededResources = new ArrayList<Resource>();
		upgradeLevel = 0;
		growthLevel = 0;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setTile(Tile t){
		this.tile = t;
	}
	
	public int getBuyPrice(){
		return Integer.parseInt(this.attributes.get(3));
	}
	
	public int getSellPrice(){
		return Integer.parseInt(this.attributes.get(4));
	}
	
	public void upgrade(){
		this.upgradeLevel++;
		attributes.set(2, attributes.get(2) + Math.log(Double.parseDouble(attributes.get(2)) + 2));
		attributes.set(3, attributes.get(3) + Math.log(Double.parseDouble(attributes.get(3)) + 2));
		attributes.set(6, attributes.get(6) + Math.log(Double.parseDouble(attributes.get(6)) + 2));
	}
	
	public int getUpgradeLevel() {
		return upgradeLevel;
	}
	
	public void setUpgradeLevel(int upgradeLevel) {
		this.upgradeLevel = upgradeLevel;
	}
	
	public void canHarvest() {
		
	}
	
	public ArrayList<String> getAttributes() {
		return attributes;
	}
}
