package data;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CombatStrategyLoaderTest {
    @Test
    public void testLoadValidStrategies() {
        CombatStrategyLoader loader = new CombatStrategyLoader();
        List<String> strategies = loader.getCombatStrategy("LOW");
        assertFalse(strategies.isEmpty());
    }

    @Test
    public void testInvalidDangerLevel() {
        CombatStrategyLoader loader = new CombatStrategyLoader();
        List<String> strategies = loader.getCombatStrategy("BAD");
        assertTrue(strategies.isEmpty());
    }

    @Test
    public void testEmptyDangerLevel() {
        CombatStrategyLoader loader = new CombatStrategyLoader();
        List<String> strategies = loader.getCombatStrategy("");
        assertTrue(strategies.isEmpty());
    }

    @Test
    public void testCaseSensitivity() {
        CombatStrategyLoader loader = new CombatStrategyLoader();
        List<String> strategies = loader.getCombatStrategy("low");
        assertFalse(strategies.isEmpty());
    }
}
