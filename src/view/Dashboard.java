package view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import models.WeatherMetrics;

import java.util.List;

public class Dashboard {
    private final VBox root = new VBox(10);
    private final Label locTitle = new Label("Location");
    private final Label locLabel = new Label("N/A");
    private final Label weatherTitle = new Label("Weather");
    private final Label tempLabel = new Label("Temp: N/A");
    private final Label windLabel = new Label("Wind: N/A");
    private final Label humidLabel = new Label("Humidity: N/A");
    private final Label dryLabel = new Label("Dryness: N/A");
    private final Label riskTitle = new Label("Combat Strategies");
    private final VBox riskBox = new VBox(5);

    public Dashboard() {
        VBox locationBox = new VBox(locTitle, locLabel);
        VBox weatherBox = new VBox(weatherTitle, tempLabel, windLabel, humidLabel, dryLabel);
        VBox riskSection = new VBox(riskTitle, riskBox);
        root.getChildren().addAll(locationBox, weatherBox, riskSection);
    }

    public void updateDashboard(String location, WeatherMetrics data, List<String> strategies) {
        locLabel.setText(location);
        tempLabel.setText("Temp: " + data.getTemperature() + "°C");
        windLabel.setText("Wind: " + data.getWindSpeed() + " m/s");
        humidLabel.setText("Humidity: " + data.getHumidity() + "%");
        dryLabel.setText("Dryness: " + data.getDryness());
        riskBox.getChildren().clear();
        if (strategies != null && !strategies.isEmpty()) {
          
            for (String s : strategies) {
                riskBox.getChildren().add(new Label("• " + s));
            }
        } 
        else {
            riskBox.getChildren().add(new Label("No strategies available"));
        }
    }

    public VBox getPane() {
        return root;
    }
}
