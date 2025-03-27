package data;

import models.WeatherMetrics;

public interface WeatherDataProvider {
    WeatherMetrics getWeatherData(int row, int col, int hour);
}