package objectville;

public abstract class Zone extends Cell {
	int level = 0;
	int output = 0;
	int demand = 1;
	
	int electricity = 0;
	int water = 0;
	int internet = 0;
	
	boolean hasSecurity = false;
	boolean hasHealth = false;
	boolean hasEducation = false;
	
	int population = 0;
	int goods = 0;
	int lifestyle = 0;
	
	public Zone(int row, int col, char type) {
		super(row, col, type);
	}
	
	public boolean isConnectable() {
		return true;
	}

