package studentlife.characters;

public class Professeur extends Personne {

    private Stat appreciation;

    public Professeur(String nom, String prenom){
        super(nom, prenom);

        this.appreciation = new Stat("appreciation", 0);
    }
}
