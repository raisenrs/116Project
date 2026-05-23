package objectville;

public class HousingZone extends Zone {
	public HousingZone(int row, int col) {
		super(row, col, 'H');
	}
	
	public boolean noUtilities() {
		if (this.electricity == 0 && this.water == 0 && this.internet == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean canLevelUp(int target) {
		if (target == 1) {
			if (this.electricity > 0 && this.water > 0 && this.internet > 0) {
				return true;
			}
		}
		if (target == 2) {
			if (canLevelUp(1) && this.hasSecurity && this.hasHealth && this.hasEducation) {
				return true;
			}
		}
		if (target == 3) {
			if (canLevelUp(2) && this.lifestyle > 0) {
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
		if (this.internet < minVal) {
			minVal = this.internet;
		}
		
		if (this.level == 0) {
			this.output = 0;
		} else if (this.level == 1) {
			this.output = minVal;
		} else if (this.level == 2) {
			this.output = 2 * minVal;
		} else {
			this.output = 2 * minVal + this.lifestyle;
		}
	}
}
