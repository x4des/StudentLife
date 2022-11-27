package studentlife.core;

import studentlife.core.Day;

import java.util.ArrayList;

public class Schedule {

    private static final int MAX_DAYS = 7;

    private ArrayList<Day> week;

    public Schedule() {
        this.week = new ArrayList<>();
    }

    public Schedule(String csvPath) {
        this.loadEDT(csvPath);
    }

    public void addDay(Day day) {

        if(week.size() >= MAX_DAYS)
            return;

        week.add(day);
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
        int i = 0, j = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] cours = line.split(csvSplitBy);
                creneaux = new Creneaux(cours[0], cours[1]);
                emploisDuTemps.get(i).add(creneaux);
                j++;
                if(j == 8){
                    j = 1;
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
