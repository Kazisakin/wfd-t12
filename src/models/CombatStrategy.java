package models;

import java.util.List;

public class CombatStrategy {
    private final String dangerLevel;
    private final List<String> strategies;

    public CombatStrategy(String dangerLevel, List<String> strategies) {
        this.dangerLevel = dangerLevel.toUpperCase();
        this.strategies = strategies;
    }

    public String getDangerLevel() {
        return dangerLevel;
    }

    public List<String> getStrategies() {
        return strategies;
    }
}
