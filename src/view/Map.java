package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import data.WeatherDataLoader;
import util.ClickHandler;

public class Map {
    private final Pane pane = new Pane();
    private final MapGrid mapGrid;

    public Map(ClickHandler clickHandler, WeatherDataLoader weatherDataLoader) {
        if (weatherDataLoader.getMapImage() != null) {
            ImageView imageView = new ImageView(weatherDataLoader.getMapImage());
            imageView.setFitWidth(500);
            imageView.setFitHeight(500);
            pane.getChildren().add(imageView);
        } else {
            pane.setStyle("-fx-background-color: lightgray;");
        }
        mapGrid = new MapGrid(clickHandler);
        pane.getChildren().addAll(mapGrid.getCells());
    }

    public Pane getPane() {
        return pane;
    }
}
