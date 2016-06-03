package game;

public abstract class Resource {

	public abstract double getCount();
	public abstract void setCount(double count);
	
	public enum resourceType{
		NOT_SET,
		WATER,
		SOIL,
		ELECTRICTY
	}
	
}
