package studentlife.core.characters;

import java.util.HashMap;
import java.util.Map;

import static studentlife.Config.*;

//gere les stats perso de l'utilisateur, comme la fatigue, faim, attention..
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




    public boolean updateFatigue(String fatigue, boolean addition) {


        if(!statsMap.containsKey(fatigue)) {
            return false;
        }

        if(!statsMap.containsKey(STAT_FAIM)) {
            return false;
        }

        if(addition){
            statsMap.get(fatigue).updateValue((int)(statsMap.get(STAT_FAIM).getValue() * statsMap.get(fatigue).getPrcnt()));
        }else{
            statsMap.get(fatigue).updateValue((int)(statsMap.get(STAT_FAIM).getValue() * statsMap.get(fatigue).getPrcnt() * -1));
        }

        return true;
    }


    public boolean updateAttention(String attention){

        if(!statsMap.containsKey(attention)) {
            return false;
        }

        if(!statsMap.containsKey(STAT_FATIGUE)) {
            return false;
        }

        statsMap.get(attention).updateValue(statsMap.get(attention).getMaxStat() - statsMap.get(STAT_FATIGUE).getValue());
        return true;
    }


    public Stat getStat(String statName) throws IllegalArgumentException {

        if(!statsMap.containsKey(statName))
            throw new IllegalArgumentException("Cette statistique n'existe pas: " + statName);

        return statsMap.get(statName);
    }



    //ajoute une nouvelle stat
    public void setStat(String statName, int value) {
        statsMap.put(statName, new Stat(statName, value));
    }


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
