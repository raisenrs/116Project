package objectville;

public abstract class ServiceBuilding extends Cell {
	int radius;
	
	public ServiceBuilding(int row, int col, char type, int radius) {
		super(row, col, type);
		this.radius = radius;
	}
	
	public boolean isConnectable() {
		return false;
	}
	
	public boolean covers(int r, int c) {
		double dist = Math.sqrt((this.row - r) * (this.row - r) + (this.col - c) * (this.col - c));
		if (dist <= this.radius) {
			return true;
		} else {
			return false;
		}
	}
	
	public abstract void applyService(Zone z);
}
