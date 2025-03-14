package models;

public class DangerLevel {
    public static double calculateThreatScore(double temperature, double windSpeed, double humidity, double dryness) {
        double tempContribution = temperature / 100.0;
        double windContribution = windSpeed / 10.0;
        double drynessContribution = dryness / 10.0;
        double humidityContribution = (100 - humidity) / 100.0;

        return (tempContribution + windContribution + drynessContribution + humidityContribution) / 4.0 * 10;
    }
    public static String getDangerLevel(double threatScore) {
        if (threatScore < 3)
            return "LOW";
        else if (threatScore < 6)
            return "MODERATE";
        else if (threatScore < 8)
            return "HIGH";
        else
            return "EXTREME";
    }
}