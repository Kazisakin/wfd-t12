package view;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class TimeSlider {
    private final VBox pane = new VBox();
    private final Slider slider = new Slider(0, 23, 0);

    public TimeSlider(HeatMap heatMap, HourUpdater updater) {
        Label label = new Label("Hour: 0");
        slider.valueProperty().addListener((obs, old, newVal) -> {
            int hour = newVal.intValue();
            label.setText("Hour: " + hour);
            heatMap.updateHeatMap(hour);
            updater.updateHour(hour);
        });

        pane.getChildren().addAll(label, slider);
    }

    public VBox getPane() {
        return pane;
    }

    public interface HourUpdater {
        void updateHour(int hour);
    }
}
