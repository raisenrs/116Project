package objectville;

public abstract class UtilityProvider extends Cell {
	int capacity = 100;
	
	public UtilityProvider(int row, int col, char type) {
		super(row, col, type);
	}
	
	public boolean isConnectable() {
		return true;
	}
	
	public abstract String getUtilityType();
}
