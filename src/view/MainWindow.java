package view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import data.MapImageProvider;
import data.WeatherDataLoader;
import data.WeatherDataProvider;
import util.ClickHandler;
import models.WeatherMetrics;
import models.Location;

public class MainWindow {
    private final BorderPane root = new BorderPane();
    private final RegularMap map;
    private final HeatMap heatMap;
    private final Dashboard dashboard;
    private final WeatherDataProvider dataProvider;
    private final MapImageProvider imageProvider;
    private final TimeSlider timeSlider;
    private int currentHour = 0;

    public MainWindow() {
        root.setPadding(new Insets(10));
        WeatherDataLoader dataLoader = new WeatherDataLoader();
        dataProvider = dataLoader;
        imageProvider = dataLoader;
        map = new RegularMap(this::handleCellClick, imageProvider);
        heatMap = new HeatMap(imageProvider, dataProvider, this::handleCellClick);
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
        WeatherMetrics weather = dataProvider.getWeatherData(row, col, hour);
        Location loc = new Location("Fredericton", lat, lon, weather);
        dashboard.updateDashboard(loc.getLocationSummary(), weather, loc.getCombatStrategies());
    }

    public BorderPane getRoot() {
        return root;
    }
}