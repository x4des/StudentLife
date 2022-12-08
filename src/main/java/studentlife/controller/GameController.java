/**
 * Contient la classe qui instancie et affecte des valeurs aux différents objets que la
 simulation utilise
 * */
package studentlife.controller;

import studentlife.core.Day;
import studentlife.core.Matiere;
import studentlife.core.Schedule;
import studentlife.core.actions.Quiz;
import studentlife.core.characters.Etudiant;
import studentlife.core.characters.Professeur;
import studentlife.core.events.Cours;
import studentlife.core.events.CoursType;
import studentlife.core.events.Pause;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static studentlife.core.events.CoursType.CM;
import static studentlife.core.events.CoursType.TD;

/**
 * La classe GameController est la classe dans laquelle on instancie les classes
 nécessaires pour que le jeu fonctionne.
 On affecte les valeurs nécessaires au bon fonctionnement de la simulation
 tel que les matières, la liste des profs, des cours, les quiz éventuels etc...
 * */
public class GameController {

    /**
     * l'utilisateur
     * @see Etudiant
     * */
    private Etudiant user;

    /**
     * La liste de matière de l'etudiant
     * @see Matiere
     * */
    private final ArrayList<Matiere> subjectList = new ArrayList<>();

    /**
     * la liste de professeur de l'étudiant
     * @see Professeur
     * */
    private final ArrayList<Professeur> profList = new ArrayList<>();

    /**
     * l'emploi du temps
     * @see Schedule
     * */
    private final Schedule schedule;

    /**
     * le constructeur de la classe GameController
     (que pour l'attribut schedule).
     * */
    public GameController() {
        this.schedule = new Schedule();
    }

    /**
     * @param userLastName user lastname
     * @param userFirstName user first name
     * on initialise le game en créant une Personne qui est l'étudiant,
     on aura donc son nom, son prénom, ses professeurs, ses matières, son EDT et ses questions de quiz.
     Tout cela grace aux méthodes associées.
     * */
    public void initGame(String userLastName, String userFirstName) {
        user = new Etudiant(userLastName, userFirstName);

        loadProf();

        loadSubject();

        loadSchedule();

        loadNewQuiz();
    }

    /**
     * @return  getter qui permet d'accéder au user de la classe
     * */
    public Etudiant getUser() {
        return user;
    }

    /**
     * @return getter de schedule
     * */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * @return getter de profList.
     * */
    public ArrayList<Professeur> getProfList() {
        return profList;
    }

    /**
     * Procédure qui permet de "charger" les professeurs depuis
     * le fichier prof.csv
     */
    public void loadProf(){
        File file = new File("assets/prof.csv");
        String csvFile = file.getPath();
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while((line = br.readLine()) != null){
                String[] prof = line.split(csvSplitBy);

                profList.add(new Professeur(prof[0],prof[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Procédure qui permet de "charger" les matières depuis
     * le fichier matiere.csv
     */
    public void loadSubject(){
        File file = new File("assets/matiere.csv");
        String csvFile = file.getPath();
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while((line = br.readLine()) != null){
                String[] matiere = line.split(csvSplitBy);

                subjectList.add(new Matiere(matiere[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Procédure qui permet de "charger" les quiz depuis
     * le fichier quiz.csv, nous pouvons donc ajoutez autant
     * de quiz que voulus.
     */
    public void loadNewQuiz(){
        File file = new File("assets/quiz.csv");
        String csvFile = file.getPath();
        String line = "";
        String csvSplitBy = ",";
        int j = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while((line = br.readLine()) != null){
                String[] quiz = line.split(csvSplitBy);

                while (j < subjectList.size() && !(this.subjectList.get(j).getNom().equals(quiz[0]))) {
                    j++;
                }
                subjectList.get(j).addQuiz(new Quiz(subjectList.get(j),quiz[1],quiz[2],quiz[3],quiz[4],quiz[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * @return getter pour la liste de matière de la classe.
     * */
    public ArrayList<Matiere> getSubjectList() {
        return subjectList;
    }

    /**Crée l'EDT en chargeant les éléments de l'emploi du temps avec le fichier edt.csv*/
    private void loadSchedule() {
        boolean test;
        boolean test1 = true;
        String tiret = "-";
        String pause = "Pause";
        File file = new File("assets/edt.csv");
        String csvFile = file.getPath();
        String line = "";
        String csvSplitBy = ",";
        String c;
        int i, j;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {


            while (test1) {
                Day jour = new Day();
                test = true;
                while (test) {
                    line = br.readLine();
                    if(line != null){
                        String[] cours = line.split(csvSplitBy);
                        if (!(cours[0].equals(tiret)) && !(cours[0].equals(pause))) {

                            i = 0;
                            j = 0;
                            while (i < profList.size() && !(this.profList.get(i).getNom().equals(cours[2]))) {
                                i++;
                            }
                            c = cours[0];
                            while (j < subjectList.size() && !(this.subjectList.get(j).getNom().equals(c))) {
                                j++;
                            }
                            if (cours[1].equals("CM")) {
                                jour.addEvenement(new Cours(CM, this.profList.get(i) ,this.subjectList.get(j)));
                            }
                            if (cours[1].equals("TD")) {
                                jour.addEvenement(new Cours(TD, this.profList.get(i) ,this.subjectList.get(j)));
                            }
                            if (cours[1].equals("TP")) {
                                jour.addEvenement(new Cours(CoursType.TP, this.profList.get(i) ,this.subjectList.get(j)));
                            }
                        }
                        if (cours[0].equals(pause)){
                            jour.addEvenement(new Pause());
                        }
                        if(cours[0].equals(tiret)){
                            test = false;
                        }
                    }
                    if (line == null){
                        test = false;
                        test1 = false;
                    }
                }
                this.schedule.addDay(jour);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

