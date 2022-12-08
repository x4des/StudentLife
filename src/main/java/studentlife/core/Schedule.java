package studentlife.core;

import java.util.ArrayList;

/**
 *La classe Schedule représente l'emploi du temps de la semaine.
 Elle est composée d'une liste de jour
 * @see Day
 * }
 * */
public class Schedule {

    /**Var static qui indique le nombre max de jour d'école dans la semaine.*/
    private static final int MAX_DAYS = 5;

    /**liste des noms des jours dans la semaine.*/
    private final String[] weekDays;

    /**la semaine*/
    private final ArrayList<Day> week;


    /**
     * Premier constructeur de Schedule
     * */
    public Schedule() {
        this.week = new ArrayList<>();
        this.weekDays = new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
    }

    /**@return retourne une liste de jour = semaine
     * getter de l'attribut week.
     * */
    public ArrayList<String> getWeekDaysAsList(){
        ArrayList<String> week = new ArrayList<>();
        for (String day : weekDays){
            week.add(day);
        }
        return week;

    }

    /**
     * @param day un jour dans la semaine
     * ajoute un jour dans la semaine lorsque l'EDT n'est pas complet (5 jours)
     * */
    public void addDay(Day day) {

        if(week.size() >= MAX_DAYS)
            return;

        week.add(day);
    }

    /**
     * @param i  indice du jour souhaité dans le weekDays
     * @return retourne le jour dont l'indice est passé en paramètre
     * */
    public String getWeekday(int i){
        return weekDays[i];
    }

    /**
     * @return retourne la liste de jour de la semaine
     * */
    public ArrayList<Day> getWeek() {
        return week;
    }

}
