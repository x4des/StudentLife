package studentlife.core;

import studentlife.core.events.Evenement;

import java.util.ArrayList;
/**
 * {@literal La classe jour represente un jour dans la semaine composé d'une liste d'evenements}
 * */

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
