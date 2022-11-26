package studentlife.events;

import studentlife.characters.Etudiant;

public class Revision implements Evenement {
    String name;
    public Revision() {
        this.name = "Révision";
    }

    public String getNom(){
        return name;
    }

    @Override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid) {

    }

    @Override
    public void evenementActuel(String evenChoice){

    }

}
