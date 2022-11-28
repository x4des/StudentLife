package studentlife.core;

import studentlife.core.actions.Quiz;
import studentlife.core.characters.Stat;

import java.util.ArrayList;

import static studentlife.Config.STAT_MASTERY;

public class Matiere {
    private final String nomMatiere;

    private Stat mastery;

    private ArrayList<Quiz> listeQuiz;

    public Matiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
        this.mastery = new Stat(STAT_MASTERY, 0);
        this.listeQuiz = new ArrayList<Quiz>();
    }

    public String getNom(){
        return nomMatiere;
    }


    public Stat getMastery() { return mastery; }

    public void addQuiz(Quiz quiz) {
        this.listeQuiz.add(quiz);
    }
    public ArrayList<Quiz> getListeQuiz(){
        return this.listeQuiz;
    }
}
