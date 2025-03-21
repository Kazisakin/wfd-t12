package data;

import models.WeatherData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherDataLoaderTest {

    @Test
    public void testValidWeatherData() {
        WeatherDataLoader loader = new WeatherDataLoader();
        WeatherData data = loader.getWeatherData(1, 1, 12);
        assertTrue(data.getTemperature() >  -1);
    }

    @Test
    public void testNonExistantCoorsdinates() {
        WeatherDataLoader loader = new WeatherDataLoader();
        WeatherData data = loader.getWeatherData(999, 999, 999);
        assertAll("Default values for missing data",
                () -> assertEquals(-1, data.getTemperature()),
                () -> assertEquals(-1, data.getWindSpeed())
        );
    }

    @Test
    public void testWeatherDataForEmptyCSV() {
        WeatherDataLoader loader = new WeatherDataLoader();
        WeatherData data = loader.getWeatherData(0, 0, 0);
        assertTrue(data.getTemperature() < 100);
    }

    @Test
    public void testBoundaryHour() {
        WeatherDataLoader loader = new WeatherDataLoader();
        WeatherData data = loader.getWeatherData(0, 0, 23);
        assertTrue(data.getTemperature() > -1);
    }
}
