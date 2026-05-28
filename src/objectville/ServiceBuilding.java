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
        double dist = Math.sqrt(Math.pow((this.row - r), 2) + Math.pow((this.col - c), 2));
       return dist <= this.radius;
    }

    public abstract void applyService(Zone z);
}
