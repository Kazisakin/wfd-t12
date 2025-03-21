package models;

public class WeatherData {
    private final int row;
    private final int col;
    private final int hour;
    private final double temperature;
    private final double windSpeed;
    private final double humidity;
    private final double dryness;

    public WeatherData(int row, int col, int hour, double temperature, double windSpeed, double humidity, double dryness) {
        if (row < 0 || col < 0 || hour < 0) {
            throw new IllegalArgumentException("Row, col, and hour must be non-negative");
        }
        this.row = row;
        this.col = col;
        this.hour = hour;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.dryness = dryness;
    
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public int getHour() {
        return hour;
    }
    public double getTemperature() {
        return temperature;
    }
    public double getWindSpeed() {
        return windSpeed;
    }
    public double getHumidity() {
        return humidity;
    }
    public double getDryness() {
        return dryness;
    }
}
