package view;

import javafx.scene.shape.Rectangle;
import data.MapImageProvider;
import data.WeatherDataProvider;
import util.ClickHandler;
import java.util.Arrays;

public class HeatMap extends Map {
    private final HeatMapGrid heatMapGrid;

    public HeatMap(MapImageProvider imageProvider, WeatherDataProvider dataProvider, ClickHandler clickHandler) {
        super(clickHandler, imageProvider);
        this.heatMapGrid = new HeatMapGrid(dataProvider, clickHandler);
        pane.getChildren().addAll(Arrays.asList(heatMapGrid.getCells()));
        pane.setMinSize(500, 500);
    }

    protected Rectangle[] getGridCells() { 
        return heatMapGrid.getCells();
    }

    public void updateHeatMap(int hour) {
        heatMapGrid.updateGrid(hour);
    }
}