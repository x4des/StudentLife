package studentlife;

import studentlife.events.Evenement;

import java.util.ArrayList;

//Un jour sera composé d'evenements mais ne sera représenté pour l'instant que comme: Jour 1, Jour 2...
public class Day {
    private ArrayList<Evenement> evenements;

    public Day() {
        this.evenements = new ArrayList<>();
    }

    public Day(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }

    public ArrayList<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }

    public void addEvenement(Evenement evenement) { evenements.add(evenement); }
}
