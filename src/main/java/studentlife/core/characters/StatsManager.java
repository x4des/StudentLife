package studentlife.core.characters;

import java.util.HashMap;
import java.util.Map;

import static studentlife.Config.*;

/**
 * La classe StatManager représente les statistiques personnels d'un utilisateur
 comme la faim, la fatigue, l'attention. Elle permet également de gérer ses valeurs.
 * */

public class StatsManager {

    /**table de hachage qui stocke les valeurs par paires (nom_stat/ Stat)*/
    private final HashMap<String, Stat> statsMap = new HashMap<>();

    /**constructeur de la classe StatsManager*/
    public StatsManager() {}

    /**
     * @param statName nom de la stat
     * @param value valeur de la stat
     * @return Cette fonction vérifie d'abord si les noms des statistiques correspondent.
     Sinon la fonction retourne false. Si oui, la valeur de la statManager sera remplacé par value
     dans la fonction updateValue et la fonction retournera true.
     * @see Stat#updateValue(int)
     * */
    public boolean updateStat(String statName, int value) {

        if(!statsMap.containsKey(statName))
            return false;

        statsMap.get(statName).updateValue(value);
            return true;
    }



    /**
     * @param fatigue pour cibler la statManager fatigue de l'étudiant
     * @param addition Un booléen qui nous indique si l'opération à faire est
     une addition ou une soustraction. Si addition == false, le pourcentage devient négatif
     * @return la fonction retourne un booléen si le nom de la statManager ne concorde pas avec les stats
     et que la statManager faim n'est pas présente dans le hashmap, c'est false,
     sinon la valeur de la statManager fatigue est modifiée.
     * */
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

    /**
     * @param attention pour modifier la statManager attention de l'utilisateur
     * @return vérifie la presence de la statManager attention et fatigue dans le hashmap,
     si présente, la valeur de la statManager fatigue sera modifiée, celle-ci est
     le complémentaire de la valeur de la statManager fatigue
     * */
    public boolean updateAttention(String attention){

        if(!statsMap.containsKey(attention)) {
            return false;
        }

        if(!statsMap.containsKey(STAT_FATIGUE)) {
            return false;
        }

        statsMap.get(attention).setValue(statsMap.get(attention).getMaxStat() - statsMap.get(STAT_FATIGUE).getValue());
        return true;
    }

    /**
     * @param statName le nom d'une statistique quelconque
     * @throws IllegalArgumentException si la valeur de statName n'existe pas,
     l'exception envoie un message qui l'explique.
     @return retourne une Stat
     * */
    public Stat getStat(String statName) throws IllegalArgumentException {

        if(!statsMap.containsKey(statName))
            throw new IllegalArgumentException("Cette statistique n'existe pas: " + statName);

        return statsMap.get(statName);
    }


    /**
     * @param statName le nom de la statManager que l'on veut ajouter
     * @param value la valeur que l'on veut affecter à la stat ( nom mis en parametre)
     * ajoute une nouvelle stat au hashmap
     * */
    public void setStat(String statName, int value) {
        statsMap.put(statName, new Stat(statName, value));
    }

    /**
     * @return retourne un string qui permettra d'afficher un statManager
     * */
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
