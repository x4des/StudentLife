package studentlife.core.characters;

import java.util.HashMap;
import java.util.Map;

import static studentlife.Config.STAT_FAIM;
import static studentlife.Config.STAT_FATIGUE;

public class StatsManager {

    // Stat Name -- Val
    private final HashMap<String, Stat> statsMap = new HashMap<>();

    public StatsManager() {}


    public boolean updateStat(String statName, int value) {

        if(!statsMap.containsKey(statName))
            return false;

        statsMap.get(statName).updateValue(value);
        return true;
    }

    public boolean updateStat(Stat stat, String operator) {

        if(!statsMap.containsKey(stat))
            return false;

        //statsMap.get(stat).updateValue(stat, operator);
        return true;
    }


    public boolean updateFatigue(char operator) {


        if(!statsMap.containsKey(STAT_FATIGUE)) {
            return false;
        }

        //statsMap.get(STAT_FATIGUE).updateValue(statsMap.get(STAT_FAIM),operator); // operator = '+' ou '-' selon les modifi a faire
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
    //adds a new stat

    @Override
    public String toString() {

        StringBuilder temp = new StringBuilder();

        for(Map.Entry<String, Stat> entry : statsMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue().getValue();

            temp.append(key).append("=").append(value).append(" ");
        }

        return temp.toString();
    }
}
