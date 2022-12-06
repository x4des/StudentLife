/**
 * Contient les classes des differents personnages de la simu;
  Etudiant, Personne, Professeur, Stat et StatsManager
 * */
package studentlife.core.characters;

import static studentlife.Config.*;
/**
 *  la classe Etudiant represente un etudiant/utilisateur qui est une personne.
 Cette classe descend de la classe Personne
 qui possède des stats. Ses stats, seront tout au long de la simulation, modifier
 selon les choix que l'utilisateur. Ses statistiques personnelles sont composés de
 la faim, la fatigue, l'attention.
 * @see Personne
 * */
public class Etudiant extends Personne {

    private StatsManager stats;

    /**
     * @param nom
     * @param prenom
     * constructeur d'un Etudiant
     * */
    public Etudiant(String nom, String prenom) {
        super(nom, prenom);
        initStats();
    }

    /**
     * @return ce getter permet d'acceder à l'attribut stat de la classe
     * */
    public StatsManager getStats() { return stats; }


    // permet l'affichage d'un etudiant
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
