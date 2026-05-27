package objectville;

public class WaterStation extends UtilityProvider {
	public WaterStation(int row, int col) {
		super(row, col, 'W');
	}
	
	public String getUtilityType() {
		return "water";
	}
}
