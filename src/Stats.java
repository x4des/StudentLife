public class Stats {
    String nom;
    double valeur;

    public Stats(String nom, int valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    // Procedure qui augmente et de diminution de la valeure de fatigue à partir d'un réel donné (pourcentage de diminution)
    public void upFatigue(double prct, double valActuel){}
    public void downFatigu(double prct, double valActuel){}
    public void upFaim(double prct, double valActuel){}
    public void downFaim(double prct, double valActuel){}
    public void upAttention(double prct, double valActuel){}
    public void downAttention(double prct, double valActuel){}

}
