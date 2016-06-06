package game;

import java.util.ArrayList;
import java.util.Random;

import engine.backend.GameObject;
import engine.frontend.Renderable;

public class MarketPanel implements GameObject{

	private ArrayList<Integer> resourceCosts;
	
	private ArrayList<Plant> recentlySold;
	
	private final int WATER_COST = 10;
	private final int FERTILIZER_COST = 15;
	
	private Plant trendingPlant;
	/*
	 * 0 = water
	 * 1 = fertilizer
	 */
	private int money;
	
	public MarketPanel(){
		trendingPlant = new Plant();
		money = 100;
		
		resourceCosts = new ArrayList<>();
		resourceCosts.add(WATER_COST);
		resourceCosts.add(FERTILIZER_COST);
		
		recentlySold = new ArrayList<>();
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
		//TODO: Put in image for market panel
		return null;
	}

	@Override
	public void update() {
		int randomTemp = new Random().nextInt(1000);
		if(randomTemp==420){
			//TODO: Load random plant 
		}
	}

}
