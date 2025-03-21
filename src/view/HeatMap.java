package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import data.WeatherDataLoader;
import util.ClickHandler;

public class HeatMap {
    private final Pane pane = new Pane();
    private final HeatMapGrid heatMapGrid;

    public HeatMap(WeatherDataLoader dataLoader, ClickHandler clickHandler) {
        if (dataLoader.getMapImage() != null) {
            ImageView imageView = new ImageView(dataLoader.getMapImage());
            imageView.setFitWidth(500);
            imageView.setFitHeight(500);
            pane.getChildren().add(imageView);
        }
        heatMapGrid = new HeatMapGrid(dataLoader, clickHandler);
        pane.getChildren().addAll(heatMapGrid.getCells());
        pane.setMinSize(500, 500);
    }

    public void updateHeatMap(int hour) {
        heatMapGrid.updateGrid(hour);
    }

    public Pane getPane() {
        return pane;
    }
}