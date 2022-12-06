package studentlife.core.events;

import studentlife.core.characters.Etudiant;
/**
 *Un evenement correspond au différentes "taches" fera ou pas dans la journée
 cette interface sera donc implémenter par les classes Cours et Pause qui eux, modifieront les stats
 de l'utilsateur selon le choix de l'evenement (aller en cours ou faire une pause).
 * @see Pause
 * @see Cours
 */
public interface Evenement {
    /**
     * @param utilisateur les stats de l'etudiant seront changées selon le choix de l'evenemnt
     * @param valid  un booleen qui verifie que le choix de l'utlisateur est bien celui du meme evenement
     * */
    public void finaliserEvenement(Etudiant utilisateur, boolean valid);
}
