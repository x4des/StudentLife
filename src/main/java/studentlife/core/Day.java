package studentlife.core;

import studentlife.core.events.Cours;
import studentlife.core.events.Evenement;

import java.util.ArrayList;
/**
 *La classe jour représente un jour dans la semaine composé d'une liste d'évènements
 * @see Evenement
 * @see studentlife.core.events.Cours
 * @see studentlife.core.events.Pause
 * */

public class Day {

    /**la liste d'évènements*/
    private ArrayList<Evenement> evenements;

    /**
     * constructeur de la classe Day, jour sans évènements
     * */
    public Day() {
        this.evenements = new ArrayList<>();
    }

    /**
     * @param evenements
     * constructeur d'un jour avec plusieurs évènements
     * */
    public Day(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }

    /**
     * @return retourne un évènement
     * getter qui permet d'accéder aux évènements
     * */
    public ArrayList<Evenement> getEvenements() {
        return evenements;
    }

    /**
     * @param evenements la liste d'évènements
     * setter modifie la valeur de la liste d'évènements
     * */
    public void setEvenements(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }

    /**
     * @param evenement un évènement
     * ajoute un évènement a la liste d'évènement
     * */
    public void addEvenement(Evenement evenement) { evenements.add(evenement); }

    @Override
    public String toString(){
        String day = "";
        for (Evenement event : evenements){
            if (event instanceof Cours){
                day += event.toString() + "\n";
            }else{
                day+= "Pause\n";
            }
        }
        return day;
    }
}
