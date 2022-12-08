/**
 * Contient les classes des different personnages de la simu ;
  Etudiant, Personne, Professeur, Stat et StatsManager
 * */
package studentlife.core.characters;

import static studentlife.Config.*;
/**
 *  La classe Etudiant représente un etudiant/utilisateur qui est une personne.
 Cette classe est une sous-classe de la classe Personne qui possède des statistiques.
 Ces stats, seront tout au long de la simulation, modifiées selon les choix que l'utilisateur.
 Les statistiques personnelles sont composés de la faim, la fatigue, l'attention.
 * @see Personne
 * */
public class Etudiant extends Personne {

    /** les stats personnelles de l'étudiant */
    private StatsManager stats;

    /**
     * @param nom nom de l'étudiant (utilisateur)
     * @param prenom prénom de l'étudiant (utilisateur)
     * constructeur d'un Etudiant
     * */
    public Etudiant(String nom, String prenom) {
        super(nom, prenom);
        initStats();
    }

    /**
     * @return ce getter permet d'accéder à l'attribut stat de la classe
     * */
    public StatsManager getStats() { return stats; }


    /**permet l'affichage d'un etudiant*/
    @Override
    public String toString() {
        return this.getNom() + " " + this.getPrenom();
    }


    /**initialise le StatsManager avec les 3 stats perso*/
    private void initStats() {
        stats = new StatsManager();
        stats.setStat(STAT_ATTENTION, 100);
        stats.setStat(STAT_FATIGUE, 0);
        stats.setStat(STAT_FAIM, 0);
    }

}
