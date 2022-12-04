package studentlife.core;

import java.util.ArrayList;

/**
 *La classe Schedule represente l'emploi du temps de la semaine.
 Elle est composé d'une liste de jour
 * @see Day.java
 * }
 * */
public class Schedule {

    private static final int MAX_DAYS = 5;
    private final String[] weekDays;

    private ArrayList<Day> week;


    /**
     * Premier constructeur de Schedule
     * */
    public Schedule() {
        this.week = new ArrayList<>();
        this.weekDays = new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
    }

    /**
     * Deuxieme constructeur
     * @param csvPath le nom d'un fichier csv, charge/rempli le EDT a partir du fichier csv.
     * */
    public Schedule(String csvPath) {
        this.weekDays =new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
        this.loadEDT(csvPath);
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

    private void loadEDT(String path) {

        this.week = new ArrayList<>();
        // TO DO
    }

    /*
    public void lireDoc(){
        String csvFile = "/home/enzo/Bureau/test/edt.csv";
        String line = "";
        String csvSplitBy = ",";
        Creneaux creneaux;
        int i = 0, j = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] cours = line.split(csvSplitBy);
                creneaux = new Creneaux(cours[0], cours[1], cours[2]);
                emploisDuTemps.get(i).add(creneaux);
                j++;
                if(j == 7){
                    j = 0;
                    i++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void afficherDoc(){
        for(int i = 0; i < this.emploisDuTemps.size(); i++){
            for(int j = 0; j < this.emploisDuTemps.get(i).size(); j++)
                this.emploisDuTemps.get(i).get(j).writte();
        }
    }
    */
}
