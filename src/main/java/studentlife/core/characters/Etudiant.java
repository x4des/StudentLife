/**
 * Contient les classes des different personnages de la simu ;
  Etudiant, Personne, Professeur, Stat et StatsManager
 * */
package studentlife.core.characters;

import static studentlife.Config.*;
/**
 * La classe Etudiant représente un étudiant/utilisateur qui est une personne.
 Cette classe est une sous-classe de la classe Personne qui possède en plus des statistiques.
 Ces stats, seront tout au long de la simulation, modifiées selon les choix que l'utilisateur.
 Les statistiques personnelles sont composés de la faim, la fatigue, l'attention.
 * @see Personne
 * */
public class Etudiant extends Personne {

    /** les stats personnelles de l'étudiant */
    private StatsManager stats;

    /**
     * constructeur d'un Etudiant
     * @param nom nom de l'étudiant (utilisateur)
     * @param prenom prénom de l'étudiant (utilisateur)
     * */
    public Etudiant(String nom, String prenom) {
        super(nom, prenom); //affecte le nom et prénom via le constructeur de la super-classe
        initStats(); //initialise les stats
    }


    /** initialise le StatsManager avec les 3 stats personnelles : fatigue, faim et attention */
    private void initStats() {
        stats = new StatsManager();
        stats.setStat(STAT_ATTENTION, 100);
        stats.setStat(STAT_FATIGUE, 0);
        stats.setStat(STAT_FAIM, 0);
    }

    /**
     * Ce getter permet d'accéder à l'attribut StatsManager de la classe
     * @return StatsManager qui contient les statistiques personnelles de l'étudiant
     * */
    public StatsManager getStats() { return stats; }




}
