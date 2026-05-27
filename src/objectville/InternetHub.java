package objectville;

public class InternetHub extends UtilityProvider {
	public InternetHub(int row, int col) {
		super(row, col, 'T');
	}
	
	public String getUtilityType() {
		return "internet";
	}
}
