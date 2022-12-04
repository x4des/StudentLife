package studentlife.core;

import studentlife.core.actions.Quiz;
import studentlife.core.characters.Stat;

import java.util.ArrayList;

import static studentlife.Config.STAT_MASTERY;
/**
 * {@literal La classe Matiere represente une matiere qui possède
 une statistique qui est la moyenne que l'etudiant a dans cette meme matiere.
 Elle possede egalement une liste de quiz dont les reponses seront
 demandées à l'utilisateur.
 }
 * */
public class Matiere {
    private final String nomMatiere;

    private Stat mastery;

    private ArrayList<Quiz> listeQuiz;

    public Matiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
        this.mastery = new Stat(STAT_MASTERY, 50);
        this.listeQuiz = new ArrayList<Quiz>();
    }

    public String getNom(){
        return nomMatiere;
    }


    public Stat getMastery() { return mastery; }

    public void addQuiz(Quiz quiz) {
        this.listeQuiz.add(quiz);
    }

    public void deleteQuiz(int i){
        listeQuiz.remove(i);
    }
    public ArrayList<Quiz> getListeQuiz(){
        return this.listeQuiz;
    }

    @Override
    public String toString(){
        return (this.nomMatiere + ": " + this.mastery.getValue() + "/100");
    }
}
