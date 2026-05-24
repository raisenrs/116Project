package objectville;

public class CommercialZone extends Zone {
	public CommercialZone(int row, int col) {
		super(row, col, 'C');
	}
	public boolean noUtilities() {
		if (this.electricity == 0) {
			if (this.water == 0) {
				if (this.internet == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean canLevelUp(int target) {
		if (target == 1) {
		if (this.population > 0) {
		if (this.goods > 0) {
		if (this.electricity > 0) {
		if (this.water > 0) {
		if (this.internet > 0) {
		return true;
							}
						}
					}
				}
			}
			return false;
		}
		
		if (target == 2) {
			if (canLevelUp(1)) {
				if (this.hasSecurity == true) { 
					return true;
				}
			}
			return false;
		}
		
		if (target == 3) {
			int minVal = this.electricity;
			if (this.water < minVal) {
				minVal = this.water;
			}
			if (this.internet < minVal) {
				minVal = this.internet;
			}
			
			if (canLevelUp(2)) {
				if (this.population > (2 * minVal)) {
					if (this.goods > (2 * minVal)) {
						return true;
					}
				}
			}
			return false;
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
		} 
		else if (this.level == 1) {
			this.output = minVal;
		} 
		else if (this.level == 2) {
			this.output = 2 * minVal;
		} 
		else {
		
			int extra = this.population;
			if (this.goods < extra) {
				extra = this.goods;
			}
			this.output = (2 * minVal) + extra;
		}
	}
}
