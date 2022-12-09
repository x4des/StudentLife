package studentlife.core.events;

import studentlife.core.Matiere;
import studentlife.core.characters.Etudiant;
import static studentlife.Config.*;

/**
 * La classe Pause implémente l'interface Evenement et modifie les stats des attributs impliqués.
 * Elle possède un type de Pause (repos/révision/repas) et une matière si le type est "révision"
 * @see Evenement
 * */
public class Pause implements Evenement {

    /**type de pause: repos/révision/repas */
    private PauseType pauseType;

    /**matière d'une révision*/
    private Matiere subject;


    /**Constructeur de classe Pause sans type.*/
    public Pause() {}


    /**
     * constructeur de la classe Pause avec un type
     * @param pause type de la pause (ici repos/repas)
     * */
    public Pause(PauseType pause) {
        pauseType = pause;
    }


    /**
     * constructeur de la classe Pause pour une "révision"
     * @param pause type de la Pause (ici révision)
     * @param subject la matière qu'on va réviser
     * */
    public Pause(PauseType pause, Matiere subject) {
        pauseType = pause;
        this.subject = subject;
    }


    /**
     * Setter qui change le type de Pause
     * @param pauseType type repos/reps/révision
     * */
    public void setPauseType(PauseType pauseType) {
        this.pauseType = pauseType;
    }


    /**
     * Méthode qui permet de modifier les Stats nécessaires à la fin d'un Evenement (ici Pause).
     * _ lorsque c'est une pause repas, la faim diminue, la fatigue aussi et ainsi l'attention augmente.
     * _ lorsque c'est une pause repos, la faim reste la meme, la fatigue diminue et l'attention augmente.
     * _ lorsque c'est une pause revision, la fatigue augmente, l'attention diminue mais la moyenne de la matière révisée augmente de 10.
     * @param utilisateur l'étudiant qui assiste fait une pause
     * @param valid ici le booléen ne joue pas de rôle
     * */
    @Override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid) {
        switch (pauseType) {
            case REPAS:
                utilisateur.getStats().getStat(STAT_FAIM).setValue(0);
                utilisateur.getStats().getStat(STAT_FATIGUE).setValue((int)(utilisateur.getStats().getStat(STAT_FATIGUE).getValue()/4)*3); //diminue de 1/3
                utilisateur.getStats().updateAttention(STAT_ATTENTION);
                break;

            case REPOS:
                //faim reste inchangée car on peut quand même manger un snack pendant une pause repos
                utilisateur.getStats().getStat(STAT_FATIGUE).setValue((int)utilisateur.getStats().getStat(STAT_FATIGUE).getValue()/2); //fatigue/2
                utilisateur.getStats().updateAttention(STAT_ATTENTION);
                break;

            case REVISION:
                //faim reste inchangée car on peut quand même manger un snack pendant une révision
                utilisateur.getStats().getStat(STAT_FATIGUE).updateValue(10);
                utilisateur.getStats().updateAttention(STAT_ATTENTION);
                faireRevision();
                break;
        }
    }


    /**
     * si la Matière a une valeur sa maitrise sera augmenté de 10.
     * @throws RuntimeException si la matière n'existe pas l'exception fait propager un message d'erreur.
     * */
    private void faireRevision() throws RuntimeException{
        if (subject == null){
            throw new RuntimeException("Il faut une matière à réviser");
        }
        subject.getMastery().updateValue(POINTS_REVISION);//augmente la maitrise
    }

}
