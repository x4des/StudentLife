package studentlife.core.characters;

import static studentlife.core.Config.STAT_APPRECIATION;

public class Professeur extends Personne {

    private final Stat appreciation;

    public Professeur(String nom, String prenom){
        super(nom, prenom);

        this.appreciation = new Stat(STAT_APPRECIATION, 75);
    }

    public Stat getAppreciation() { return appreciation; }
}
