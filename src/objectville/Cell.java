package objectville;

public abstract class Cell {
	int row, col;
	char type;
	
	public Cell(int row, int col, char type) {
		this.row = row;
		this.col = col;
		this.type = type;
	}
	
	
	public abstract boolean isConnectable();
}
