package studentlife;

import studentlife.characters.Etudiant;
import studentlife.characters.Professeur;
import studentlife.events.Cours;
import studentlife.events.Evenement;
import studentlife.events.PauseRepas;

//un jeu est composé d'une Personne et d'un EDT
//Faut-il mettre Jeu extedns Application pour mettre tout le bazar de javafx ici ?
public class Game {

    public static void main(String[] args) {

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
    }
}
