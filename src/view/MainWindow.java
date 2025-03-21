package view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import util.ClickHandler;
import data.WeatherDataLoader;
import models.WeatherData;
import models.Location;

public class MainWindow {
    private final BorderPane root = new BorderPane();
    private final Map map;
    private final HeatMap heatMap;
    private final Dashboard dashboard;
    private final WeatherDataLoader dataLoader;
    private final TimeSlider timeSlider;
    private int currentHour = 0;

    public MainWindow() {
        root.setPadding(new Insets(10));
        dataLoader = new WeatherDataLoader();
        map = new Map(this::handleCellClick, dataLoader);
        heatMap = new HeatMap(dataLoader, this::handleCellClick);
        dashboard = new Dashboard();
        timeSlider = new TimeSlider(heatMap, hour -> currentHour = hour);

        HBox mapContainer = new HBox(10, map.getPane(), heatMap.getPane());
        mapContainer.setPrefWidth(1020);

        VBox centerPane = new VBox(10, mapContainer, timeSlider.getPane(), dashboard.getPane());
        root.setCenter(centerPane);
    }

    private void handleCellClick(int row, int col, double lat, double lon) {
        int hour = (heatMap.getPane().getParent().getChildrenUnmodifiable().contains(heatMap.getPane()))
                ? currentHour : row % 24;
        WeatherData weather = dataLoader.getWeatherData(row, col, hour);
        Location loc = new Location("Fredericton", lat, lon, weather);
        dashboard.updateDashboard(loc.getLocationSummary(), weather, loc.getCombatStrategies());
    }

    public BorderPane getRoot() {
        return root;
    }
}