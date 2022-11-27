package studentlife.characters;

import static studentlife.Config.*;

public class Etudiant extends Personne {

    private StatsManager stats;

    public Etudiant(String nom, String prenom) {
        super(nom, prenom);

        initStats();
    }

    public StatsManager getStats() { return stats; }

    private void initStats() {

        stats = new StatsManager();
        stats.setStat(STAT_CONCENTRATION, 100);
        stats.setStat(STAT_FATIGUE, 25);
    }

    @Override
    public String toString() {

        return "FullName: " + this.getNom() + " " + this.getPrenom() + "\nStats: " + this.stats.toString();
    }
}
