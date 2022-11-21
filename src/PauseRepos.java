public class PauseRepos extends Pause {


    public PauseRepos(){
        super.nom = "Pause Repos";
    }

    public String getNom() {
        return nom;
    }

    @override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid){}
    @override
    public void evenementActuel(String evenChoice){}
}
