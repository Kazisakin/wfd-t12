package data;

import models.CombatStrategy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CombatStrategyLoader {
    private final List<CombatStrategy> strategyList = new ArrayList<>();

    public CombatStrategyLoader() {
        loadStrategies();
    }

    private void loadStrategies() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("combat_strategies.csv")))) {

            for (String line = reader.readLine(); (line = reader.readLine()) != null; ) {
                String[] parts = line.split(",", 2);
                if (parts.length < 2) continue;

                String dangerLevel = parts[0].trim();
                String[] strategiesArray = parts[1].split(",");

                List<String> strategies = new ArrayList<>();
                for (String strategy : strategiesArray) {
                    strategy = strategy.trim();
                    if (!strategy.isEmpty()) {
                        strategies.add(strategy);
                    }
                }

                strategyList.add(new CombatStrategy(dangerLevel, strategies));
            }
        } catch (Exception e) {
            System.err.println("Error loading combat strategies: " + (e.getMessage() != null ? e.getMessage() : "File not found"));
        }
    }

    public List<String> getCombatStrategy(String dangerLevel) {
        for (CombatStrategy strategy : strategyList) {
            if (strategy.getDangerLevel().equalsIgnoreCase(dangerLevel)) {
                return strategy.getStrategies();
            }
        }
        return new ArrayList<>();
    }
}
