package studentlife.core.events;

import studentlife.core.Matiere;
import studentlife.core.characters.Etudiant;
import static studentlife.Config.*;

/**
 * la classe Pause implemente l'interface Evenement et modifie les stats des objets impliqués
 * @see Evenement
 * */
public class Pause implements Evenement {

    private PauseType pauseType;
    private Matiere subject;
    public Pause() {}

    /**
     * @param pause
     * constructeur de la classe Pause
     * */
    public Pause(PauseType pause) {
        pauseType = pause;
    }

    /**
     * @param pause
     * @param subject
     * constructeur de la classe Pause.
     * */
    public Pause(PauseType pause, Matiere subject) {
        pauseType = pause;
        this.subject = subject;
    }

    /**
     * @param pauseType
     * setter qui change la valeur de pausetype.
     * */
    public void setPauseType(PauseType pauseType) {
       this.pauseType = pauseType;
    }

    /**
   * @param utilisateur les stats de user seront modifiés en fonction de la pause qu'il a pris ainsi:
   * _ lorsque c'est une pause repas, la faim diminue, la fatigue aussi et ainsi l'attention augmente.
   * _ lorsque c'est une pause repos, la faim reste la meme, la fatigue diminue et l'attention augmente.
   * _ lorsque c'est une pause revision, la fatigue augmente, l'attention diminue mais la moyenne de la matière revisé augmente de 10.
   * @param valid booleen qui verifie si l'evenement choisi est bien un Cours, ainsi la procedure pourra modifier les stats.
  * */
    @Override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid) {
        switch (pauseType) {
            case REPAS:
                utilisateur.getStats().getStat(STAT_FAIM).setValue(0);
                utilisateur.getStats().getStat(STAT_FATIGUE).setValue((int)utilisateur.getStats().getStat(STAT_FATIGUE).getValue()/2);
                utilisateur.getStats().updateAttention(STAT_ATTENTION);
                break;

            case REPOS:
                //faim reste inchangé car on peut quand même manger un snack pendant une pause repos
                utilisateur.getStats().getStat(STAT_FATIGUE).updateValue(-10);
                utilisateur.getStats().updateAttention(STAT_ATTENTION);
                break;

            case REVISION:
                //faim reste inchangé car on peut quand même manger un snack pendant une révision
                utilisateur.getStats().getStat(STAT_FATIGUE).updateValue(POINTS_REVISION);
                utilisateur.getStats().updateAttention(STAT_ATTENTION);
                faireRevision(utilisateur);
                break;
        }
    }

  /**
   * @param utilisateur la moyenne de l'utilisateur dans la matiere sera modifié
   * si la matière est mentionné la moyenne se verra augmenté de 10.
   * @throws RuntimeException si la matière n'existe pas ou n'est pas mentionée,
   l'exception fais propagé un message d'erreur.
   * */
    private void faireRevision(Etudiant utilisateur) throws RuntimeException{
            if (subject == null){
                throw new RuntimeException("Il faut une matière à réviser");
            }
            subject.getMastery().updateValue(10);
    }

}
