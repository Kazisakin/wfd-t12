package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import models.WeatherData;
import java.util.List;

public class Dashboard {
    private final VBox root = new VBox(10);
    private final VBox riskBox = new VBox(5);

    private final Label loc = new Label("Location: N/A");
    private final Label temp = new Label("Temp: N/A");
    private final Label wind = new Label("Wind: N/A");
    private final Label humid = new Label("Humidity: N/A");
    private final Label dry = new Label("Dryness: N/A");

    public Dashboard() {
        root.setPadding(new Insets(10));

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(5);

        Label tempLabel = new Label("Temp:");
        Label windLabel = new Label("Wind:");
        Label humidLabel = new Label("Humidity:");
        Label dryLabel = new Label("Dryness:");

        grid.addRow(0, tempLabel, temp);
        grid.addRow(1, windLabel, wind);
        grid.addRow(2, humidLabel, humid);
        grid.addRow(3, dryLabel, dry);

        root.getChildren().addAll(
                new Label("Location"), loc,
                new Label("Weather"), grid,
                new Label("Risk"), riskBox
        );
    }

    public void updateDashboard(String location, WeatherData data, List<String> strategies) {
        loc.setText(location);
        temp.setText("Temp: " + data.getTemperature() + "°C");
        wind.setText("Wind: " + data.getWindSpeed() + " m/s");
        humid.setText("Humidity: " + data.getHumidity() + "%");
        dry.setText("Dryness: " + data.getDryness());

        riskBox.getChildren().clear();
        if (strategies != null) {
            for (String s : strategies) {
                riskBox.getChildren().add(new Label("• " + s));
            }
        } else {
            riskBox.getChildren().add(new Label("No strategies available"));
        }
    }

    public VBox getPane() {
        return root;
    }
}
