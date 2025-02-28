package view;

public class GridManager {
    private static final int GRID_SIZE = 16;
    private static final double CELL_WIDTH = 500.0 / GRID_SIZE;
    private static final double CELL_HEIGHT = 500.0 / GRID_SIZE;

    public double getCellWidth() {
        return CELL_WIDTH;
    }
    public double getCellHeight() {
        return CELL_HEIGHT;
    }
    public int getGridSize() {
        return GRID_SIZE;
    }
}