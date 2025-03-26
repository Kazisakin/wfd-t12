package view;

import javafx.scene.shape.Rectangle;
import data.MapImageProvider;
import util.ClickHandler;
import java.util.Arrays;

public class RegularMap extends Map {
    private final MapGrid mapGrid;

    public RegularMap(ClickHandler clickHandler, MapImageProvider imageProvider) {
        super(clickHandler, imageProvider);
        this.mapGrid = new MapGrid(clickHandler);
        pane.getChildren().addAll(Arrays.asList(mapGrid.getCells()));
    }

    protected Rectangle[] getGridCells() {
        return mapGrid.getCells();
    }
}