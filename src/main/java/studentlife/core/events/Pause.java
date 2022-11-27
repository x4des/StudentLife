package studentlife.core.events;

import studentlife.core.characters.Etudiant;

public class Pause implements Evenement {

    private PauseType pauseType;

    public Pause() {}

    public void setPauseType(PauseType pauseType) {
       this.pauseType = pauseType;
    }

    @Override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid) {
        switch (pauseType) {
            case REPAS:
                // RESOLVE PAUSE REPAS
                break;
            case REPOS:
                // RESOLVE PAUSE REPOS
                break;
            case REVISION:
                // RESOLVE PAUSE REVISION
                break;
        }
    }
}
