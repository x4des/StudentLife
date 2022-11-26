package studentlife.timeline;

import studentlife.events.Evenement;

import java.util.ArrayList;

//Un jour sera composé d'evenements mais ne sera représenté pour l'instant que comme: Jour 1, Jour 2...
public class Jour {
    private int numeroJour;
    private ArrayList<Evenement> evenements;

    public Jour(int numeroJour, ArrayList<Evenement> evenements) {
        this.numeroJour = numeroJour;
        this.evenements = evenements;
    }

    public int getNumeroJour() {
        return numeroJour;
    }

    public void setNumeroJour(int numeroJour) {
        this.numeroJour = numeroJour;
    }

    public ArrayList<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }
}
