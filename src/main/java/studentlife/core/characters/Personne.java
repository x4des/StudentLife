package studentlife.core.characters;

//Une personne peut être un élève(utilisateur) ou un professeur
public class Personne {
    private final String nom;
    private final String prenom;

    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
