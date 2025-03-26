package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import models.WeatherMetrics;

import java.util.List;

public class Dashboard {
    private final VBox root = new VBox(15);

    // Location Section
    private final Label locTitle = createBoldLabel("Location", Color.DARKBLUE);
    private final Label locLabel = new Label("N/A");

    // Weather Section
    private final Label weatherTitle = createBoldLabel("Weather", Color.DARKGREEN);
    private final Label tempLabel = new Label("Temp: N/A");
    private final Label windLabel = new Label("Wind: N/A");
    private final Label humidLabel = new Label("Humidity: N/A");
    private final Label dryLabel = new Label("Dryness: N/A");

    // Combat Strategies Section
    private final Label riskTitle = createBoldLabel("Combat Strategies", Color.DARKRED);
    private final VBox riskBox = new VBox(5);

    public Dashboard() {
        // Styling
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.TOP_CENTER);

        // Location Section
        VBox locationBox = createSection(locTitle, locLabel);

        // Weather Section
        VBox weatherBox = createSection(weatherTitle, tempLabel, windLabel, humidLabel, dryLabel);

        // Combat Strategies Section
        VBox riskSection = createSection(riskTitle, riskBox);

        // Layout: Three Columns
        HBox dashboardLayout = new HBox(30, locationBox, weatherBox, riskSection);
        dashboardLayout.setAlignment(Pos.CENTER);

        // Add to root
        root.getChildren().add(dashboardLayout);
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
                Label strategyLabel = new Label("• " + s);
                strategyLabel.setTextFill(Color.DARKRED);  // Color for strategies
                riskBox.getChildren().add(strategyLabel);
            }
        } else {
            Label noStrategyLabel = new Label("No strategies available");
            noStrategyLabel.setTextFill(Color.GRAY);
            riskBox.getChildren().add(noStrategyLabel);
        }
    }

    public VBox getPane() {
        return root;
    }

    // Utility method to create sections
    private VBox createSection(Label title, javafx.scene.Node... elements) {
        VBox section = new VBox(7, title);
        section.getChildren().addAll(elements);
        section.setPadding(new Insets(10));
        section.setAlignment(Pos.TOP_LEFT);
        section.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 10px; -fx-background-color: #f4f4f4;");
        return section;
    }

    // Utility method to create bold labels with color
    private Label createBoldLabel(String text, Color color) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        label.setTextFill(color);
        return label;
    }
}
