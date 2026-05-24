package objectville;

public abstract class Zone extends Cell {
	int level = 0;
	int output = 0;
	int demand = 1;
	
	int electricity = 0;
	int water = 0;
	int internet = 0;
	
	boolean hasSecurity = false;
	boolean hasHealth = false;
	boolean hasEducation = false;
	
	int population = 0;
	int goods = 0;
	int lifestyle = 0;
	
	public Zone(int row, int col, char type) {
		super(row, col, type);
	}
	
	public boolean isConnectable() {
		return true;
	}

public void reset() {
        this.electricity = 0;
        this.water = 0;
        this.internet = 0;
        this.hasSecurity = false;
        this.hasHealth = false;
        this.hasEducation = false;
        this.population = 0;
        this.goods = 0;
        this.lifestyle = 0;
    }
    
    public void update() {
        if (noUtilities()) {
            this.level = 0;
            this.output = 0;
            this.demand = 1;
            return;
        }
        
        if (this.level < 3) {
            if (canLevelUp(this.level + 1)) {
                this.level = this.level + 1;
            }
        }
        if (this.level > 0) {
            if (canLevelUp(this.level) == false) {
                this.level = this.level - 1;
            }
        }
        
        calcOutput();
        
        if (this.output < 1) {
            this.demand = 1;
        } else {
            this.demand = this.output;
        }
    }
    
    public abstract boolean noUtilities();
    public abstract boolean canLevelUp(int target);
    public abstract void calcOutput();
}
