package studentlife.core.events;

import studentlife.core.characters.Etudiant;

/**
 *Un évènement correspond aux différentes situations auxquelles l'étudiant va assister ou non.
 Cette interface sera donc implémentée par les classes Cours et Pause qui eux, modifieront les Stats
 de l'utilisateur selon le choix de l'événement (aller en cours ou faire une pause).
 * @see Pause
 * @see Cours
 */
public interface Evenement {

    /**
     * Méthode qui modifie les stats de l'étudiant selon son choix d'évènement.
     * @param utilisateur L'étudiant. Ici on aura besoin de ses stats.
     * @param valid  Un booléen qui vérifie si l'étudiant a choisi d'assister à un Evenement proposé
     * */
    void finaliserEvenement(Etudiant utilisateur, boolean valid);
}
