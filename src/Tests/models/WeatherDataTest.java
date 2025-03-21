package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeatherDataTest {

    @Test
    void testWeatherData() {
        WeatherData weatherData = new WeatherData(5, 7, 12, 22.5, 15.3, 65.2, 30.8);

        assertAll(
            "WeatherData getters should return correct values",
            () -> assertEquals(5, weatherData.getRow()),
            () -> assertEquals(7, weatherData.getCol()),
            () -> assertEquals(12, weatherData.getHour()),
            () -> assertEquals(22.5, weatherData.getTemperature(), 0.001),
            () -> assertEquals(15.3, weatherData.getWindSpeed(), 0.001),
            () -> assertEquals(65.2, weatherData.getHumidity(), 0.001),
            () -> assertEquals(30.8, weatherData.getDryness(), 0.001)
        );
    }

    @Test
    void testInvalidValues() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new WeatherData(-1, 7, 12, 22.5, 15.3, 65.2, 30.8)
        );
        assertEquals("Row, col, and hour must be non-negative", exception.getMessage());
    }
}
