package studentlife.core;

import studentlife.core.characters.Stat;

import static studentlife.Config.STAT_MASTERY;

public class Matiere {
    private final String nomMatiere;

    private Stat mastery;

    public Matiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
        this.mastery = new Stat(STAT_MASTERY, 0);
    }

    public String getNom(){
        return nomMatiere;
    }



    public Stat getMastery() { return mastery; }
}
