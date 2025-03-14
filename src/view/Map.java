package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Map {
    private static final int IMAGE_WIDTH = 500;
    private static final int IMAGE_HEIGHT = 500;
    private final Pane pane;
    private final MapGrid mapGrid;
    public Map() {
        this.pane = new Pane();
        this.pane.setPrefSize(IMAGE_WIDTH, IMAGE_HEIGHT);
        loadMapImage();
        this.mapGrid = new MapGrid();
        this.pane.getChildren().addAll(mapGrid.getCells());
    }
    private void loadMapImage() {
        Image mapImage;
        try {
            mapImage = new Image(getClass().getResourceAsStream("/resources/map.png"));
        } catch (Exception e) {
            System.out.println("Error loading map.png: " + e.getMessage());

            mapImage = new Image(" ");
        }
        ImageView imageView = new ImageView(mapImage);
        imageView.setFitWidth(IMAGE_WIDTH);
        imageView.setFitHeight(IMAGE_HEIGHT);
        pane.getChildren().add(imageView);
    }
    public Pane getPane() {
        return pane;
    }
}