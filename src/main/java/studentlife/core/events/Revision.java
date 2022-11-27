package studentlife.core.events;

import studentlife.core.Matiere;
import studentlife.core.characters.Etudiant;

public class Revision implements Evenement {

    Matiere matiere;

    public Revision(Matiere matiere) {
        this.matiere = matiere;
    }

    public String getNom(){
        return "Révision";
    }

    public Matiere getMatiere() { return matiere; }

    @Override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid) {

    }

    @Override
    public void evenementActuel(String evenChoice){

    }

}
