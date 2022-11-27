package studentlife.ui;

import studentlife.core.characters.Etudiant;
import studentlife.core.characters.Professeur;
import studentlife.core.Day;
import studentlife.core.Matiere;
import studentlife.core.Schedule;
import studentlife.core.events.Cours;
import studentlife.core.events.Evenement;
import studentlife.core.events.PauseRepas;

//un jeu est composé d'une Personne et d'un EDT
//Faut-il mettre Jeu extedns Application pour mettre tout le bazar de javafx ici ?
public class Game {

    public static void main(String[] args) {

        // Quizz --- Un scénario
        // ...........

        // Create some matiere
        Matiere anglais = new Matiere("Anglais");
        Matiere poo = new Matiere("POO");

        // Create a day and give it some events
        Day monday = new Day();
        Day tuesday = new Day();

        Evenement coursAnglais = new Cours(new Professeur("Prof", "Anglais"), anglais);
        Evenement coursPOO = new Cours(new Professeur("Prof", "POO"), poo);
        Evenement pauseMidi = new PauseRepas();

        monday.addEvenement(coursAnglais);
        monday.addEvenement(pauseMidi);
        tuesday.addEvenement(coursPOO);

        Schedule schedule = new Schedule();
        schedule.addDay(monday);
        schedule.addDay(tuesday);

        // Create a student
        Etudiant student = new Etudiant("Theo", "Dupont");

        System.out.println(student);

         /*
         Etudiant etudiant = new Etudiant("Gosling", "Ryan");

        //affichage de ses infos de depart
        System.out.print("\f");
        System.out.println(etudiant.getNomPrenom());
        etudiant.afficherStatsPerso();


        //creation des profs
        Professeur prof1 = new Professeur("Rooney", "Wayne");
        Professeur prof2 = new Professeur("Darko", "Donnie");
        Professeur prof3 = new Professeur("Snow", "Jon");
        Professeur prof4 = new Professeur("Austen", "Jane");
        Professeur prof5 = new Professeur("Lovelace", "Ada");
        Professeur prof6 = new Professeur("Corleone", "Vito");
        Professeur prof7 = new Professeur("Ventura", "Ace");


        System.out.println(prof1.getNomPrenom());
        System.out.println(prof1.getAffection() + "/100");

        //creation des matières
        Matiere ISI = new Matiere("Introduction aux systemes d'information", prof1);
        Matiere CDE = new Matiere("Connaissance de l'entreprise", prof6);
        Matiere POO = new Matiere("Programmation orientée objet", prof2);
        Matiere IF = new Matiere("Informatique fondamentale", prof3);
        Matiere MI = new Matiere("Mathématiques pour l'informatique", prof7);
        Matiere ASD = new Matiere("Algorithmique et structure de données", prof5);
        Matiere Ang = new Matiere("Anglais scientifique général", prof4);

        //ajout de liste de cours possibles pour chaque matière
        ISI.addCours(Type.CM, Type.TD, Type.TP);
        CDE.addCours(Type.TD);
        POO.addCours(Type.CM, Type.TD, Type.TP);
        IF.addCours(Type.CM, Type.TD, Type.TP);
        MI.addCours(Type.CM, Type.TD);
         */
    }
}
