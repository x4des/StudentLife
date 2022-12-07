/**
 * Contient les classes liées a touts evenements. Ainsi, elle continent
 l'interface Evenement, les classes qui l'implemente; Cours, et Pause et d'autres modules stockant
 les types de Cours et de Pauses.
 * */
package studentlife.core.events;

import studentlife.core.Matiere;
import studentlife.core.characters.Etudiant;
import studentlife.core.characters.Professeur;
import static studentlife.Config.*;


/**
 * la classe Cours implemente l'interface Evenement et modifie les stats des objets impliquée
 * @see Evenement
 * */
public class Cours implements Evenement {
    private final CoursType typeCours;
    private Matiere matiere;
    private Professeur professeur;

    /**
     * @param coursType
     * @param professeur
     * @param matiere
     * constructeur de la classe
     * */
    public Cours(CoursType coursType, Professeur professeur, Matiere matiere) {
        this.typeCours = coursType;
        this.matiere = matiere;
        this.professeur = professeur;
    }

    /**
     * @return getter qui retourne l'attribut matiere.
     * */
    public Matiere getMatiere() {
        return matiere;
    }

    /**
     * @return getter qui permet d'acceder au type de cours (TP, TD ou CM).
     * */
    public CoursType getTypeCours (){
        return this.typeCours;
    }

    /**
     * @return getter de l'attribut professeur.
     * */
    public Professeur getProfesseur(){ return this.professeur; }

    /**
     * @param prof
     * setter de l'attribut professeur
     * */
    public void setProfesseur(Professeur prof){
        this.professeur = prof;
    }

    /**
     * @return retourne le nom du type de cours.
     * */
    public String getNom(){

        switch (typeCours) {
            case CM: return "Cours Magistral";
            case TD: return "Travaux Dirigés";
            case TP: return "Travaux Pratiques";
            default: return "Cours Inconnu";
        }
    }

    /**
     * @return retourne le nom du tyoe du cours (en abrégés).
     * */
    public String getShortNom(){
        switch (typeCours) {
            case CM: return "CM";
            case TD: return "TD";
            case TP: return "TP";
            default: return "Cours Inconnu";
        }
    }

    /**
     * @param user les stats de l'utilisateur seront modifiés; la stat faim sera augmenté de 20
     * cette modification entrenra l'augmentation de la fatigue de 45% de la valeur de la faim et la stat attention
     * est le complementaire de la stat fatigue.
     * l'appreciation du professeur envers l'etudiant sera aussi augmenté selon le type de cours où il participe.
     * Pour finir, la moyenne de la matière concerné sera augmenté.
     * @param valid booleen qui verifie si l'evenement choisi est bien un Cours, ainsi la procedure pourra modifier les stats.
     * */
    @Override
    public void finaliserEvenement(Etudiant user, boolean valid) {

        if(valid) {
            getMatiere().getListeQuiz().get(0).realiserQuiz();
            getMatiere().deleteQuiz(0);
            switch (typeCours) {
                case CM:
                    matiere.getMastery().updateValue(5);
                    user.getStats().updateStat(STAT_FAIM, 20);
                    user.getStats().updateFatigue(STAT_FATIGUE, true);
                    user.getStats().updateAttention(STAT_ATTENTION);
                    break;
                case TD:
                case TP:
                    matiere.getMastery().updateValue(5);
                    professeur.getAppreciation().updateValue(5);
                    user.getStats().updateStat(STAT_FAIM, 20);
                    user.getStats().updateFatigue(STAT_FATIGUE, true);
                    user.getStats().updateAttention(STAT_ATTENTION);
                    break;
            }
        }else{
            switch (typeCours) {
                case CM:
                    matiere.getMastery().updateValue(-5);
                    break;
                case TD:
                case TP:
                    matiere.getMastery().updateValue(-5);
                    professeur.getAppreciation().updateValue(-5);
                    break;
            }
        }
    }


    @Override
    public String toString(){
        return this.getShortNom() + " de "+ this.getMatiere().getNom() + " avec "+ this.professeur.getPrenom() +" "+this.professeur.getNom();
    }
}