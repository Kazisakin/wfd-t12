package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import data.WeatherDataLoader;
import models.DangerLevel;
import models.WeatherData;
import util.ClickHandler;

public class HeatMapGrid {
    private static final int GRID_SIZE = 16;
    private static final double CELL_SIZE = 500.0 / GRID_SIZE;
    private final Rectangle[] cells = new Rectangle[GRID_SIZE * GRID_SIZE];
    private final WeatherDataLoader dataLoader;
    private final ClickHandler clickHandler;

    public HeatMapGrid(WeatherDataLoader dataLoader, ClickHandler clickHandler) {
        this.dataLoader = dataLoader;
        this.clickHandler = clickHandler;
        createGrid();
    }

    public Rectangle[] getCells() {
        return cells;
    }

    public void updateGrid(int hour) {
        for (int i = 0; i < cells.length; i++) {
            int row = i / GRID_SIZE, col = i % GRID_SIZE;
            WeatherData data = dataLoader.getWeatherData(row, col, hour);
            cells[i].setFill(getColor(DangerLevel.getDangerLevel(DangerLevel.calculateThreatScore(
                    data.getTemperature(), data.getWindSpeed(), data.getHumidity(), data.getDryness()))));
        }
    }
    
    

    private void createGrid() {
        for (int i = 0; i < cells.length; i++) {
            int row = i / GRID_SIZE, col = i % GRID_SIZE;
            Rectangle cell = new Rectangle(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            cell.setStroke(Color.BLACK);
            cell.setOpacity(0.5);
            cell.setOnMouseClicked(e -> clickHandler.onCellClicked(row, col, 40.7128 + row * 0.1, -74.0060 + col * 0.1));
            cells[i] = cell;
        }
        updateGrid(0);
    }

    private Color getColor(String level) {
        return switch (level) {
            case "LOW" -> Color.GREEN;
            case "MODERATE" -> Color.YELLOW;
            case "HIGH" -> Color.ORANGE;
            case "EXTREME" -> Color.RED;
            default -> Color.GRAY;
        };
    }
}
