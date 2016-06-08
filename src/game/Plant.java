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
	
	
	public Plant() {
		attributes = new ArrayList<String>();
		attributes.add("0");
		attributes.add("Test plont");
		attributes.add("0");
		attributes.add("0");
		attributes.add("0");
		attributes.add("0");
		attributes.add("0");
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
		attributes.add("0");
		attributes.add("0");
		attributes.add("0");
		attributes.add("0");
		attributes.add("0");
		neededResources = new ArrayList<Resource>();
		upgradeLevel = 0;
		growthLevel = 0;
		file = new File("res/plants.txt");
	}
	
	
	public Plant(String imagePath, ArrayList<String> attributes) {
		this.imagePath = imagePath;
		this.attributes = new ArrayList<String>();
		String resources = attributes.remove(2);
		this.attributes.addAll(attributes);
		neededResources = new ArrayList<Resource>();
		String[] resourcePairs = resources.split(":");
		for(String s : resourcePairs) {
			if(s.split(",")[0].equals("water")) {
				//Add water resource to arraylist
			}
		}
		upgradeLevel = 0;
		growthLevel = 0;
	}
	
	public static Plant loadPlant(int plantID){
		Plant plant;
		try {
			Scanner scan = new Scanner(file);
			boolean searching = true;
			String[] line = new String[8];
			while(searching) {
				try{
				line = scan.nextLine().split(";");
				System.out.println(line[0] + " AND " + plantID);
				if(line[0].equals(""+plantID)) {
					System.out.println("MATCH");
					searching = false;
				}
				}catch(NoSuchElementException e){}
			}
			ArrayList<String> attributes = new ArrayList<String>();
			for(int i = 0; i < line.length; i++) {
				if(i!=2) {
					attributes.add(line[i]);
				} else {
					
				}
			}
			System.out.println(attributes.get(1));
			plant = new Plant(line[line.length-1],attributes);
			return plant;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public String getName(){
		return attributes.get(1);
	}
	
	public ArrayList<Resource> getNeededResources(){
		return neededResources;
	}
	
	public void setTile(Tile t){
		this.tile = t;
	}
	
	public int getBuyPrice(){
		return Integer.parseInt(this.attributes.get(2));
	}
	
	public int getSellPrice(){
		return Integer.parseInt(this.attributes.get(3));
	}
	
	public void upgrade(){
		this.upgradeLevel++;
		attributes.set(3, attributes.get(2) + Math.log(Double.parseDouble(attributes.get(2)) + 2));
		attributes.set(4, attributes.get(3) + Math.log(Double.parseDouble(attributes.get(3)) + 2));
		//attributes.set(6, attributes.get(6) + Math.log(Double.parseDouble(attributes.get(6)) + 2));
	}
	
	public int getUpgradeLevel() {
		return upgradeLevel;
	}
	
	public void setUpgradeLevel(int upgradeLevel) {
		this.upgradeLevel = upgradeLevel;
	}
	
	public void grow(){
		if(growthLevel>=Integer.parseInt(attributes.get(2)))
		growthLevel++;
	}
	
	public boolean canHarvest() {
		return growthLevel >= Integer.parseInt(attributes.get(2));
	}
	
	public ArrayList<String> getAttributes() {
		return attributes;
	}
	
	public String getDescription() {
		return attributes.get(4);
	}
}
