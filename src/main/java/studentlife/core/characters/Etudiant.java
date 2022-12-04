package studentlife.core.characters;

import static studentlife.Config.*;

public class Etudiant extends Personne {

    private StatsManager stats;

    public Etudiant(String nom, String prenom) {
        super(nom, prenom);
        initStats();
    }

    public StatsManager getStats() { return stats; }

    @Override
    public String toString() {

        return "FullName: " + this.getNom() + " " + this.getPrenom() + "\nStats: " + this.getStats();
    }


    //initialise le StatsManager avec les 3 stats perso
    private void initStats() {
        stats = new StatsManager();
        stats.setStat(STAT_ATTENTION, 100);
        stats.setStat(STAT_FATIGUE, 0);
        stats.setStat(STAT_FAIM, 0);
    }

}
