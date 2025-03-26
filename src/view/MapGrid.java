package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import util.ClickHandler;

public class MapGrid {
    private final GridManager gm;
    private final Rectangle[] cells;
    private final ClickHandler ch;
    private final int gridSize;
    private final double cellWidth, cellHeight;
    private final double baseLat = 40.7128, baseLon = -74.0060, latStep = 0.1, lonStep = 0.1;

    public MapGrid(ClickHandler ch) {
        this.ch = ch;
        this.gm = new GridManager();
        this.gridSize = gm.getGridSize();
        this.cellWidth = gm.getCellWidth();
        this.cellHeight = gm.getCellHeight();
        this.cells = new Rectangle[gridSize * gridSize];
        makeGrid();
    }

    public Rectangle[] getCells() {
        return cells;
    }

    private void makeGrid() {
        for (int r = 0; r < gridSize; r++) {
            for (int c = 0; c < gridSize; c++) {
                cells[getIndex(r, c)] = makeCell(r, c);
            }
        }
    }

    private Rectangle makeCell(int r, int c) {
        Rectangle cell = new Rectangle(c * cellWidth, r * cellHeight, cellWidth, cellHeight);
        cell.setFill(Color.TRANSPARENT);
        cell.setStroke(Color.BLACK);
        double lat = baseLat + (r * latStep);
        double lon = baseLon + (c * lonStep);
        cell.setOnMouseClicked(e -> cellClick(r, c, lat, lon));
        return cell;
    }

    private void cellClick(int r, int c, double lat, double lon) {
        if (ch != null) ch.onCellClicked(r, c, lat, lon);
    }

    private int getIndex(int r, int c) {
        return r * gridSize + c;
    }
}