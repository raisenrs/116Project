package objectville;

public class RoadCell extends Cell {
	public RoadCell(int row, int col) {
		super(row, col, 'R');
	}
	
	public boolean isConnectable() {
		return true;
	}
}
