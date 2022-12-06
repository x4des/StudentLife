/**
 * Contient les classes Matiere, Day, Schedule
 * */
package studentlife.core;

import studentlife.core.events.Evenement;

import java.util.ArrayList;
/**
 *La classe jour represente un jour dans la semaine composé d'une liste d'evenements
 * @see Evenement
 * @see studentlife.core.events.Cours
 * @see studentlife.core.events.Pause
 * */

public class Day {
    private ArrayList<Evenement> evenements;

    /**
     * constructeur de la classe Day, jour sans evenements
     * */
    public Day() {
        this.evenements = new ArrayList<>();
    }

    /**
     * @param evenements
     * constructeur d'un jour avec plusieurs evenements
     * */
    public Day(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }

    /**
     * @return retourne un evenement
     * getter qui permet d'acceder aux evenements
     * */
    public ArrayList<Evenement> getEvenements() {
        return evenements;
    }

    /**
     * @param evenements
     * setter modifie la valeur de la liste d'evenements
     * */
    public void setEvenements(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }

    /**
     * @param evenement
     * ajoute un evenement a la liste d'evenement
     * */
    public void addEvenement(Evenement evenement) { evenements.add(evenement); }
}
