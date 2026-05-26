package objectville;

public class PowerPlant extends UtilityProvider {
	public PowerPlant(int row, int col) {
		super(row, col, 'P');
	}
	
	public String getUtilityType() {
		return "electricity";
	}
}
