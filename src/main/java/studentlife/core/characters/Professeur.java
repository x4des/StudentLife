package studentlife.core.characters;

import static studentlife.Config.STAT_APPRECIATION;

/**
 *Un Professeur est une personne qui a une Stat appreciation.
 Cette stat est en lien avec l'utilisateur, c'est la relation/appréciation entre le professeur
 et l'étudiant. Sa valeur sera modifiée selon les choix que l'étudiant fera.
 Plus l'étudiant ira au cours d'une instance Professeur plus cette valeur augmentera
 *@see Personne
 * */
public class Professeur extends Personne {

    /** la stat appréciation du professeur*/
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
     * @return ce getter retourne un stat appréciation
     * */
    public Stat getAppreciation() { return appreciation; }

    /**
     * @return retourne un string permettant d'afficher la valeur de l'appréciation
     * */
    @Override
    public String toString() {
        return (super.toString() + ": " + this.appreciation.getValue() + "/100");
    }
}


