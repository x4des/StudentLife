package studentlife.core.events;

import studentlife.core.Matiere;
import studentlife.core.actions.Quiz;
import studentlife.core.characters.Etudiant;
import studentlife.core.characters.Professeur;

import java.util.ArrayList;
/**
{@literal La classe cours implémente l'interface Evenement
sur la procédure finaliser evenement qui modifiera les statistiques de l'etudiant
après avoir choisi d'assisté ua un cours donné
}
 */
public class Cours implements Evenement {
    private final CoursType typeCours;
    private Matiere matiere;
    private Professeur professeur;

    /**
     * @param coursType c'est un TD, TP ou CM, il permet de distinguer quel genre de cours l'etudiant participe
     * @param professeur, le chargé de cours qui est une Personne avec une stat qui est son appreciation envers l'etudiant
     * @param matiere
     * {@literal Ce constructeur permettra de construire un objet de la classe Cours}
     * */
    public Cours(CoursType coursType, Professeur professeur, Matiere matiere) {
        this.typeCours = coursType;
        this.matiere = matiere;
        this.professeur = professeur;
    }



    // les getters et setter des differents attributs de la classe Cours

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

    /**
     * @param user les stats de l'utilisateur sont utilisés dans cette procedure afin de les modifiers.
     * Ici, la faim augmente de 20, la fatigue augmente de 45% de la valeure de faim
     * et la stat attention est complementaire a la stat fatigue.
     * @param valid booleen qui est retourner dans la fonction evenement actuel qui verifie si l'evenement choisi
     * est bien un cours.
     * */
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