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

import static studentlife.core.events.CoursType.*;

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
     * La liste de matières de l'étudiant
     * @see Matiere
     * */
    private final ArrayList<Matiere> subjectList = new ArrayList<>();

    /**
     * la liste de professeurs de l'étudiant
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

        loadProf(); //instancie les profs

        loadSubject(); //instancie les matières

        loadSchedule(); //instancie l'EDT

        loadNewQuiz(); //instancie les quizz
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
    private void loadProf(){
        File file = new File("assets/prof.csv"); //Créer un objet File qui contiendra l'emplacement du fichier voulu.
        String csvFile = file.getPath(); //Récupere le chemin d'accès complet au fichier prof.csv
        String line = "";
        String csvSplitBy = ",";    //Variable qui contient le "séparateur" du fichier csv.

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) { // Essaie d'acceder au fichier et renvois une erreur
                                                                                // si le chemin est faut.
            while((line = br.readLine()) != null){  //Boucle pour parcourir chaque ligne du fichier.
                String[] prof = line.split(csvSplitBy); //On récupère le contenu de la ligne divisé à chaque caractère
                                                        //précisé plus haut dans csvSpliBy.
                profList.add(new Professeur(prof[0],prof[1]));  //On créé un nouveau prof avec les informations récupérer dans le fichier.
            }
        } catch (IOException e) {   //Si le fichier n'est pas trouvé l'exception est propagée.
            e.printStackTrace();
        }

    }

    /**
     * Procédure qui permet de "charger" les matières depuis
     * le fichier matiere.csv
     */
    private void loadSubject(){
        File file = new File("assets/matiere.csv"); //Créer un objet File qui contiendra l'emplacement du fichier voulu.
        String csvFile = file.getPath();    //Récupere le chemin d'accès complet au fichier prof.csv
        String line = "";
        String csvSplitBy = ",";    //Variable qui contient le "séparateur" du fichier csv.

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) { // Essaie d'acceder au fichier et renvois une erreur
                                                                                // si le chemin est faut.
            while((line = br.readLine()) != null){  //Boucle pour parcourir chaque ligne du fichier.
                String[] matiere = line.split(csvSplitBy);  //On récupère le contenu de la ligne divisé à chaque caractère
                                                            //précisé plus haut dans csvSpliBy.
                subjectList.add(new Matiere(matiere[0]));   //On créé une nouvelle matiere avec les informations récupérer dans le fichier.
            }
        } catch (IOException e) {   //Si le fichier n'est pas trouvé l'exception est propagée.
            e.printStackTrace();
        }

    }

    /**
     * Procédure qui permet de "charger" les quiz depuis
     * le fichier quiz.csv, nous pouvons donc ajouter autant
     * de quiz que voulus.
     */
    private void loadNewQuiz(){
        File file = new File("assets/quiz.csv"); //Créer un objet File qui contiendra l'emplacement du fichier voulu.
        String csvFile = file.getPath();    //Récupere le chemin d'accès complet au fichier prof.csv
        String line = "";
        String csvSplitBy = ",";    //Variable qui contient le "séparateur" du fichier csv.
        int j = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) { // Essaie d'acceder au fichier et renvois une erreur
                                                                                // si le chemin est faut.
            while((line = br.readLine()) != null){  //Boucle pour parcourir chaque ligne du fichier.
                String[] quiz = line.split(csvSplitBy);     //On récupère le contenu de la ligne divisé à chaque caractère
                                                            //précisé plus haut dans csvSpliBy.
                while (j < subjectList.size() && !(this.subjectList.get(j).getNom().equals(quiz[0]))) { //On récupère dans j l'indice de la matiere
                    j++;                                                                                //corespondant au quiz lu précédement.
                }
                subjectList.get(j).addQuiz(new Quiz(subjectList.get(j),quiz[1],quiz[2],quiz[3],quiz[4],quiz[5])); //On créé un nouveau quiz avec les informations récupérer dans le fichier.
            }
        } catch (IOException e) { //Si le fichier n'est pas trouvé l'excption est propagée.
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
        String tiret = "-"; //Variable contenant le séparateur de Jour.
        String pause = "Pause";
        File file = new File("assets/edt.csv"); //Créer un objet File qui contiendra l'emplacement du fichier voulu.
        String csvFile = file.getPath();    //Récupere le chemin d'accès complet au fichier prof.csv
        String line = "";
        String csvSplitBy = ",";    //Variable qui contient le "séparateur" du fichier csv.
        String c;
        int i, j;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) { // Essaie d'acceder au fichier et renvois une erreur
                                                                                // si le chemin est faut.

            while (test1) { //Boucle qui parcour toute la semaine.
                Day jour = new Day(); //Création d'un nouveau jour.
                test = true;
                while (test) {  //Boucle qui parcour une journnée.
                    line = br.readLine(); //Lecture d'une ligne du fichier.
                    if(line != null){ //Vérifie si l'on est pas arrivé à la fin du fichier.
                        String[] cours = line.split(csvSplitBy);    //Divise la ligne avec le "séparateur" donné dans csvSplitBy.
                        if (!(cours[0].equals(tiret)) && !(cours[0].equals(pause))) { // Vérifie si l'on est pas arrivé à la fin d'une journée.

                            i = 0;  //Déclaration des indices pour la recherche dans les listes.
                            j = 0;
                            while (i < profList.size() && !(this.profList.get(i).getNom().equals(cours[2]))) {  //Recherche le bon prof dans la liste par rapport à celui récuperé dans le fichier csv.
                                i++;
                            }
                            c = cours[0];
                            while (j < subjectList.size() && !(this.subjectList.get(j).getNom().equals(c))) {   //Recherche la bonne matière dans la liste par rapport à celle récuperé dans le fichier csv.
                                j++;
                            }
                            if (cours[1].equals("CM")) {    //Vérifie si le cours présent dans le fichier est un CM.
                                jour.addEvenement(new Cours(CM, this.profList.get(i) ,this.subjectList.get(j)));    //Ajoute l'évènement approprié au jour dans lequel on se situe.
                            };    //Ajoute l'évènement approprié au jour dans lequel on se situe.

                            if (cours[1].equals("TD")) {    //Vérifie si le cours présent dans le fichier est un TD.
                                jour.addEvenement(new Cours(TD, this.profList.get(i), this.subjectList.get(j)));    //Ajoute l'évènement approprié au jour dans lequel on se situe.
                            }
                            if (cours[1].equals("TP")) {    //Vérifie si le cours présent dans le fichier est un TP.
                                jour.addEvenement(new Cours(TP, this.profList.get(i) ,this.subjectList.get(j)));    //Ajoute l'évènement approprié au jour dans lequel on se situe.
                            }
                        }
                        if (cours[0].equals(pause)){    //Vérifie si le créneau récupérer dans le fichier est une pause
                            jour.addEvenement(new Pause()); //Ajoute l'évènement approprié au jour dans lequel on se situe.
                        }
                        if(cours[0].equals(tiret)){ //Vérifie si l'on a récupérer un tiret dans le fichier.
                            test = false;   //test prend la valeur false si un tiret est rencontré et permet de sortir de la boucle.
                        }
                    }
                    if (line == null){ //Vérifie si on est arrivé à la fin du fichier et si oui passe les booléens à false.
                        test = false;
                        test1 = false;
                    }
                }
                this.schedule.addDay(jour); //Ajoute le jour à l'emplois du temps.
            }

        } catch (IOException e) {   //Si le fichier n'est pas trouvé l'excption est propagée.
            e.printStackTrace();
        }
    }
}

