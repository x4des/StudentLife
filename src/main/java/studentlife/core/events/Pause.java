package studentlife.core.events;

import studentlife.core.Matiere;
import studentlife.core.characters.Etudiant;
import static studentlife.Config.*;

public class Pause implements Evenement {

    private PauseType pauseType;
    private Matiere subject;
    public Pause() {}
    public Pause(PauseType pause) {
        pauseType = pause;
    }

    public Pause(PauseType pause, Matiere subject) {
        pauseType = pause;
        this.subject = subject;
    }



    public void setPauseType(PauseType pauseType) {
       this.pauseType = pauseType;
    }



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
                utilisateur.getStats().getStat(STAT_FATIGUE).updateValue(10);
                utilisateur.getStats().updateAttention(STAT_ATTENTION);
                faireRevision(utilisateur);
                break;
        }
    }


    private void faireRevision(Etudiant utilisateur) throws RuntimeException{
            if (subject == null){
                throw new RuntimeException("Il faut une matière à réviser");
            }
            subject.getMastery().updateValue(10);
    }

}
