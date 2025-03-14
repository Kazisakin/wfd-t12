package models;

import data.CombatStrategyLoader;
import java.util.List;

public class Location {
    private String city;
    private double latitude;
    private double longitude;
    private String dangerLevel;
    private String combatStrategy;
    private final List<String> combatStrategies;

    public Location(String city, double latitude, double longitude, WeatherData weatherData) {
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        double threatScore = DangerLevel.calculateThreatScore(
                weatherData.getTemperature(),
                weatherData.getWindSpeed(),
                weatherData.getHumidity(),
                weatherData.getDryness()
        );
        dangerLevel = DangerLevel.getDangerLevel(threatScore);
        combatStrategies = new CombatStrategyLoader().getCombatStrategy(dangerLevel);
    }

    public String getLocationSummary() {
        return city + " (" + latitude + ", " + longitude + ") - " + dangerLevel + " Threat";
    }

    public List<String> getCombatStrategies() {
        return combatStrategies;
    }
}