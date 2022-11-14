import java.util.ArrayList;

//Un EDT est une représentaition sur une semaine, donc composé de plusieurs Jour
public class EDT {
    private ArrayList<Jour> jours;

    public EDT(ArrayList<Jour> jours) {
        this.jours = jours;
    }

    public ArrayList<Jour> getJours() {
        return jours;
    }

    public void setJours(ArrayList<Jour> jours) {
        this.jours = jours;
    }
}
