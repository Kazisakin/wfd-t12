package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import data.MapImageProvider;
import util.ClickHandler;

public abstract class Map {
    protected final Pane pane = new Pane();
    protected final ClickHandler clickHandler;

    public Map(ClickHandler clickHandler, MapImageProvider imageProvider) {
        this.clickHandler = clickHandler;
        if (imageProvider.getMapImage() != null) {
            ImageView imageView = new ImageView(imageProvider.getMapImage());
            imageView.setFitWidth(500);
            imageView.setFitHeight(500);
            pane.getChildren().add(imageView);
        } else {
            pane.setStyle("-fx-background-color: lightgray;");
        }

    }

    public Pane getPane() {
        return pane;
    }
}