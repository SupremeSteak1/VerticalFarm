package game;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import other.Farm;
import other.Utilities;
import engine.backend.GameObject;
import engine.frontend.Renderable;
import engine.frontend.RenderableImage;
import engine.frontend.RenderableText;
import engine.input.Mouse;

/**
 * 
 * @author Josh Gordon
 * @version 6/08/16
 */
public class MarketPanel implements GameObject{

	private ArrayList<Integer> resourceCosts;
	
	private ArrayList<Resource> resources;
	
	private static ArrayList<Plant> recentlySold;
	
	private Farm farm;
	
	private String imagePath;
	
	private Plant selectedPlant;
	
	private final int WATER_COST = 10;
	private final int FERTILIZER_COST = 15;
	
	private boolean planting;
	
	private static Plant trendingPlant = Plant.loadPlant(0);
	
	private Plant[] plantsAtMarket;
	/*
	 * 0 = water
	 * 1 = fertilizer
	 */
	private static int money;
	
	public MarketPanel(Farm farm) {
		this.farm = farm;
		
		//Removed plant constructor
		money = 2000;
		
		plantsAtMarket = new Plant[5];
		
		resources = new ArrayList<>();
		
		resourceCosts = new ArrayList<>();
		resourceCosts.add(WATER_COST);
		resourceCosts.add(FERTILIZER_COST);
		
		imagePath = "res/MarketPanelImage.png";
		
		recentlySold = new ArrayList<>();
		
		selectedPlant = Plant.loadPlant(0);
		
		assignTrendingPlant();
		for(int i = 0; i < 5; i++){
			plantsAtMarket[i] = Plant.loadPlant(new Random().nextInt(9) + 10);
		}
	}
	
	/**
	 * Distributes resources to plants on the grid
	 * @return a 2d boolean array of plants that received the needed resources
	 */
	public boolean[][] distributeResources(){
		boolean[][] distributed = new boolean[farm.getTiles().length][farm.getTiles()[0].length];
		int x = 0;
		int y = 0;
		for(Tile[] a : farm.getTiles()){
			for(Tile t : a){
				ArrayList<Resource> required = t.getPlant().getNeededResources();
				for(Resource r : required){
					for(Resource b : resources){
						if(b.getType().equals(r.getType()) && b.getAmount() >= r.getAmount()){
							b.removeResource(r.getAmount());
							distributed[x][y] = true;
						}else{
							distributed[x][y] = false;
						}
						
					}
				}
				y++;
			}
			x++;
		}
		return distributed;
	}
	
	/**
	 * Gets the resources available
	 * @return an ArrayList<Resource> of resource available
	 */
	public ArrayList<Resource> getResources(){
		return resources;
	}
	
	/**
	 * Returns the money that the player has
	 * @return the money the player has
	 */
	public int getMoney(){
		return money;
	}
	
	/**
	 * Gets the selling price of a plant
	 * @param p the plant to get the price of
	 * @return the selling price of the plant
	 */
	public static int getSellingPrice(Plant p){
		double marketFactor = 1.0;
		for(Plant soldPlants : recentlySold){
			if(p.equals(soldPlants)){
				marketFactor/=(Math.log(p.getSellPrice())/10);
			}
		}
		if(p.equals(trendingPlant)) marketFactor*=2;
		return (int) Math.round(p.getSellPrice() * marketFactor); 
	}
	
	/**
	 * Gets the plant that is currently trending
	 * @return the currently trending plant
	 */
	public Plant getTrendingPlant() {
		return trendingPlant;
	}
	
	/**
	 * Sells a plant on a given tile
	 * @param t the tile containing the plant to sell
	 */
	public static void sell(Tile t) {
		if(t.getPlant().canHarvest()){
		Plant p = t.getPlant();
		money += getSellingPrice(p);
		recentlySold.add(p);
		if(recentlySold.size()>=30){
			recentlySold.remove(0);
		}
		t.setPlant(0);
	}
	}
	
	/**
	 * The render method inherited from GameObject
	 */
	@Override
	public ArrayList<Renderable> render() {
		ArrayList<Renderable> toRender = new ArrayList<>();
		toRender.add(new RenderableImage(imagePath, 10, 650, 1));
		RenderableText trending = new RenderableText("Currently Trending Plant: " + trendingPlant.getName(), 710, 850);
		RenderableText buyLabel = new RenderableText("Buy Price:", 32, 730);
		RenderableText money = new RenderableText(""+getMoney(), 720, 720);
		toRender.add(trending);
		toRender.add(buyLabel);
		toRender.add(money);
		toRender.addAll(renderPlantsAndPrices());
		return toRender;
	}
	
	/**
	 * Renders the plants and their respective prices
	 * @return an ArrayList<Renderable> of items to render
	 */
	private ArrayList<Renderable> renderPlantsAndPrices() {
		ArrayList<Renderable> toRender = new ArrayList<>();
		for(int i = 0; i < 5; i++){
			if(plantsAtMarket[i].isEqualTo(selectedPlant)){
				toRender.add(new RenderableText("*" + plantsAtMarket[i].getName() + "*", (i+1)*90,710));
				toRender.add(new RenderableText(getSellingPrice(plantsAtMarket[i]) + "", (i+1)*90, 730));
			}else{
			toRender.add(new RenderableText(plantsAtMarket[i].getName(), (i+1)*90,710));
			//Change the above line as more plants get added
			toRender.addAll(Utilities.renderLongText(14, plantsAtMarket[i].getName(), (i+1)*90,710));
			toRender.add(new RenderableText(getSellingPrice(plantsAtMarket[i]) + "", (i+1)*90, 730));
			}
		}
		return toRender;
	}
	
	/**
	 * Assigns plants to the market
	 * @param plants the plants to be put on the market
	 */
	public void assignPlantsAtMarket(ArrayList<Plant> plants){
		for(int i = 0; i < 5; i++){
			plantsAtMarket[i] = plants.get(i);
		}
	}
	
	/**
	 * The update method inherited from GameObject
	 */
	@Override
	public void update() {
		assignTrendingPlant();
		int randomTemp = new Random().nextInt(1000);
		if(randomTemp==420){
			plantsAtMarket[new Random().nextInt(5)] = Plant.loadPlant(new Random().nextInt(9) + 10);
			//Change the above when more plants are added
		}
		for(int i = 0; i < 5; i++){
			if(new Rectangle((i+1)*90, 730, 80, 50).contains(Mouse.getRecentClickLocationOnScreen()) &&
					getSellingPrice(plantsAtMarket[i]) <= getMoney()){
				//System.out.println("DEBUG YO!");
				money -= getSellingPrice(plantsAtMarket[i]);
				selectedPlant = plantsAtMarket[i];
				planting = true;
			}
		}
		if(planting){
			Point p = Mouse.getRecentClickLocationOnScreen();
			System.out.print("");
			if(new Rectangle(1,1,640,640).contains(p)){
				farm.getTiles()[p.x/128][p.y/128].setPlant(selectedPlant);
				this.selectedPlant = Plant.loadPlant(0);
				planting = false;
			}
		}
	}
	
	/**
	 * Plants a seed in a tile
	 * @param plant the plant to plant
	 */
	private void plantSeed(Plant plant) {
		this.selectedPlant = plant;
		System.out.println(selectedPlant.getName() + " IS SELECTED");
		boolean running = true;
		while(running){
			Point p = Mouse.getRecentClickLocationOnScreen();
			System.out.print("");
			if(new Rectangle(1,1,640,640).contains(p)){
				farm.getTiles()[p.x/128][p.y/128].setPlant(plant);
				this.selectedPlant = Plant.loadPlant(0);
				running = false;
			}
		}
	}
	
	/**
	 * Sets a new trending plant
	 */
	private void assignTrendingPlant(){
		int randomTemp = new Random().nextInt(1000);
		if(randomTemp == 420){
			trendingPlant = Plant.loadPlant(new Random().nextInt(2) + 17);
		}
	}
	
	private ArrayList<String> getImagePathsFromPlants(){
		ArrayList<String> paths = new ArrayList<>();
		for(int i = 9; i < 20; i++){
			try{
				paths.add(Plant.loadPlant(i).getImagePath());
			}catch(Exception e){
				//We gotta write up some plants
				//Edit: We gotta generate some plants and add ART
			}
		}
		return paths;
	}

}
