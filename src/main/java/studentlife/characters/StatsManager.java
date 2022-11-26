package studentlife.characters;

import java.util.HashMap;

public class StatsManager {

    // Stat Name -- Val
    private final HashMap<String, Stat> statsMap = new HashMap<>();

    public StatsManager() {}

    public boolean updateStat(String statName, int value) {

        if(!statsMap.containsKey(statName))
            return false;

        statsMap.get(statName).setValue(value);
        return true;
    }

    public Stat getStat(String statName) throws IllegalArgumentException {

        if(!statsMap.containsKey(statName))
            throw new IllegalArgumentException("Cette statistique n'existe pas: " + statName);

        return statsMap.get(statName);
    }

    public void setStat(String statName, int value) {
        statsMap.put(statName, new Stat(statName, value));
    }
}
