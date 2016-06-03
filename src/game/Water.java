package game;

public class Water extends Resource {
//game confirmed
	
	private resourceType type;
	private double count;
	
	public Water() {
		type = resourceType.WATER;
		count = 0;
	}
	
	public Water(double count) {
		type = resourceType.WATER;
		this.count = count;
	}
	
	@Override
	public double getCount() {
		return count;
	}
	
	@Override
	public void setCount(double count) {
		this.count = count;
	}

}
