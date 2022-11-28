package studentlife.controller;

import studentlife.core.Day;
import studentlife.core.Matiere;
import studentlife.core.Schedule;
import studentlife.core.actions.Quiz;
import studentlife.core.characters.Etudiant;
import studentlife.core.characters.Professeur;
import studentlife.core.events.Cours;
import studentlife.core.events.Evenement;
import studentlife.core.events.Pause;

import java.util.ArrayList;

import static studentlife.core.events.CoursType.*;

public class GameController {
    private Etudiant user;
    private final ArrayList<Matiere> subjectList = new ArrayList<>();
    private final ArrayList<Professeur> profList = new ArrayList<>();
    private final Schedule schedule;

    public GameController(){
        this.schedule = new Schedule();
    }

    public void initGame(String userLastName, String userFirstName){
        user = new Etudiant(userLastName, userFirstName);
        createProfs();
        createSubjects();
        createSchedule();
        addNewQuiz();
    }

    public Etudiant getUser() {
        return user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    private void createDay1() {
        Day monday = new Day();

        monday.addEvenement(new Cours(CM, profList.get(0), subjectList.get(0)));
        monday.addEvenement(new Cours(TD, profList.get(1), subjectList.get(1)));
        monday.addEvenement(new Pause());
        monday.addEvenement(new Cours(TD, profList.get(2), subjectList.get(2)));
        monday.addEvenement(new Cours(TD, profList.get(0), subjectList.get(0)));

        schedule.addDay(monday);
    }


    
    private void createSchedule(){
        createDay1();
    }

    private void createSubjects(){

        subjectList.add(new Matiere("Introduction aux systemes d'information")); //0
        subjectList.add(new Matiere("Connaissance de l'entreprise")); //1
        subjectList.add(new Matiere("Programmation orientée objet")); //2
        subjectList.add(new Matiere("Informatique fondamentale")); //3
        subjectList.add(new Matiere("Mathématiques pour l'informatique")); //4
        subjectList.add(new Matiere("Algorithmique et structure de données")); //5
        subjectList.add(new Matiere("Anglais scientifique général")); //6


    }



    private void createProfs(){
        profList.add(new Professeur("Rooney", "Wayne")); //0
        profList.add(new Professeur("Darko", "Donnie")); //1
        profList.add(new Professeur("Snow", "Jon")); //2
        profList.add(new Professeur("Austen", "Jane")); //3
        profList.add(new Professeur("Lovelace", "Ada")); //4
        profList.add(new Professeur("Corleone", "Vito")); //5
        profList.add(new Professeur("Ventura", "Ace")); //6
    }

    private void addNewQuiz(){
        subjectList.get(0).addQuiz(new Quiz("Un Automate Fini est composé de: ", "Arcs, ", subjectList.get(1), "3","4","811"));
        subjectList.get(1).addQuiz(new Quiz("Une Société Anonyme (SA) cotee en bourse à un minimum de: ", "7 actionnaires", subjectList.get(1), "2 Actionnaires","1 Actionnaire","5 Actionnaires"));
        subjectList.get(1).addQuiz(new Quiz("Une interface peut posseder", "des methodes abstraites", subjectList.get(1), "des attributs","des methodes implementees","des attributs abstraits"));
        subjectList.get(1).addQuiz(new Quiz("1+1 = ? ", "2", subjectList.get(1), "3","4","811"));
        subjectList.get(1).addQuiz(new Quiz("1+1 = ? ", "2", subjectList.get(1), "3","4","811"));

    }

    private void loadSchedule(){
        String tiret = "";
        String pause = "Pause";
        String csvFile = "/home/enzo/Bureau/test/edt.csv";
        String line = "";
        String csvSplitBy = ",";
        int i = 0, j = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {


            this.schedule = new Schedule;
            while ((line = br.readLine()) != null) {
                String[] cours = line.split(csvSplitBy);
                Day jour = new Day;
                Schedule.add(jour);
                while (cours[0].equals(tiret)){
                    if(!(cours[0].equals(pause))){
                        while(this.profList.get(i).getNom().equals(cours[2]) && i<=profList.size()){
                            i++;
                        }
                        while(this.subjectList.get(j).getNom.equals(cours[0]) && j<=subjectList.size()){
                            j++;
                        }
                        if(Cours[1].equals("CM")){
                            jour.addEvenement(new Cours(CoursType.CM, this.subjectList.get(j), this.profList.get(i)));
                        }
                        if(Cours[1].equals("TD")){
                            jour.addEvenement(new Cours(CoursType.TD, this.subjectList.get(j), this.profList.get(i)));
                        }
                        if(Cours[1].equals("TP")){
                            jour.addEvenement(new Cours(CoursType.TP, this.subjectList.get(j), this.profList.get(i)));
                        }
                    }
                    else{
                        jour.addEvenement(new Pause());
                    }
                }
                this.schedule.add(jour);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
