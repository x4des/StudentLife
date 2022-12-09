package studentlife.core;

import studentlife.core.actions.Quiz;
import studentlife.core.characters.Stat;

import java.util.ArrayList;

import static studentlife.Config.STAT_MASTERY;
/**
 *La classe Matière représente une matière qui possède un nom,
 une statistique qui est la maitrise de la matière par l'étudiant.
 Elle possède également une liste de quiz.
 * */
public class Matiere {

    /**nom de la matière*/
    private final String nomMatiere;

    /**la statistique en lien avec la matière = la maitrise*/
    private final Stat mastery;

    /**la liste de quiz de la matière*/
    private final ArrayList<Quiz> listeQuiz;


    /**
     * Constructeur de la classe Matière.
     * @param nomMatiere Le nom de la matière.
     * */
    public Matiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
        this.mastery = new Stat(STAT_MASTERY, 50); //maitrise initiale est neutre
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
     * Getter, permet d'accéder à l'attribut mastery de la classe
     * @return la stat lié à la matière = mastery
     * */
    public Stat getMastery() { return mastery; }


    /**
     * ajoute un quiz à la liste de quiz
     * @param quiz un quiz
     * */
    public void addQuiz(Quiz quiz) {
        this.listeQuiz.add(quiz);
    }


    /**
     * Méthode qui supprime un quiz de la liste dont l'indice est passé en paramètre
     * @param i indice d'un quiz
     * */
    public void deleteQuiz(int i){
        listeQuiz.remove(i);
    }


    /**
     * Getter de l'attribut listeQuiz
     * @return retourne la liste de quiz de la matière
     * */
    public ArrayList<Quiz> getListeQuiz(){
        return this.listeQuiz;
    }


    /**
     * Méthode qui retourne les informations concernant la Matiere
     * @return nom de la matière et sa maitrise
     * */
    @Override
    public String toString(){
        return (this.nomMatiere + ": " + this.mastery.getValue() + "/100");
    }
}
