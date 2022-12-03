package studentlife.view;

import studentlife.controller.GameController;
import studentlife.core.Day;
import studentlife.core.Matiere;
import studentlife.core.events.*;

import java.sql.SQLOutput;
import java.util.Scanner;

//La classe dans laquelle on intialise le jeu et met en place le scenario qui le fait tourner
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

    public static void clearScreen() {
        for(int clear = 0; clear < 100; clear++)
        {
            System.out.println("\b") ;
        }
    }

    public void run() {
        // LANCER LE JEU :)
        int i = -1;
        initGameView();

        for (Day day : gameController.getSchedule().getWeek()) {
            i++;
            for (Evenement event : day.getEvenements()) {
                manageEvent(event);
                continuerLeJeu();




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
        setPause();



    }

    public void endGame(){

    }
    public void continuerLeJeu(){
        Input question = new Input("Voulez-vous continuer le jeu?");
        question.addAnswer("Oui");//0
        question.addAnswer("Non");//1

        if(question.resolve().equals("Oui")){
            clearScreen();
        }else{
            finalResults();
            System.exit(0);
        }
    }

    public void setPause(){
        Input question = new Input("Que allez vous faire pendant la pause?");
        question.addAnswer("Reviser");//0
        question.addAnswer("Manger");//1
        question.addAnswer("Se reposer");//2
        if (question.resolve().equals("Reviser")){

            int subject = selectSubject("Quelle matière voulez vous révisez ?");
            System.out.println("Vous avez choisi: " + gameController.getSubjectList().get(subject).getNom());

            Pause revision = new Pause(PauseType.REVISION, gameController.getSubjectList().get(subject));
            revision.finaliserEvenement(gameController.getUser(), true);


        }

    }
    public void dailyResults( int i){
        System.out.println("Les resultats du fin de la journée: "+gameController.getSchedule().getWeekday(i));
        System.out.println("Stats perso: "+ gameController.getUser().getStats().toString());
        gameController.subjectsMastery();
    }

    public void finalResults(){
        System.out.println("Vos statistiques à la fin du jeu:");
        System.out.println("Stats perso: "+ gameController.getUser().getStats().toString());
        gameController.subjectsMastery();
        gameController.profsAppreciation();

    }

    private int selectSubject(String question) {

        Input request = new Input(question);

        for(Matiere subject : gameController.getSubjectList()) {
            request.addAnswer(subject.getNom());
        }
        String res = request.resolve();

        int n = 0;

        for(int i = 0; i < gameController.getSubjectList().size(); i++) {
            if(gameController.getSubjectList().get(i).getNom().equals(res))
                n = i;
        }

        return n;
    }
}
