package studentlife.events;

import studentlife.characters.Etudiant;

public class PauseRepos implements Pause {

    public PauseRepos(){}

    public String getNom() {
        return "Pause Repos";
    }

    @Override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid){}

    @Override
    public void evenementActuel(String evenChoice){}
}
