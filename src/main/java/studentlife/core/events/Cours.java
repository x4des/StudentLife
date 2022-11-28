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
    private ArrayList<Quiz> listeQuiz;

    public Cours(CoursType coursType, Professeur professeur, Matiere matiere) {
        this.typeCours = coursType;
        this.matiere = matiere;
        this.professeur = professeur;
        this.listeQuiz = new ArrayList<Quiz>();
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

    public void addListeQuiz(Quiz quiz) {
        this.listeQuiz.add(quiz);
    }

    public ArrayList<Quiz> getListeQuiz(){
        return this.listeQuiz;
    }

    public String getNom(){

        switch (typeCours) {
            case CM: return "Cours Magistral";
            case TD: return "Travaux Dirigés";
            case TP: return "Travaux Pratiques";
            default: return "Cours Inconnu";
        }
    }

    @Override
    public void finaliserEvenement(Etudiant user, boolean valid){
        /*int i = 1;
        int j = 1;
        if(valid) {
            while(this.matiere.getNomMatiere().equals(user.getStatsMatiere().get(i).getNom())) {
                i++;
            }
            user.getStatsMatiere().get(i).setValeur(10);                                        // Augmentation de la stats de la matière de 10.
            while(this.professeur.getNom().equals(user.getStatsProfs().get(j).getNom())){
                j++;
            }
            user.getStatsProfs().get(i).setValeur(10);                                          // Augmentation de la stats de la relation avec le prof de 10.
            for (i = 0; i <= 3; i++) {
                if (user.getStatsPerso().get(i).getNom() == "attention") {
                    user.getStatsPerso().get(i).setValeur(-10);
                }
                if (user.getStatsPerso().get(i).getNom() == "fatigue") {
                    user.getStatsPerso().get(i).setValeur(10);
                }
                if (user.getStatsPerso().get(i).getNom() == "faim") {
                    user.getStatsPerso().get(i).setValeur(10);
                }
            }
        }
        if(!valid){
            while (this.matiere.getNomMatiere().equals(user.getStatsMatiere().get(i).getNom())) {
                i++;
            }
            user.getStatsMatiere().get(i).setValeur(-10);
            while(this.professeur.getNom().equals(user.getStatsProfs().get(j).getNom())){
                j++;
            }
            user.getStatsProfs().get(i).setValeur(10);
        }*/

    }
}
