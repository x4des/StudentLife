package studentlife.core;

import java.util.ArrayList;

/**
 *La classe Schedule represente l'emploi du temps de la semaine.
 Elle est composé d'une liste de jour
 * @see Day
 * }
 * */
public class Schedule {

    private static final int MAX_DAYS = 5;
    private final String[] weekDays;

    private final ArrayList<Day> week;


    /**
     * Premier constructeur de Schedule
     * */
    public Schedule() {
        this.week = new ArrayList<>();
        this.weekDays = new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
    }

    /**
     * @param day un jour dans la semaine
     * ajoute un jour dans la semaine lorsque l'EDT n'est pas complet (<5 jours)
     * */
    public void addDay(Day day) {

        if(week.size() >= MAX_DAYS)
            return;

        week.add(day);
    }

    /**
     * @param i  indice du jour souhaité dans le weekDays
     * @return retrourne le jour dont l'indice est passé en parametre
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
