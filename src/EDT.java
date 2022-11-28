import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


//Un EDT est une représentation sur une semaine, donc composé de plusieurs Jour
public class EDT {
    private ArrayList<ArrayList<Creneaux>> emploisDuTemps;

    public EDT() {
        this.emploisDuTemps = new ArrayList<ArrayList<Creneaux>>();
        for (int i = 0; i < 6; i++)  {
            this.emploisDuTemps.add(new ArrayList<>());
        }
    }

    public ArrayList<ArrayList<Creneaux>> getEmploisDuTemps(){
        return this.emploisDuTemps;
    }
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
}
