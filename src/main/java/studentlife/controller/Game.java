package studentlife.controller;


import studentlife.core.Day;
import studentlife.core.Matiere;
import studentlife.core.Schedule;
import studentlife.core.characters.Etudiant;
import studentlife.core.characters.Professeur;
import studentlife.core.characters.Stat;
import studentlife.core.events.Cours;
import studentlife.core.events.Evenement;
import studentlife.core.events.PauseRepas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//un jeu est composé d'une Personne et d'un EDT
//Faut-il mettre Jeu extedns Application pour mettre tout le bazar de javafx ici ?
public class Game {
    private Etudiant user;
    private final ArrayList<Matiere> subjectList = new ArrayList<>();
    private final ArrayList<Professeur> profs = new ArrayList<>();
    private Schedule schedule;

    public Game(){

    }

    public void initGame(){
        createSubjects();
    }

    private void createSchedule(){

        Professeur prof1 = new Professeur("Rooney", "Wayne");
        Professeur prof2 = new Professeur("Darko", "Donnie");
        Professeur prof3 = new Professeur("Snow", "Jon");
        Professeur prof4 = new Professeur("Austen", "Jane");
        Professeur prof5 = new Professeur("Lovelace", "Ada");
        Professeur prof6 = new Professeur("Corleone", "Vito");
        Professeur prof7 = new Professeur("Ventura", "Ace");



        Day monday = new Day();

        Evenement event1 = new Cours(prof1, subjectList.get(0));
        Evenement event2 = new Cours(prof2, subjectList.get(1));
        Evenement even3 = new P

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

    public void createProfs(){


    }


}
