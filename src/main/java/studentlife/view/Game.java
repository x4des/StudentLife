package studentlife.view;

import studentlife.controller.GameController;
import studentlife.core.Day;
import studentlife.core.events.*;

import java.util.Scanner;

public class Game {

    private final GameController gameController;


    public Game(GameController gameController) {
        this.gameController = gameController;
    }

    private void initGameView() {
        // Get user details
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Firstname");
        String firstName = scanner.nextLine();

        System.out.println("Enter Lastname:");
        String lastName = scanner.nextLine();

        gameController.initGame(lastName, firstName);

        System.out.println("Welcome " + gameController.getUser().getNom() + " " + gameController.getUser().getPrenom());
        System.out.println(gameController.getUser().getStats().toString());
    }



    public void run() {
        // LANCER LE JEU :)
        int i = -1;
        initGameView();

        for (Day day : gameController.getSchedule().getWeek()) {
            i++;
            for (Evenement event : day.getEvenements()) {
                manageEvent(event);



            }
            dailyResults(i);
        }
    }

    private void manageEvent(Evenement event) {
        if(event instanceof Cours)
            manageCours((Cours) event);
        else
            managePause((Pause) event);
    }

    public void manageCours(Cours cours) {
        System.out.println("Cours de " + cours.getMatiere().getNom());
        System.out.println("Quiz dans " + cours.getNom() + " " + cours.getMatiere().getNom());
        cours.getMatiere().getListeQuiz().get(0).realiserQuiz();
        cours.getMatiere().deleteQuiz(0);
    }

    public void managePause(Pause pause) {
        System.out.println("Y a une pause a gérer");
    }

    public void dailyResults( int i){
        System.out.println("Les resultats du fin de la journée: "+gameController.getSchedule().getWeekday(i));
        System.out.println("Stats perso: "+ gameController.getUser().getStats().toString());
        gameController.subjectsMastery();
    }
}
