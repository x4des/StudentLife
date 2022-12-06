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
 necessaires pour que le jeu fonctionne.
 on affecte les valeurs necessaire au bon fonctionnement de la simulation
 tel que les matières, la liste des profs, des cours, les quiz eventuels etc...
 * */
public class GameController {
    private Etudiant user;
    private final ArrayList<Matiere> subjectList = new ArrayList<>();
    private final ArrayList<Professeur> profList = new ArrayList<>();
    private final Schedule schedule;

    /**
     * le contructeur de la classe GameController
     (que pour l'attribut schedule).
     * */
    public GameController() {
        this.schedule = new Schedule();
    }

    /**
     * @param userLastName user lastname
     * @param userFirstName user first name
     * on initialise le game en creant une Personne qui est l'etudiant,
     on aura donc son nom, son prenom, ses professeurs, ses matières, son EDT et ses questions de quiz.
     Tout cela grace au methodes les creants.
     * */
    public void initGame(String userLastName, String userFirstName) {
        user = new Etudiant(userLastName, userFirstName);
        createProfs();
        createSubjects();
        createSchedule();
        //loadSchedule();
        addNewQuiz();
    }

    /**
     * @return  getter qui permet d'acceder au user de la classe
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

    public ArrayList<Professeur> getProfList() {
        return profList;
    }


    /**
     * cette methode ajoute une par une, les matieres de l'etudiant dans la liste de matières.
     * */
    private void createSubjects() {

        subjectList.add(new Matiere("Introduction aux systemes d'informations")); //0
        subjectList.add(new Matiere("Connaissance de l'entreprise")); //1
        subjectList.add(new Matiere("Programmation orientée objet")); //2
        subjectList.add(new Matiere("Informatique fondamentale")); //3
        subjectList.add(new Matiere("Mathématiques pour l'informatique")); //4
        subjectList.add(new Matiere("Algorithmique et structure de données")); //5
        subjectList.add(new Matiere("Anglais scientifique général")); //6
    }

    /**
     * ajoute des professeurs a la liste de professeur (nom et prenom).
     * */
    private void createProfs() {
        profList.add(new Professeur("Rooney", "Wayne")); //0 - ISI
        profList.add(new Professeur("Darko", "Donnie")); //1 - CdE
        profList.add(new Professeur("Snow", "Jon")); //2 - POO
        profList.add(new Professeur("Austen", "Jane")); //3 - ENG
        profList.add(new Professeur("Lovelace", "Ada")); //4 - ASD
        profList.add(new Professeur("Corleone", "Vito")); //5 - MI
        profList.add(new Professeur("Ventura", "Ace")); //6 - InfoF
    }



    /**
     * cette methode, créer le premier jour de l'EDT de l'etudiant
     l'etudiant aura le lundi; un CM et un TD le matin, une pause et 2 TD l'apre midi.
     * */
    private void createDay1() {
        Day monday = new Day();

        monday.addEvenement(new Cours(CM, profList.get(0), subjectList.get(0)));
        monday.addEvenement(new Cours(TD, profList.get(1), subjectList.get(1)));
        monday.addEvenement(new Pause());
        monday.addEvenement(new Cours(TD, profList.get(2), subjectList.get(2)));
        monday.addEvenement(new Cours(TD, profList.get(0), subjectList.get(0)));

        schedule.addDay(monday);
    }

    private void createDay2() {
        Day tuesday = new Day();

        tuesday.addEvenement(new Cours(CM, profList.get(6), subjectList.get(3)));
        tuesday.addEvenement(new Cours(CM, profList.get(5), subjectList.get(4)));
        tuesday.addEvenement(new Cours(TD, profList.get(4), subjectList.get(5)));
        tuesday.addEvenement(new Pause());
        tuesday.addEvenement(new Cours(TD, profList.get(2), subjectList.get(2)));
        tuesday.addEvenement(new Cours(TD, profList.get(0), subjectList.get(0)));

        schedule.addDay(tuesday);
    }


    /**
     * crée l'EDT
     * */
    private void createSchedule() {
        createDay1();
        createDay2();
    }








    /**
     * Cette methode ajoute des quiz pour chaque matières
     * */
    private void addNewQuiz() {
        //ISI
        subjectList.get(0).addQuiz(new Quiz("Un automate normalise a forcement", "deux etats: initial et final unique chacun", subjectList.get(0), "la propriete qu'il soit complet", "un etat initial unique", "un etat final unique"));
        subjectList.get(0).addQuiz(new Quiz("Une transition \"puits\" : ", " ne produit rien, se contente de consommer", subjectList.get(0), "ne consomme rien, se contente de produire", "est toujours déclenchable", "possède absolument un arc inhibiteur"));
        subjectList.get(0).addQuiz(new Quiz("Un automate est deterministe si", "Il possède un unique état initial", subjectList.get(0), "Il possède des epsilon-transitions", "Il possède une seule epsilon-transition", "Il est complet"));
        subjectList.get(0).addQuiz(new Quiz("Un automate est standard si ", "Il est unitaire et possede un unique état initial", subjectList.get(0), "Il est complet et deterministe", "Il est fini", "Il n'y pas de transition sur vers son etat initial"));
        //CE
        subjectList.get(1).addQuiz(new Quiz("Une societe anonyme SA cotée sur la bourse doit avoir un minimum de:", "7 associes", subjectList.get(1), "2 associes", "Pas de minimum", "8 associes"));
        subjectList.get(1).addQuiz(new Quiz("Quel organisme calcule et diffuse l'indice des prix", "INSEE", subjectList.get(1), "FISC", "INTERPOL", "CNOUS"));
        subjectList.get(1).addQuiz(new Quiz("Lequel des suivants est correct", "les SCOP et SCIC sont des CAE", subjectList.get(1), "Une SARL est une SA a responsabiite limitee", "Une association est une societe a but non lucratif", "Une µEntreprise possede au plus 20 employes"));
        //POO
        subjectList.get(2).addQuiz(new Quiz("Une classe est:", "Du code source ", subjectList.get(2), "Un objet avec des attributs et des methodes", "une interface avec des methodes non abstraites", "abstraite quand elle possede un constructeur abstrait"));
        subjectList.get(2).addQuiz(new Quiz("L'agregation:", "est plus forte que l'association", subjectList.get(2), "est moins forte que l'association", "est synonyme de l'association", "depend de l'association"));
        subjectList.get(2).addQuiz(new Quiz("en UML, quel signe caractere represente un package", "~", subjectList.get(2), "+", "$", "#"));
        subjectList.get(2).addQuiz(new Quiz("Une interface ne fait pas partie du framework collection en Java", "Group", subjectList.get(2), "Collection", "List", "Set"));
        //IF
        subjectList.get(3).addQuiz(new Quiz("Lequel n'est pas vrai:", "Un ordre est noetherien s'il est bien fonde", subjectList.get(3), "Un ordre est bien fonde si et seulement s'il est noetherien", "Un ordre est bien fonde si tout partie non vide admet au moins un element minimal", "Un ordre est noetherien s'il ne possede pas de chaine infinie strictement decroissante"));
        subjectList.get(3).addQuiz(new Quiz("Lequel est vrai", "Une fonction continue n'est pas necessairement derivable", subjectList.get(3), "Un isomorphisme d'ordre est un morphisme non bijectif", "La double implication n'implique pas toujours qu'il y a l'egalite", "Un ordre est strict s'il est reflexif"));
        subjectList.get(3).addQuiz(new Quiz("Un ensemble ordonne est dit inductif si", "toute chaine admet un majorant", subjectList.get(3), "Tout ensemble ordonne inductif possede un majorant", "son application est bijective", "son application n'est pas surjective"));
        //MI
        subjectList.get(4).addQuiz(new Quiz("Une relation est binaire si elle est:", "Reflexive, antisymmetrique, transitive", subjectList.get(4), "Reflexive, symmetrique, transitive", "Reflexive, asymmetrique, transitive", "Antireflexive, antisymmetrique, transitive"));
        subjectList.get(4).addQuiz(new Quiz("La limite de Ln(x) en -infini: ", "n'existe pas", subjectList.get(4), "0", "-ifnini", "1"));
        //ASD
        subjectList.get(5).addQuiz(new Quiz("le stack est:", "LIFO", subjectList.get(5), "FIFO", "accessible dynamiquement", "plus lent en acces que le heap"));
        subjectList.get(5).addQuiz(new Quiz("Choisir l'affirmation correcte:", "les elements d'une liste chainée sont de même type", subjectList.get(5), "Il faut allouer de la memoire dynamique dans le stack pour les tableaux dynamiques", "l'operateur \"->\" equivaut à &ptr", "La taille d'un int depend uniquement de la machine"));
        //ANG
        subjectList.get(6).addQuiz(new Quiz("The Earth is ...(hold) by the gravity of the Sun and orbits around it", "held", subjectList.get(6), "being held", "holded", "being holded"));


    }


    /**
     * @return getter pour la liste de matière de la classe.
     * */
    public ArrayList<Matiere> getSubjectList() {
        return subjectList;
    }


    private void loadSchedule() {
        boolean test;
        boolean test1 = true;
        String tiret = "-";
        String pause = "Pause";
        File file = new File("assets/edt.csv");
        String csvFile = file.getAbsolutePath(); //+ //"src/main/java/studentlife/controller/edt.csv";
        System.out.println(csvFile);
        String line;
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
                            System.out.println(cours[0]);
                            while (i < profList.size() && !(this.profList.get(i).getNom().equals(cours[2]))) {
                                i++;
                            }
                            System.out.println(i);
                            c = cours[0];
                            while (j < subjectList.size() && !(this.subjectList.get(j).getNom().equals(c))) {
                                System.out.println(j);
                                j++;
                            }
                            System.out.println(j);
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
            int k=0;
            int l=0;
            while( k!= this.schedule.getWeek().size()){
                while(l != this.schedule.getWeek().get(k).getEvenements().size()){
                    if(this.schedule.getWeek().get(k).getEvenements().get(l) instanceof Cours) {
                        System.out.println(((Cours) this.schedule.getWeek().get(k).getEvenements().get(l)).getMatiere().getNom());
                    }
                    else{
                        System.out.println("Pause");
                    }
                    l++;
                }
                k++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

