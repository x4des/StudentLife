package studentlife.core;

import studentlife.core.events.Cours;
import studentlife.core.events.Evenement;

import java.util.ArrayList;
/**
 *La classe Day représente un jour dans la semaine composé d'une liste d'évènements (cours/pause)
 * @see Evenement
 * @see studentlife.core.events.Cours
 * @see studentlife.core.events.Pause
 * */

public class Day {

    /**la liste d'évènements (cours/pause) */
    private ArrayList<Evenement> evenements;


    /**
     * Constructeur de la classe Day avec une liste d'évènements vide
     * */
    public Day() {
        this.evenements = new ArrayList<>();
    }


    /** Constructeur d'un jour avec des évènements définis
     * @param evenements la liste d'évènements
     * */
    public Day(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }


    /**
     * Getter qui permet d'accéder aux évènements
     * @return retourne une liste d'évènements
     * */
    public ArrayList<Evenement> getEvenements() {
        return evenements;
    }


    /**
     * Setter qui passe une liste d'évènements à l'attribut evenements
     * @param evenements la liste d'évènements
     * */
    public void setEvenements(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }


    /**
     * ajoute un évènement a la liste d'évènements
     * @param evenement un évènement
     * */
    public void addEvenement(Evenement evenement) { evenements.add(evenement); }

    /**
     * Methode qui permet de retourner toutes les informations concernant le jour (la liste d'évènements)
     * @return un String avec les évènements du jour
     * */
    @Override
    public String toString(){
        String day = "";
        for (Evenement event : evenements){ //pour chaque event dans la liste
            if (event instanceof Cours){ //si c'est un cours on affiche sa information
                day += event.toString() + "\n";
            }else{
                day += "Pause\n"; //sinon pause
            }
        }
        return day;
    }
}
