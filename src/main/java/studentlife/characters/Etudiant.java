package studentlife.characters;

import studentlife.Schedule;

public class Etudiant extends Personne {

    private StatsManager stats;
    private Schedule edt;

    public Etudiant(String nom, String prenom, Schedule edt) {
        super(nom, prenom);

        this.stats = new StatsManager();
        this.edt = edt;
    }
}
