package studentlife.core.characters;

import static studentlife.Config.STAT_APPRECIATION;

/**
 *un Professeur est une personne
 qui a une Stat appreciation. Cette stat est en lien avec l'utilisateur, c'est la relation/L'appreciation entre le professeur
 et l'etudiant. Sa valeur sera modifier selon les choix que l'etudiant fera
 plus l'etudiant ira en cours plus cette valeure augmentera
 *@see Personne.java
 * */
public class Professeur extends Personne {

    private final Stat appreciation;
    /**
     * @param nom
     * @param prenom
     * le constructeur de professeur
     * */
    public Professeur(String nom, String prenom){
        super(nom, prenom);

        this.appreciation = new Stat(STAT_APPRECIATION, 50);
    }
    /**
     * @return ce getter retourne un stat appreciation
     * */
    public Stat getAppreciation() { return appreciation; }

    /**
     * @return retourne un string permettant d'afficher la valeure de l'appreciation
     * */
    @Override
    public String toString() {
        return (super.toString() + ": " + this.appreciation.getValue() + "/100");
    }
}


