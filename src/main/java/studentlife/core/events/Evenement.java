package studentlife.core.events;

import studentlife.core.characters.Etudiant;

//Un Evenement correspond au differentes "taches" de la journée de l'étudiant
public interface Evenement {

    //method "finaliser" param: etudiant, choix pour changer ses stats
    public void finaliserEvenement(Etudiant utilisateur, boolean valid);
}
