package studentlife.core.events;

import studentlife.core.Matiere;
import studentlife.core.actions.Quiz;
import studentlife.core.characters.Etudiant;
import studentlife.core.characters.Professeur;
import static studentlife.Config.*;

import java.util.ArrayList;

public class Cours implements Evenement {
    private final CoursType typeCours;
    private Matiere matiere;
    private Professeur professeur;

    public Cours(CoursType coursType, Professeur professeur, Matiere matiere) {
        this.typeCours = coursType;
        this.matiere = matiere;
        this.professeur = professeur;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public CoursType getTypeCours (){
        return this.typeCours;
    }

    public Professeur getProfesseur(){ return this.professeur; }
    public void setProfesseur(Professeur prof){
        this.professeur = prof;
    }



    public String getNom(){

        switch (typeCours) {
            case CM: return "Cours Magistral";
            case TD: return "Travaux Dirigés";
            case TP: return "Travaux Pratiques";
            default: return "Cours Inconnu";
        }
    }

    public String getShortNom(){
        switch (typeCours) {
            case CM: return "CM";
            case TD: return "TD";
            case TP: return "TP";
            default: return "Cours Inconnu";
        }
    }


    @Override
    public void finaliserEvenement(Etudiant user, boolean valid) {

        if(valid) {
            switch (typeCours) {
                case CM:
                    matiere.getMastery().updateValue(5);
                    user.getStats().updateStat(STAT_FAIM, 20);
                    user.getStats().updateFatigue(STAT_FATIGUE, false);
                    user.getStats().updateAttention(STAT_ATTENTION);

                case TD:
                case TP:
                    matiere.getMastery().updateValue(5);
                    professeur.getAppreciation().updateValue(5);
                    user.getStats().updateStat(STAT_FAIM, 20);
                    user.getStats().updateFatigue(STAT_FATIGUE, false);
                    user.getStats().updateAttention(STAT_ATTENTION);
            }
        }else{
            switch (typeCours) {
                case CM:
                    matiere.getMastery().updateValue(-5);
                case TD:
                case TP:
                    matiere.getMastery().updateValue(-5);
                    professeur.getAppreciation().updateValue(-5);
            }
        }
    }
}