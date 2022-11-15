import java.util.ArrayList;

public class Etudiant extends Personne {
    private ArrayList<Stats> statsPerso;
    private ArrayList<Stats> statsProfs;
    private ArrayList<Stats> statsMatiere;


    public Etudiant(String nom, String prenom) {
        super(nom, prenom);
        this.statsPerso = new ArrayList<Stats>();
        this.statsProfs = new ArrayList<Stats>();
        this.statsMatiere = new ArrayList<Stats>();
    }

    public ArrayList<Stats> getStatsPerso() {
        return statsPerso;
    }

    public void setStatsPerso(float prctg, int i) {

        //this.statsPerso.get(i).valeur = this.statsPerso.get(i).valeur + (this.statsPerso.get(i).valeur * prctg);
    }

    public ArrayList<Stats> getStatsProfs() {
        return statsProfs;
    }

    public void setStatsProfs(float prctg, int i) {
        this.statsProfs
        //this.statsProfs.get(i).valeur = this.statsProfs.get(i).valeur + (this.statsProfs.get(i).valeur * prctg);
    }

    public ArrayList<Stats> getStatsMatiere() {
        return statsMatiere;
    }

    public void setStatsMatiere(float prctg, int i) {
        this.statsMatiere.get(i).valeur = this.statsMatiere.get(i).valeur + (this.statsMatiere.get(i).valeur * prctg);
    }
}
