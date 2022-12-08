package studentlife.core.characters;

/**
  * une classe abstraite représentant une personne
 qui possède un nom et un prénom
 Une personne peut être un étudiant(utilisateur) ou un professeur
 @see Etudiant
 @see Professeur
 * */
public abstract class Personne {

    /**nom de l'utilisateur*/
    private String nom;

    /**prénom de l'utilisateur*/
    private String prenom;

    /**
     * @param nom nom de la personne
     * @param prenom prénom de la personne
     * le constructeur de la classe Personne
     * */
    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }
    /**
     * @return le getter retourne l'attribut nom d'un objet Personne
     * */
    public String getNom() {
        return this.nom;
    }

    /**
     * @return le getter retourne l'attribut prenom d'un objet Personne
     * */
    public String getPrenom() {
        return this.prenom;
    }

    /** le setter permet de modifier la valeur de l'attribut nom*/
    public void setNom(String nom) {
        this.nom = nom;
    }
    /** le setter permet de modifier la valeur de l'attribut prénom*/
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return retourne un string permettant d'afficher une personne ( son nom et prenom)
     * */
    @Override
    public String toString(){
        return (this.nom)+" "+this.prenom;
    }
}
