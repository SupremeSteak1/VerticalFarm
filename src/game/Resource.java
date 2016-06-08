package game;

public class Resource {

	private resourceTypes type;
	private int amount;
	
	
	public Resource(resourceTypes type, int amount){
		this.type = type;
		this.amount = amount;
	}
	
	public enum resourceTypes{
		NOT_SET,
		WATER,
		FERT
	}

	public resourceTypes getType() {
		return type;
	}

	public int getAmount() {
		return amount;
	}
	
	public void addResource(int a){
		amount+=a;
	}
	
	public void removeResource(int a){
		amount-=a;
	}
	
}
