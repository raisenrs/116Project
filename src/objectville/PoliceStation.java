package objectville;

public class PoliceStation extends ServiceBuilding {
    public PoliceStation(int row, int col) {
        super(row, col, 'F', 5);
    }

    public void applyService(Zone z) {
        z.hasSecurity = true;
    }
}