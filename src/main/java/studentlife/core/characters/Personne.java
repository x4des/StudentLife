package studentlife.core.characters;

/**
 * la classe represente une personne
 qui posséde un nom et un prenom
 * */
//Une personne peut être un élève(utilisateur) ou un professeur
public abstract class Personne {
    private String nom;
    private String prenom;

    /**
     * @param nom
     * @param prenom
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
