package studentlife.core;

import java.util.ArrayList;

/**
 * {@literal La classe Schedule represente l'emploi du temps de la semaine.
 Elle est composé d'une liste de jour
 * @see Day.java
 * }
 * */
public class Schedule {

    private static final int MAX_DAYS = 5;
    private final String[] weekDays;

    private ArrayList<Day> week;



    public Schedule() {
        this.week = new ArrayList<>();
        this.weekDays = new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
    }

    public Schedule(String csvPath) {
        this.weekDays =new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
        this.loadEDT(csvPath);
    }

    public void addDay(Day day) {

        if(week.size() >= MAX_DAYS)
            return;

        week.add(day);
    }

    public String getWeekday(int i){
        return weekDays[i];
    }

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
