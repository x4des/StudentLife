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
     * Cette méthode ajoute ou soustrait une valeur à la valeur actuelle d'une Stat.
     * On vérifie d'abord si la Stat est bien présente dans la HashMap
     * @param statName nom de la stat
     * @param value valeur qu'on veut ajouter
     * @return true si la Stat était présente dans la Hashmap, false sinon
     * @see Stat#updateValue(int)
     * */
    public boolean updateStat(String statName, int value) {
        if(!statsMap.containsKey(statName)) { //si n'est pas présente
            return false;
        }

        statsMap.get(statName).updateValue(value);
            return true;
    }


    /**
     * Méthode qui modifie la valeur la fatigue de l'étudiant.
     * Dans notre jeu à chaque fois que la faim augmente, la fatigue augmente de 0.45*faim.
     * Même logique dans les cas où la fatigue diminue.
     * @param fatigue pour cibler la fatigue dans le StatManager de l'étudiant
     * @param addition Un booléen qui nous indique si l'opération à faire est
     une addition ou une soustraction.
     * @return true si la Stat était présente dans la Hashmap, false sinon
     * */
    public boolean updateFatigue(String fatigue, boolean addition) {

        if(!statsMap.containsKey(fatigue)) { //si n'est pas présente
            return false;
        }

        if(!statsMap.containsKey(STAT_FAIM)) { //si n'est pas présente
            return false;
        }

        if(addition){
            statsMap.get(fatigue).updateValue((int)(statsMap.get(STAT_FAIM).getValue() * statsMap.get(fatigue).getPrcnt()));
        }else{
            statsMap.get(fatigue).updateValue((int)(statsMap.get(STAT_FAIM).getValue() * statsMap.get(fatigue).getPrcnt() * -1)); // *-1 car soustraction
        }

        return true;
    }


    /**
     * Méthode qui modifie la valeur l'attention de l'étudiant.
     * Dans notre jeu l'attention est proportionnelle avec la fatigue. = seuil max - fatigue
     * Si la fatigue augmente, alors l'attention diminue.
     * @param attention pour cibler l'attention dans le StatManager de l'étudiant
     * @return true si la Stat était présente dans la Hashmap, false sinon
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
     * ce getter permet d'avoir une Stat
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
     * ajoute une nouvelle Stat dans la HashMap
     * @param statName le nom de la Stat que l'on veut ajouter
     * @param value la valeur que l'on veut affecter à la stat
     * */
    public void setStat(String statName, int value) {
        statsMap.put(statName, new Stat(statName, value));
    }

    /**
     * Retourne les informations concernant chaque Stat de StatManager
     * @return retourne un String qui permettra d'afficher les informations de StatManager
     * */
    @Override
    public String toString() {

        StringBuilder temp = new StringBuilder(); //un constructeur d'une chaine de caractères

        for(Map.Entry<String, Stat> entry : statsMap.entrySet()) { //pour chaque stat
            String key = entry.getKey(); //nom de la stat
            int value = entry.getValue().getValue(); //on accède à Value (Stat) puis à Value( valeur de Stat )

            temp.append(key).append("=").append(value).append(" "); //on construit la chaine
        }

        return temp.toString();
    }
}
