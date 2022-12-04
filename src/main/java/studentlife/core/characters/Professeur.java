package studentlife.core.characters;

import static studentlife.Config.STAT_APPRECIATION;

public class Professeur extends Personne {

    private final Stat appreciation;

    public Professeur(String nom, String prenom){
        super(nom, prenom);

        this.appreciation = new Stat(STAT_APPRECIATION, 50);
    }

    public Stat getAppreciation() { return appreciation; }

    @Override
    public String toString() {
        return (super.toString() + ": " + this.appreciation.getValue() + "/100");
    }
}


