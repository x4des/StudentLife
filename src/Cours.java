import java.lang.Enum;
import java.util.ArrayList;

public class Cours implements Evenement{
    private Professeur professeur;
    private Type typeCours;
    private ArrayList<Action> listAction;

    public Cours(Professeur professeur) {
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
}
