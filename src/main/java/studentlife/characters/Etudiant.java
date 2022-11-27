package studentlife.characters;

import studentlife.Schedule;

public class Etudiant extends Personne {

    private StatsManager stats;

    public Etudiant(String nom, String prenom) {
        super(nom, prenom);

        this.stats = new StatsManager();
    }
}
