package game;

import java.util.ArrayList;
import java.util.Random;

import engine.backend.GameObject;
import engine.frontend.Renderable;
import engine.frontend.RenderableImage;
import engine.frontend.RenderableText;
import other.Farm;

public class MarketPanel implements GameObject{

	private ArrayList<Integer> resourceCosts;
	
	private ArrayList<Resource> resources;
	
	private ArrayList<Plant> recentlySold;
	
	private Farm farm;
	
	private String imagePath;
	
	private final int WATER_COST = 10;
	private final int FERTILIZER_COST = 15;
	
	private Plant trendingPlant;
	/*
	 * 0 = water
	 * 1 = fertilizer
	 */
	private int money;
	
	public MarketPanel(Farm farm){
		this.farm = farm;
		
		trendingPlant = new Plant();
		money = 100;
		
		resources = new ArrayList<>();
		
		resourceCosts = new ArrayList<>();
		resourceCosts.add(WATER_COST);
		resourceCosts.add(FERTILIZER_COST);
		
		imagePath = "res/MarketPanelImage.png";
		
		recentlySold = new ArrayList<>();
	}
	
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
	
	public ArrayList<Resource> getResources(){
		return resources;
	}
	
	public int /* fuck bitches */ getMoney(){
		return money;
	}
	
	public int getSellingPrice(Plant p){
		double marketFactor = 1.0;
		for(Plant soldPlants : recentlySold){
			if(p.equals(soldPlants)){
				marketFactor/=(Math.log(p.getSellPrice())/10);
			}
		}
		if(p.equals(trendingPlant)) marketFactor*=2;
		return (int) Math.round(p.getSellPrice() * marketFactor); 
	}
	
	public Plant getTrendingPlant(){
		return trendingPlant;
	}
	
	public void sell(Plant p){
		money += getSellingPrice(p);
		recentlySold.add(p);
		if(recentlySold.size()>=30){
			recentlySold.remove(0);
		}
	}
	
	@Override
	public ArrayList<Renderable> render() {
		ArrayList<Renderable> toRender = new ArrayList<>();
		toRender.add(new RenderableImage(imagePath, 10, 650, 1));
		RenderableText trending = new RenderableText("Currently Trending Plant: " + trendingPlant.getName(), 710, 850);
		toRender.add(trending);
		return toRender;
	}

	@Override
	public void update() {
		int randomTemp = new Random().nextInt(1000);
		if(randomTemp==420){
			//TODO: Uncomment when all plants are written down in file
			//trendingPlant = Plant.loadPlant(new Random().nextInt(20));
		}
	}

}
