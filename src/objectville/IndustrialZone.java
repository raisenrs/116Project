package objectville;

public class IndustrialZone extends Zone {
	public IndustrialZone(int row, int col) {
		super(row, col, 'I');
	}
	
	public boolean noUtilities() {
		if (this.electricity == 0 && this.water == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean canLevelUp(int target) {
		if (target == 1) {
			if (this.population > 0 && this.electricity > 0 && this.water > 0) {
				return true;
			}
		}
		if (target == 2) {
			if (canLevelUp(1) && this.hasSecurity) {
				return true;
			}
		}
		if (target == 3) {
			int minVal = this.electricity;
			if (this.water < minVal) {
				minVal = this.water;
			}
			if (canLevelUp(2) && this.population > 2 * minVal) {
				return true;
			}
		}
		return false;
	}
	
	public void calcOutput() {
		int minVal = this.electricity;
		if (this.water < minVal) {
			minVal = this.water;
		}
		
		if (this.level == 0) {
			this.output = 0;
		} else if (this.level == 1) {
			this.output = minVal;
		} else if (this.level == 2) {
			this.output = 2 * minVal;
		} else {
			this.output = 2 * minVal + this.population;
		}
	}
}
