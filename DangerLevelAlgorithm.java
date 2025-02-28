package fft.kms;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//This is the algorithm to calculate on a 10-point scale
//Spike Activity 4
//This algorithm will be implented in the system

public class DangerLevelAlgorithm {
    public static void main (String[] args){

    // Method to generate Colors on grid based on Alorithm
    public Color[][] generateColorGrid(List<int[]> fireSources, double[][] temperatureGrid, double windSpeed) {
    Color[][] colorGrid = new Color[16][16];
    final double MAX_TEMP = 100.0; // This is the Normalization factor for temperature (optionally, we can simply use 100 directly)
    
    //For every grid in the map
    for (int i = 0; i < 16; i++) {
        for (int j = 0; j < 16; j++) {
            // Calculate minimum distance to any fire source
            double minDistance = Double.MAX_VALUE;
            for (int[] fire : fireSources) {
                double distance = Math.sqrt(Math.pow(i - fire[0], 2) + Math.pow(j - fire[1], 2));
                if (distance < minDistance) minDistance = distance; //Will identify the grids that are closest to a fire
            }

            // Normalize temperature (0 to 1)
            double tempContribution = temperatureGrid[i][j] / MAX_TEMP;

            // Calculate value based on Distance. (if grid is closer to fire = higher value)
            double distanceContribution = 1.0 / (minDistance + 1.0); // I put minDistance + 1 to avoid division by zero

            // Calcualte value caused by wind (e.g., if windspeed is 5, then we multiply by 1.5x)
            //However, this does not take direction of wind into account. I felt that direction would make it more tedious
            double windMultiplier = 1.0 + (windSpeed / 10.0);

            // Calculate total intensity based on previous factors
            double intensity = (tempContribution + distanceContribution) * windMultiplier;
            intensity = Math.max(0, Math.min(intensity, 1.0));

            // Assign color based on intensity
            //We can modify the colors later, this is just filler code
            if (intensity < 0.33) {
                colorGrid[i][j] = Color.GREEN;
            } else if (intensity < 0.66) {
                colorGrid[i][j] = Color.YELLOW;
            } else {
                colorGrid[i][j] = Color.RED;
            }
        }
    }
    return colorGrid;
}
}

}
