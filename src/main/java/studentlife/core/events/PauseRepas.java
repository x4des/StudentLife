package studentlife.core.events;

import studentlife.core.characters.Etudiant;

public class PauseRepas implements Pause {

    public PauseRepas(){}

    public String getNom(){
        return "Pause Repas";
    }

    @Override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid){}

    @Override
    public void evenementActuel(String evenChoice){}

}
