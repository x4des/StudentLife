package studentlife.core;

import java.util.ArrayList;
import java.util.Collections;

/**
 *La classe Schedule représente l'emploi du temps de la semaine.
 Elle est composée d'une liste de jours
 * @see Day
 * */
public class Schedule {

    /**Var static qui indique le nombre max de jours d'école dans la semaine.*/
    private static final int MAX_DAYS = 5;

    /**tableau des noms des jours dans la semaine.*/
    private final String[] weekDays;

    /**la semaine*/
    private final ArrayList<Day> week;


    /**
     *Constructeur de Schedule
     * */
    public Schedule() {
        this.week = new ArrayList<>();
        this.weekDays = new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
    }


    /**
     * Getter de l'attribut week sous forme d'une liste.
     * @return retourne une liste de jours de la semaine
     * */
    public ArrayList<String> getWeekDaysAsList(){
        ArrayList<String> week = new ArrayList<>();
        Collections.addAll(week, weekDays);
        return week;

    }


    /**
     * ajoute un jour dans la semaine lorsque l'EDT n'est pas complet <(5 jours)
     * @param day un jour de la semaine
     * */
    public void addDay(Day day) {

        if(week.size() >= MAX_DAYS)
            return;

        week.add(day);
    }


    /**
     * Méthode qui retourne le nom du jour de la semaine
     * @param i  indice du jour souhaité dans le weekDays
     * @return retourne le nom du jour dont l'indice est passé en paramètre
     * */
    public String getWeekday(int i){
        return weekDays[i];
    }


    /**
     * Getter qui retourne la semaine
     * @return retourne la liste de jours de la semaine
     * */
    public ArrayList<Day> getWeek() {
        return week;
    }

}
