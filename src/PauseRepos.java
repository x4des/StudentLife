public class PauseRepos extends Pause {


    public PauseRepos(){
        super.nom = "Pause Repos";
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid){}
    @Override
    public void evenementActuel(String evenChoice){}
}
