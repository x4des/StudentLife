package studentlife.core.characters;

import static studentlife.Config.STAT_APPRECIATION;

/**
 *Un Professeur est une personne qui a une Stat appreciation.
 Cette stat est en lien avec l'utilisateur, c'est la relation/appreciation entre le professeur
 et l'étudiant. Sa valeur sera modifier selon les choix que l'étudiant fera.
 Plus l'étudiant ira en cours plus cette valeur augmentera
 *@see Personne
 * */
public class Professeur extends Personne {

    /** la stat appreciation du professeur*/
    private final Stat appreciation;

    /**
     * @param nom nom du professeur
     * @param prenom prénom du professeur
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


