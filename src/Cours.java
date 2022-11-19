import java.lang.Enum;
import java.util.ArrayList;
import java.util.Objects;

public class Cours implements Evenement{
    private Matiere matiere;
    private Professeur professeur;
    private Type typeCours;
    private ArrayList<Action> listAction;

    public Cours(Professeur professeur, Matiere matiere) {
        this.matiere = matiere;
        this.professeur = professeur;
        this.listAction = new ArrayList<Action>();
    }

    public Type getTypeCours (){
        return this.typeCours;
    }
    public void setTypeCours (Type type){
        this.typeCours = type;
    }

    public Professeur getProfesseur(){ return this.professeur; }
    public void setProfesseur(Professeur prof){
        this.professeur = prof;
    }

    public void addListAction(Action act) {
        this.listAction.add(act);
    }

    @Override
    public String getNom(){
        return this.typeCours.toString();
    }

    @Override
    public void finaliserEvenement(Etudiant user, boolean valid){
        int i = 1;
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
        }
    }
}
