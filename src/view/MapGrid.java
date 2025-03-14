package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapGrid {
    private final GridManager gridManager;
    private final Rectangle[] cells;

    public MapGrid() {
        this.gridManager = new GridManager();
        this.cells = new Rectangle[gridManager.getGridSize() * gridManager.getGridSize()];
        createGrid();
    }
    public Rectangle[] getCells() {
        return cells;
    }
    private void createGrid() {
        int gridSize = gridManager.getGridSize();
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int index = row * gridSize + col;
                Rectangle cell = new Rectangle(
                        col * gridManager.getCellWidth(),
                        row * gridManager.getCellHeight(),
                        gridManager.getCellWidth(),
                        gridManager.getCellHeight()
                );
                cell.setFill(Color.TRANSPARENT);
                cell.setStroke(Color.BLACK);
                cells[index] = cell;
            }
        }
    }
}