package models;

public class DangerLevel {
    public static double calculateThreatScore(double temperature, double windSpeed, double humidity, double dryness) {
        double tempContribution = temperature / 50.0;  // Increased divisor for lower impact
        double windContribution = windSpeed / 20.0;    // Increased divisor
        double drynessContribution = dryness / 30.0;   // Increased divisor
        double humidityContribution = (100 - humidity) / 150.0; // Reduced impact of low humidity

        return (tempContribution + windContribution + drynessContribution + humidityContribution) * 5; // Scaled to 0-10 range
    }

    public static String getDangerLevel(double threatScore) {
        if (threatScore < 3) return "LOW";
        else if (threatScore < 6) return "MODERATE";
        else if (threatScore < 8) return "HIGH";
        else return "EXTREME";
    }
}
