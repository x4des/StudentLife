package studentlife.core;

import studentlife.core.actions.Quiz;
import studentlife.core.characters.Stat;

import java.util.ArrayList;

import static studentlife.Config.STAT_MASTERY;
/**
 *La classe Matière représente une matière qui possède
 une statistique qui est la moyenne que l'étudiant dans cette meme matière.
 Elle possède également une liste de quiz dont les réponses seront
 demandées à l'utilisateur.
 * */
public class Matiere {

    /**nom de la matière*/
    private final String nomMatiere;

    /**la statistique en lien avec la matière = la moyenne*/
    private final Stat mastery;

    /**la liste de quiz en lien avec la matière*/
    private final ArrayList<Quiz> listeQuiz;

    /**
     * @param nomMatiere Le nom de la matière.
     * Constructeur de la classe Matière.
     * */
    public Matiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
        this.mastery = new Stat(STAT_MASTERY, 50);
        this.listeQuiz = new ArrayList<>();
    }

    /**
     * getter de l'attribut nomMatiere
     * @return retourne le nom de la matière
     * */
    public String getNom(){
        return nomMatiere;
    }


    /**
     * @return la stat lié a la matière = mastery
     * getter, permet d'accéder a l'attribut mastery de la classe
     * */
    public Stat getMastery() { return mastery; }

    /**
     * @param quiz un quiz
     * ajoute un quiz a la liste de quiz
     * */
    public void addQuiz(Quiz quiz) {
        this.listeQuiz.add(quiz);
    }

    /**
     * @param i indice d'un quiz
     * procedure qui supprime un quiz de la liste dont l'indice est passé en paramètre
     * */
    public void deleteQuiz(int i){
        listeQuiz.remove(i);
    }

    /**
     * @return retourne la liste de quiz liée à la matière
     * getter de l'attribut listeQuiz
     * */
    public ArrayList<Quiz> getListeQuiz(){
        return this.listeQuiz;
    }

    /**
     * @return  retourne un string qui permettra d'afficher
     une matière.
     * */
    @Override
    public String toString(){
        return (this.nomMatiere + ": " + this.mastery.getValue() + "/100");
    }
}
