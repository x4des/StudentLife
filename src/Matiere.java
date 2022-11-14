import java.util.ArrayList;

public class Matiere {
    private String nomMatiere;
    ArrayList<Cours> cours;
    ArrayList<Professeur> professeurs;

    public Matiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
        this.cours = new ArrayList<Cours>();
        this.professeurs = new ArrayList<Professeur>();
    }

    public String getNomMatiere(){
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public ArrayList<Cours> getListeCours(){
        return cours;
    }

    public double moyenneStats(){
        return moyenneStats();
    }
}
