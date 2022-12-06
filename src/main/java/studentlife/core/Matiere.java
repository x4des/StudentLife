package studentlife.core;

import studentlife.core.actions.Quiz;
import studentlife.core.characters.Stat;

import java.util.ArrayList;

import static studentlife.Config.STAT_MASTERY;
/**
 *La classe Matiere represente une matiere qui possède
 une statistique qui est la moyenne que l'etudiant a dans cette meme matiere.
 Elle possede egalement une liste de quiz dont les reponses seront
 demandées à l'utilisateur.
 * */
public class Matiere {
    private final String nomMatiere;

    private final Stat mastery;

    private final ArrayList<Quiz> listeQuiz;

    /**
     * @param nomMatiere
     * constructeur de la classe Matiere
     * */
    public Matiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
        this.mastery = new Stat(STAT_MASTERY, 50);
        this.listeQuiz = new ArrayList<>();
    }

    /**
     * getter de l'attribut nomMatiere
     * @return retourne le nom de la matiere
     * */
    public String getNom(){
        return nomMatiere;
    }


    /**
     * @return la stat lié a la matiere = mastery
     * getter, permet d'acceder a l'attribut mastery de la classe
     * */
    public Stat getMastery() { return mastery; }

    /**
     * @param quiz
     * ajoute un quiz a la liste de quiz
     * */
    public void addQuiz(Quiz quiz) {
        this.listeQuiz.add(quiz);
    }

    /**
     * @param i indice d'un quiz
     * procedure qui supprime un quiz de la liste dont l'indice est passé en parametre
     * */
    public void deleteQuiz(int i){
        listeQuiz.remove(i);
    }

    /**
     * @return retourne al liste de quiz liée a la matiere
     * getter de l'attribut listeQuiz
     * */
    public ArrayList<Quiz> getListeQuiz(){
        return this.listeQuiz;
    }

    /**
     * @return  retourne un string qui permettra d'afficher
     une matiere.
     * */
    @Override
    public String toString(){
        return (this.nomMatiere + ": " + this.mastery.getValue() + "/100");
    }
}
