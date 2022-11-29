package studentlife.core.events;

import studentlife.core.Matiere;
import studentlife.core.characters.Etudiant;

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
            /*
            Stat faim = user.stats.statsMap.get(STAT_FAIM);
            Stat fatigue = user.stats.statsMap.get(STAT_FATIGUE);
            Stat attention = user.stats.statsMap.get(STAT_ATTENTION);

             */
            case REPAS:

                /*
                faim.setValue( faim.value -20);

                //diminution de la stat fatigue par rapport a la value de faim
                fatigue.updateStats(faim, '-');
                /*
                if (faim.value >= 0 && faim.value <= 20  &&fatigue.val >= 9 ) {
                    fatigue.updateStats(faim, '-');
                }
                if (faim.value > 20 && faim.value <= 40 &&fatigue.val >= 27 ){
                    fatigue.updateStats(faim,'-');
                }
                if (faim.value > 40 && faim.value <= 60 && fatigue.val >= 54){
                    fatigue.updateStats(faim,'-');
                }
                if (faim.value >= 60 && faim.value <= 80 && fatigue.val >= 90){
                    fatigue.updateStats(faim,'-');
                }
                if (faim.value >= 80 && faim.value <= 100 && fatigue.val >= 100 ){
                fatigue.updateStats(faim,'-');
            }

            // augmentation de l'attention qui est proportionelle a la fatigue
                int plusAttentionRepas = (attention.MAX_STAT )- fatigue.value;
                attention.setValue(plusAttentionRepas);

                 */
                break;



            case REPOS:
               /*
                fatigue.setValue(fatigue.value - 15);

                int plusAttentionRepos = (attention.MAX_STAT )- fatigue.value;
                attention.setValue(plusAttentionRepos);
                */
                break;



            case REVISION:
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
