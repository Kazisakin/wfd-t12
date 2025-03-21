package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {

    @Test
    public void testExtremeThreatLevel() {
        WeatherData data = new WeatherData(0, 0, 0, 50.0, 20.0, 10.0, 60.0);
        Location calgaryTest = new Location("Calgary", 51.0, -114.1, data);
        String result = calgaryTest.getLocationSummary();
        assertEquals("Calgary (51.0, -114.1) - EXTREME Threat", result);
    }

    @Test
    public void testLocationSummaryHighThreat() {
        WeatherData weatherData = new WeatherData(0, 0, 0, 10.0, 5.0, 80.0, 20.0);
        Location vancouver = new Location("Vancouver", 49.3, -123.1, weatherData);
        assertEquals("Vancouver (49.3, -123.1) - HIGH Threat", vancouver.getLocationSummary());
    }

    @Test
    public void testLocationWithNullWeather() {
        assertThrows(NullPointerException.class, () -> {
            Location torontoTest = new Location("Toronto", 43.7, -79.4, null);
            torontoTest.getLocationSummary();
        }, "Expected NullPointerException when weather data is null");
    }

    @Test
    public void testModerateThreatLevel() {
        WeatherData wd = new WeatherData(0, 0, 0, 5.0, 2.0, 90.0, 10.0);
        Location freddy = new Location("Fredericton", 45.9, -66.6, wd);
        String summary = freddy.getLocationSummary();
        assertEquals("Fredericton (45.9, -66.6) - MODERATE Threat", summary);
    }

    @Test
    public void testCoordinateDisplayOnly() {
        WeatherData basicData = new WeatherData(45, -66, 0, 15.0, 8.0, 60.0, 25.0);
        Location montreal = new Location("Montreal", 45.5, -73.6, basicData);
        String cityAndCoords = montreal.getLocationSummary().split(" - ")[0];
        assertEquals("Montreal (45.5, -73.6)", cityAndCoords);
    }
}
