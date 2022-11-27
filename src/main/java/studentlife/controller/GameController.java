package studentlife.controller;

import studentlife.core.Day;
import studentlife.core.Matiere;
import studentlife.core.Schedule;
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

        subjectList.add(new Matiere("Introduction aux systemes d'information"));
        subjectList.add(new Matiere("Connaissance de l'entreprise"));
        subjectList.add(new Matiere("Programmation orientée objet"));
        subjectList.add(new Matiere("Informatique fondamentale"));
        subjectList.add(new Matiere("Mathématiques pour l'informatique"));
        subjectList.add(new Matiere("Algorithmique et structure de données"));
        subjectList.add(new Matiere("Anglais scientifique général"));
    }

    private void createProfs(){
        profList.add(new Professeur("Rooney", "Wayne"));
        profList.add(new Professeur("Darko", "Donnie"));
        profList.add(new Professeur("Snow", "Jon"));
        profList.add(new Professeur("Austen", "Jane"));
        profList.add(new Professeur("Lovelace", "Ada"));
        profList.add(new Professeur("Corleone", "Vito"));
        profList.add(new Professeur("Ventura", "Ace"));
    }


}
