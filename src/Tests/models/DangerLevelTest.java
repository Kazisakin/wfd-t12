package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DangerLevelTest {

    @Test
    public void testCalculateThreatScore() {
       
        double temperature = 20.0; 
        double windSpeed = 10.0;  
        double humidity = 50.0;   
        double dryness = 3.0;     

        double threatScore = DangerLevel.calculateThreatScore(temperature, windSpeed, humidity, dryness);
        assertEquals(5.0, threatScore, 0.1, "Threat score should be calculated correctly");
    }

    @Test
    public void testGetDangerLevel() {
      
        assertEquals("LOW", DangerLevel.getDangerLevel(2.0), "Danger level should be LOW");

       
        assertEquals("MODERATE", DangerLevel.getDangerLevel(5.0), "Danger level should be MODERATE");

        
        assertEquals("HIGH", DangerLevel.getDangerLevel(7.5), "Danger level should be HIGH");

       
        assertEquals("EXTREME", DangerLevel.getDangerLevel(9.0), "Danger level should be EXTREME");
    }

    @Test
    public void testNegativeValues() {
        
        double temperature = -10.0; 
        double windSpeed = -5.0;    
        double humidity = -10.0;    
        double dryness = -5.0;      

        double threatScore = DangerLevel.calculateThreatScore(temperature, windSpeed, humidity, dryness);
        assertTrue(threatScore >= 0, "Threat score should not be negative");

     
        assertNotEquals(-1.0, threatScore, "Threat score should not be negative");
    }

    @Test
    public void testExtremeBoundary() {
        
        double temperature = 59.0;  
        double windSpeed = 20.0;    
        double humidity = 9.0;       
        double dryness = 5.0;       

        double threatScore = DangerLevel.calculateThreatScore(temperature, windSpeed, humidity, dryness);
        assertTrue(threatScore >= 9.0 && threatScore <= 10.0, "Threat score should be between 9 and 10 for extreme boundary");

       
        temperature = 40.0;  
        windSpeed = 20.0;    
        humidity = 60.0;     
        dryness = 5.0;       

        threatScore = DangerLevel.calculateThreatScore(temperature, windSpeed, humidity, dryness);
        assertTrue(threatScore >= 8.0 && threatScore < 9.0, "Threat score should be between 8 and 9 for high boundary");
    }
}
