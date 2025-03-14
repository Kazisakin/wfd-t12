package view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class MainWindow {
    private final BorderPane root;
    private final Map map;

    public MainWindow() {
        root = new BorderPane();
        root.setPadding(new Insets(10));

        map = new Map();

        root.setCenter(map.getPane());
    }
    public BorderPane getRoot() {
        return root;
    }
}