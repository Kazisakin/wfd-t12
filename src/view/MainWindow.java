package view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import util.ClickHandler;
import data.WeatherDataLoader;
import models.WeatherData;
import models.Location;

public class MainWindow {
    private final BorderPane root = new BorderPane();
    private final Map map;
    private final Dashboard dashboard;
    private final WeatherDataLoader dataLoader;

    public MainWindow() {
        root.setPadding(new Insets(10));
        dataLoader = new WeatherDataLoader();
        map = new Map(this::handleCellClick, dataLoader);
        dashboard = new Dashboard();
        root.setCenter(new VBox(10, map.getPane(), dashboard.getPane()));
    }

    private void handleCellClick(int row, int col, double lat, double lon) {
        WeatherData weather = dataLoader.getWeatherData(row, col, row % 24);
        Location loc = new Location("Fredericton", lat, lon, weather);
        dashboard.updateDashboard(loc.getLocationSummary(), weather, loc.getCombatStrategies());
    }

    public BorderPane getRoot() {
        return root;
    }
}
