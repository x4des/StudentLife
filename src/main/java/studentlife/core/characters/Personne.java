package studentlife.core.characters;

/**
 * une classe abstraite représentant une personne
 qui possède un nom et un prénom
 Une personne peut être un étudiant(utilisateur) ou un professeur
 * */
public abstract class Personne {
    private String nom;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return retourn un sting permettant d'afficher une personne ( son nom et prenom)
     * */
    @Override
    public String toString(){
        return (this.nom)+" "+this.prenom;
    }
}
