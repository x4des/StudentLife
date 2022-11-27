package studentlife;

import studentlife.characters.Stat;

import static studentlife.Config.STAT_MASTERY;

public class Matiere {
    private String nomMatiere;

    private Stat mastery;

    public Matiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
        this.mastery = new Stat(STAT_MASTERY, 0);
    }

    public String getNomMatiere(){
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public Stat getMastery() { return mastery; }
}
