package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Plant {
	
	private ArrayList<String> attributes;
	private ArrayList<Resource> neededResources;
	private int upgradeLevel;
	private int growthLevel;
	
	private static File file = new File("res/plants.txt"); //Where the plants are stored
	
	private Tile tile;
	
	private String imagePath = "res/TestPlant.png";
	
	/* Attributes:
	 * 0 = PlantID
	 * 1 = Plant Name
	 * 2 = Growth Stage Count
	 * 3 = Buy Base Price
	 * 4 = Sell Base Price
	 * 5 = Description
	 * 6 = Image File Path
	 */
	
	/**
	 * Constructs a plant with an image path, an ArrayList<String> of attributes, and an ArrayList<Resource> of resources needed
	 * @param imagePath the path to the plant's image
	 * @param attributes the attributes the plant has
	 * @param res the resources the plant needs
	 */
	public Plant(String imagePath, ArrayList<String> attributes, ArrayList<Resource> res) {
		this.imagePath = imagePath;
		this.attributes = new ArrayList<String>();
		String resources = attributes.remove(2);
		this.attributes.addAll(attributes);
		neededResources = res;
		String[] resourcePairs = resources.split(":");
		for(String s : resourcePairs) {
			if(s.split(",")[0].equals("water")) {
				//Add water resource to arraylist
			}
		}
		upgradeLevel = 0;
		growthLevel = 0;
	}
	
	/**
	 * Loads a plant from an ID numbers
	 * @param plantID the ID number
	 * @return the Plant that was created
	 */
	public static Plant loadPlant(int plantID){
		Plant plant;
		ArrayList<Resource> res = new ArrayList<>();
		try {
			Scanner scan = new Scanner(file);
			boolean searching = true;
			String[] line = new String[8];
			while(searching) {
				try{
				line = scan.nextLine().split(";");
				//System.out.println(line[0] + " AND " + plantID);
				if(line[0].equals(""+plantID)) {
					//System.out.println("MATCH");
					searching = false;
				}
				}catch(NoSuchElementException e){}
			}
			ArrayList<String> attributes = new ArrayList<String>();
			for(int i = 0; i < line.length; i++) {
				if(i!=2) {
					attributes.add(line[i]);
				} else {
					String[] resources = line[i].split(":");
					for(int c = 0; c < resources.length; c++){
						Resource needed = new Resource(Resource.resourceTypes.valueOf(resources[c].split(",")[0].toUpperCase()),Integer.parseInt(resources[c].split(",")[1]));
						res.add(needed);
					}
				}
			}
			//System.out.println(attributes.get(1));
			plant = new Plant(line[line.length-1],attributes, res);
			return plant;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	/**
	 * Gets the file path to the plant's image
	 * @return the file path to the plant's image
	 */
	public String getImagePath() {
		return imagePath;
	}
	
	/**
	 * Gets the name of the plant
	 * @return the name of the plant
	 */
	public String getName(){
		return attributes.get(1);
	}
	
	/**
	 * Gets the needed resource for the plant to grow
	 * @return an ArrayList<Resources> of the resources needed for the plant to grow
	 */
	public ArrayList<Resource> getNeededResources(){
		return neededResources;
	}
	
	/**
	 * Sets the plant's tile
	 * @param t the tile to set to
	 */
	public void setTile(Tile t){
		this.tile = t;
	}
	
	/**
	 * Gets the buy price for the plant
	 * @return the buy price for the plant
	 */
	public int getBuyPrice(){
		return Integer.parseInt(this.attributes.get(2));
	}
	
	/**
	 * Gets the sell price for the plant
	 * @return the sell price for the plant
	 */
	public int getSellPrice(){
		return Integer.parseInt(this.attributes.get(3));
	}
	
	/**
	 * Upgrades the plant's level by one
	 */
	public void upgrade(){
		this.upgradeLevel++;
		attributes.set(3, attributes.get(2) + Math.log(Double.parseDouble(attributes.get(2)) + 2));
		attributes.set(4, attributes.get(3) + Math.log(Double.parseDouble(attributes.get(3)) + 2));
		//attributes.set(6, attributes.get(6) + Math.log(Double.parseDouble(attributes.get(6)) + 2));
	}
	
	/**
	 * Gets the plant's upgrade level
	 * @return the plant's upgrade level
	 */
	public int getUpgradeLevel() {
		return upgradeLevel;
	}
	
	/**
	 * Sets the plant's upgrade level
	 * @param upgradeLevel the new upgradeLevel
	 */
	public void setUpgradeLevel(int upgradeLevel) {
		this.upgradeLevel = upgradeLevel;
	}
	
	/**
	 * Grows the plant
	 */
	public void grow(){
		if(growthLevel>=Integer.parseInt(attributes.get(2)))
			growthLevel++;
	}
	
	/**
	 * Checks if the plant can be harvested yet
	 * @return if the plant can be harvested
	 */
	public boolean canHarvest() {
		return growthLevel >= Integer.parseInt(attributes.get(2));
	}
	
	/**
	 * Gets the attributes of the plant
	 * @return the attributes of the plant
	 */
	public ArrayList<String> getAttributes() {
		return attributes;
	}
	
	/**
	 * Gets the description of the plant
	 * @return the plant's description
	 */
	public String getDescription() {
		return attributes.get(4);
	}
}
