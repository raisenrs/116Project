package objectville;

public class Hospital extends ServiceBuilding {
    public Hospital(int row, int col) {
        super(row, col, 'D', 3);
    }

    public void applyService(Zone z) {
        z.hasHealth = true;
    }
}
