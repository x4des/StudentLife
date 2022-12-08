package studentlife.core.events;

import studentlife.core.characters.Etudiant;
/**
 *Un évènement correspond aux différentes "taches" que l'étudiant fera ou pas dans la journée.
 Cette interface sera donc implémenter par les classes Cours et Pause qui eux, modifieront les stats
 de l'utilisateur selon le choix de l'événement (aller en cours ou faire une pause).
 * @see Pause
 * @see Cours
 */
public interface Evenement {
    /**
     * @param utilisateur L'étudiant. Ici on aura besoin de ses stats.
     * @param valid  Un booléen qui vérifie que le choix de l'utilisateur est bien celui du meme évènement.
     * Modifie les stats de l'étudiant selon ses choix d'évènements.
     * */
    public void finaliserEvenement(Etudiant utilisateur, boolean valid);
}
