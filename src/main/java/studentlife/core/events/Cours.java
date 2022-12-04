package studentlife.core.events;

import studentlife.core.Matiere;
import studentlife.core.actions.Quiz;
import studentlife.core.characters.Etudiant;
import studentlife.core.characters.Professeur;

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

    public void finaliserEvenement(Etudiant user, boolean valid) {
    }

    /*
    @Override
    public void finaliserEvenement(Etudiant user, boolean valid){
       Stat faim = user.stats.statsMap.get(STAT_FAIM);
       faim.updateStat(STAT_FAIM,20); //faim augmente de 20 apres chaque cours

       //modification de la stat fatigue par rapport a la stat faim
        Stat fatigue =user.stats.statsMap.get(STAT_FATIGUE);
        fatigue.updateStats(faim, '+');

        /*if (faim.value >= 0 && faim.value <= 20 && fatigue.val >= 0 &&fatigue.val < 9 ) {
            fatigue.updateStats(faim, '+');
        }
        if (faim.value > 20 && faim.value <= 40 && fatigue.val >= 9 &&fatigue.val < 27 ){
            fatigue.updateStats(faim,'+');
        }
        if (faim.value > 40 && faim.value <= 60 && fatigue.val >= 27 &&fatigue.val < 54){
            fatigue.updateStats(faim,'+');
        }
        if (faim.value >= 60 && faim.value <= 80 && fatigue.val >= 54 &&fatigue.val < 90){
            fatigue.updateStats(faim,'+');
        }
        if (faim.value >= 80 && faim.value <= 100 && && fatigue.val >= 90 && fatigue.val < 100 ){
            fatigue.updateStats(faim,'+');
        }



        //modif de la stats attention qui est complementaire a la stats fatigue
        Stat attention =user.stats.statsMap.get(STAT_ATTENTION);
        int minusAttention = (attention.MAX_STAT )- fatigue.value;
        attention.setValue(minusAttention);
    }
    */
}