package studentlife.core.characters;

/**
 * Une classe abstraite représentant une personne
 * qui possède un nom et un prénom.
 * Une personne peut être un étudiant(utilisateur) ou un professeur.
 @see Etudiant
 @see Professeur
 * */
public abstract class Personne {
    /** nom de la personne */
    private String nom;

    /** prenom de la personne */
    private String prenom;

    /**
     * le constructeur de la classe Personne
     * @param nom nom de la personne
     * @param prenom prénom de la personne
     * */
    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }


    /**
     * ce getter retourne l'attribut nom d'un objet Personne
     * @return le nom de la personne
     * */
    public String getNom() {
        return this.nom;
    }

    /**
     * le getter retourne l'attribut prénom d'un objet Personne
     * @return le prénom de la personne
     * */
    public String getPrenom() {
        return this.prenom;
    }

    /** ce setter permet de modifier la valeur de l'attribut nom*/
    public void setNom(String nom) {
        this.nom = nom;
    }

    /** ce setter permet de modifier la valeur de l'attribut prénom*/
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Affiche les informations d'une personne.
     * @return retourne un string permettant d'afficher une personne (son nom et prénom).
     * */
    @Override
    public String toString(){
        return (this.nom)+" "+this.prenom;
    }
}
