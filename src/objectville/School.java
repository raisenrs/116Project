package objectville;

public class School extends ServiceBuilding {
    public School(int row, int col) {
        super(row, col, 'S', 4);
    }

    public void applyService(Zone z) {
        z.hasEducation = true;
    }
}
