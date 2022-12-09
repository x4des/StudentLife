package studentlife.core.events;

import studentlife.core.Matiere;
import studentlife.core.characters.Etudiant;
import studentlife.core.characters.Professeur;
import static studentlife.Config.*;


/**
 * La classe Cours implémente l'interface Evenement et modifie-les stats des attributs impliqués.
 * Elle possède un type de Cours (TD/TP/CM), une matière à laquelle il est lié et un Professeur qui l'enseigne.
 *
 * @see Evenement
 * */
public class Cours implements Evenement {

    /**td, tp ou cm*/
    private final CoursType typeCours;

    /**la matière*/
    private final Matiere matiere;

    /**le chargé de cours*/
    private Professeur professeur;


    /**
     * Constructeur d'un Cours
     * @param coursType td, tp ou cm
     * @param professeur le chargé du cours
     * @param matiere la matière concernée
     * */
    public Cours(CoursType coursType, Professeur professeur, Matiere matiere) {
        this.typeCours = coursType;
        this.matiere = matiere;
        this.professeur = professeur;
    }


    /**
     * Getter qui permet d'avoir accès à la Matière du Cours
     * @return la Matière concernée
     * */
    public Matiere getMatiere() {
        return matiere;
    }


    /**
     * Getter qui permet d'avoir accès au type de Cours
     * @return TD/TP/CM (type de cours)
     * */
    public CoursType getTypeCours (){
        return this.typeCours;
    }


    /**
     * Getter qui permet d'avoir le chargé du Cours
     * @return le Professeur
     * */
    public Professeur getProfesseur(){ return this.professeur; }


    /**
     * setter de l'attribut Professeur
     * @param prof le Professeur
     * */
    public void setProfesseur(Professeur prof){
        this.professeur = prof;
    }


    /**
     * Getter qui permet d'avoir le type de Cours
     * @return retourne le nom du type de cours
     * */
    public String getType(){

        switch (typeCours) {
            case CM: return "Cours Magistral";
            case TD: return "Travaux Dirigés";
            case TP: return "Travaux Pratiques";
            default: return "Cours Inconnu";
        }
    }


    /**
     * Getter qui permet d'avoir le type de Cours (en abrégé)
     * @return type du cours (en abrégé)
     * */
    public String getShortType(){
        switch (typeCours) {
            case CM: return "CM";
            case TD: return "TD";
            case TP: return "TP";
            default: return "Cours Inconnu";
        }
    }


    /**
     * Méthode qui permet de modifier les Stats nécessaires à la fin d'un Evenement (ici Cours).
     * Si valid = true -> faim+=20, fatigue+=0.45*faim, attention=SEUIL_MAX-faim.
     * Si valid = false → on ne change pas les stats personnelles.
     * Puis des changements dans les stats des matières et professeurs(en fonction de type de cours).
     * @param user l'étudiant qui assiste à un cours
     * @param valid qui vérifie si l'étudiant a assisté à un Cours ou non.
     * */
    @Override
    public void finaliserEvenement(Etudiant user, boolean valid) {

        if(valid) { //s'il a assisté à un cours
            getMatiere().getListeQuiz().get(0).realiserQuiz(); //on lance un quizz
            getMatiere().deleteQuiz(0); //on le supprime pour ne pas se soucier des indices
            switch (typeCours) { //changements différents en fonction de type de cours
                case CM:
                    matiere.getMastery().updateValue(5);
                    user.getStats().updateStat(STAT_FAIM, 20);
                    user.getStats().updateFatigue(STAT_FATIGUE, true);
                    user.getStats().updateAttention(STAT_ATTENTION);
                    break;
                case TD:
                case TP:
                    matiere.getMastery().updateValue(5);
                    professeur.getAppreciation().updateValue(5); //appréciation du prof est changée si ce n'est pas un cm
                    user.getStats().updateStat(STAT_FAIM, 20);
                    user.getStats().updateFatigue(STAT_FATIGUE, true);
                    user.getStats().updateAttention(STAT_ATTENTION);
                    break;
            }
        }else{ //s'il n'a pas assisté à un cours
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


    /**
     * Méthode qui permet d'avoir le nom du Cours et le professeur qui l'enseigne
     * @return informations concernant le cours
     * */
    @Override
    public String toString(){
        return this.getShortType() + " de "+ this.getMatiere().getNom() + " avec "+ this.professeur.getPrenom() +" "+this.professeur.getNom();
    }
}