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
	
	private static File file; //Where the plants are stored
	
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
		file = new File("res/plants.txt");
	}
	
	public Plant(String imagePath) {
		this.imagePath = imagePath;
		attributes = new ArrayList<String>();
		attributes.add("0");
		attributes.add("Test plont");
		neededResources = new ArrayList<Resource>();
		upgradeLevel = 0;
		growthLevel = 0;
		file = new File("res/plants.txt");
	}
	
	public Plant(String imagePath, ArrayList<String> attributes) {
		this.imagePath = imagePath;
		this.attributes = new ArrayList<String>();
		this.attributes.addAll(attributes);
		neededResources = new ArrayList<Resource>();
		upgradeLevel = 0;
		growthLevel = 0;
		file = new File("res/plants.txt");
	}
	
	public static Plant loadPlant(int plantID){
		Plant plant;
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
			return plant;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public String getName(){
		return attributes.get(1);
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
	
	public void grow(){
		growthLevel++;
	}
	
	public boolean canHarvest() {
		return growthLevel >= Integer.parseInt(attributes.get(2));
	}
	
	public ArrayList<String> getAttributes() {
		return attributes;
	}
}
