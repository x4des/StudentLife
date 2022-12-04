package studentlife.view;

import studentlife.controller.GameController;
import studentlife.core.Day;
import studentlife.core.Matiere;
import studentlife.core.events.*;

import java.sql.SQLOutput;
import java.util.Scanner;

//La classe dans laquelle on initialise le jeu et met en place le scenario qui le fait tourner
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

        gameController.initGame(lastName, firstName);//initialise le jeu avec les informations d'utilisateur

        //message de bienvenue avec les stats initiales
        System.out.println("Welcome " + gameController.getUser().getNom() + " " + gameController.getUser().getPrenom());
        System.out.println(gameController.getUser().getStats().toString());
    }


    public static void clearScreen() {//imite la fonction clear de la console
        for(int clear = 0; clear < 100; clear++)
        {
            System.out.println("\b") ;
        }
    }

    public void run() {//boucle-scenario du jeu
        // LANCER LE JEU :)
        int i = -1; //itérateur des jours
        initGameView();//recueil des informations d'utilisateur

        for (Day day : gameController.getSchedule().getWeek()) {//pour chaque jour dans la semaine
            i++;
            for (Evenement event : day.getEvenements()) {//pour chaque évènement dans la journée
                manageEvent(event); //gérer les actions possibles liées à un type d'évènement
                System.out.println(gameController.getUser().getStats().toString());
                continuerLeJeu(); //donner la possibilité de quitter le jeu avant la fin de simulation




            }
            dailyResults(i); //affichage des résultats de la fin de la journée
        }
    }

    //détecte le type d'évènement en cours et fait appel à une méthode appropriée
    //2 types d'évènements possibles; cours ou pause
    private void manageEvent(Evenement event) {
        if(event instanceof Cours)
            manageCours((Cours) event);
        else
            managePause((Pause) event);
    }


    //
    public void manageCours(Cours cours) {
        System.out.println("Vous avez un " + cours.getShortNom()+ " de " + cours.getMatiere().getNom());

        //Creation de la possibilité de choisir si l'utilisateur veut ou non assister au cours
        Input question = new Input("Voulez-vous y assister?");
        question.addAnswer("Oui");//0
        question.addAnswer("Non, je veux faire une pause");//1
        if(question.resolve().equals("Oui")){//si oui
            clearScreen();
            System.out.println(cours.getNom() + " de " + cours.getMatiere().getNom());
            System.out.println("\b");

            System.out.println("Petit quiz pour vérifier vos connaissances");
            cours.finaliserEvenement(gameController.getUser(), true);
        }else{
            clearScreen();
            cours.finaliserEvenement(gameController.getUser(), false);
            setPause();
        }


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
