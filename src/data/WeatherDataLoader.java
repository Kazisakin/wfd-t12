package data;

import javafx.scene.image.Image;
import models.WeatherData;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WeatherDataLoader {
    private final List<WeatherData> weatherList = new ArrayList<>();
    private Image mapPic;

    public WeatherDataLoader() {
        readWeatherData();
        readMapImage();
    }

    private void readWeatherData() {
        try (BufferedReader file = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("weather_data.csv")))) {
            file.readLine();

            for (String line; (line = file.readLine()) != null; ) {
                String[] data = line.split(",");
                if (data.length < 7) continue;

                try {
                    int rowNum = Integer.parseInt(data[0].trim());
                    int colNum = Integer.parseInt(data[1].trim());
                    int hourNum = Integer.parseInt(data[2].trim());
                    double tempNum = Double.parseDouble(data[3].trim());
                    double windNum = Double.parseDouble(data[4].trim());
                    double humidNum = Double.parseDouble(data[5].trim());
                    double dryNum = Double.parseDouble(data[6].trim());

                    weatherList.add(new WeatherData(rowNum, colNum, hourNum, tempNum, windNum, humidNum, dryNum));
                } catch (NumberFormatException ignored) {}
            }
        } catch (Exception e) {
            System.err.println("Error reading weather data");
        }

        if (weatherList.isEmpty()) {
            weatherList.add(new WeatherData(0, 0, 0, -1, -1, -1, -1));
        }
    }

    private void readMapImage() {
        try {
            mapPic = new Image(getClass().getResourceAsStream("map.png"));
        } catch (Exception e) {
            System.err.println("Map image not found");
            mapPic = null;
        }
    }

    public WeatherData getWeatherData(int row, int col, int hour) {
        for (WeatherData info : weatherList) {
            if (info.getRow() == row && info.getCol() == col && info.getHour() == hour) {
                return info;
            }
        }
        return new WeatherData(0, 0, 0, -1, -1, -1, -1);
    }

    public Image getMapImage() {
        return mapPic;
    }
}
