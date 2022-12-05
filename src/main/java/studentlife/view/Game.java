package studentlife.view;

import studentlife.controller.GameController;
import studentlife.core.Day;
import studentlife.core.Matiere;
import studentlife.core.characters.Professeur;
import studentlife.core.events.*;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * La classe Game est la classe dans laquelle on initialise le jeu
 et où on met en place le scenario qui le scenario qui le fait tourner.
 * */
public class Game {

    private final GameController gameController;

    /**
     * @param gameController
     * Le constructeur de la classe Game
     * */
    public Game(GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * Initialisation de la simulation. On prend les informations souhaitées de l'utilisateur
     et on affiche toutes les infos quil aura besoin pour commencer la simulation
     * @see GameController.java
     * */

    private void initGameView() {
        // Get user details
        System.out.println("Welcome to the StudentWeek simulator!");
        System.out.println("Pour commencer le jeu, entrez votre nom et prénom");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom:");
        String firstName = scanner.nextLine();
        System.out.println("Prénom:");
        String lastName = scanner.nextLine();

        gameController.initGame(lastName, firstName);//initialise le jeu avec les informations d'utilisateur

        //message de bienvenue avec les stats initiales
        System.out.println("Welcome " + gameController.getUser().getNom() + " " + gameController.getUser().getPrenom());
        System.out.println(gameController.getUser().getStats().toString());
    }

    private void menuPrincipal(){
        System.out.println("                     Etudiant(e): " + gameController.getUser().toString());
        Input question = new Input("Menu Principal");
        question.addAnswer("Poursuivre le jeu");//0
        question.addAnswer("Statistiques");//1
        question.addAnswer("Paramètres");
        question.addAnswer("Quitter le jeu");
        String rep = question.resolve();

        if (rep.equals("Poursuivre le jeu")){
            //continuer la boucle ??
        }

    }


    /**
     * Cette methode imite la fonction clear de la console.
     * */
    public static void clearScreen() {
        for(int clear = 0; clear < 100; clear++)
        {
            System.out.println("\b") ;
        }
    }

    /**
     * la methode run() permet de faire une boucle pour la simulation, ainsi, le jeu continue.
     * */
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

    /**
     * détecte le type d'évènement en cours et fait appel à une méthode appropriée.
     On a 2 types d'évènements possibles; cours ou pause.
     * */
    private void manageEvent(Evenement event) {
        if(event instanceof Cours)
            manageCours((Cours) event);
        else
            managePause((Pause) event);
    }


    /**
     * @param cours le cours dans lequel l'etudiant doit assisté.
     * manageCours demande à l'utilisateur s'il veut y assisté s'il veut ou pas on appel la fonction
     finaliserEvenement qui changera les stats selon son choix (si oui, un quiz lui sera donné).
     * @see Cours.java
     * */
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

    /**
     * @param pause l'etudiant a une pause
     * appel la methode setPause()
     * */
    public void managePause(Pause pause) {
        System.out.println("Y a une pause a gérer");
        setPause();
    }

    public void endGame(){
    }

    /**
     * continuerLeJeu demande a l'utilisateur s'il veut continuer la simu ou pas.
     * */
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

    /**
     * setPause gère les stat de l'utilisateur lorsqu'il decide de prendre une pause.
     En fonction du type de pause qu'il a choisi de prendre ses stats seront modifiés
     * */
    public void setPause(){
        Input question = new Input("Que allez vous faire pendant la pause?");
        question.addAnswer("Reviser");//0
        question.addAnswer("Manger");//1
        question.addAnswer("Se reposer");//2
        String rep = question.resolve();
        if (rep.equals("Reviser")){

            int subject = selectSubject("Quelle matière voulez vous révisez ?");
            System.out.println("Vous avez choisi: " + gameController.getSubjectList().get(subject).getNom());

            Pause revision = new Pause(PauseType.REVISION, gameController.getSubjectList().get(subject));
            revision.finaliserEvenement(gameController.getUser(), true);
        }

        if (rep.equals("Manger")){
            Pause repas = new Pause(PauseType.REPAS);
            repas.finaliserEvenement(gameController.getUser(), true);

        }

        if (rep.equals("Se reposer")){
            Pause repos = new Pause(PauseType.REPOS);
            repos.finaliserEvenement(gameController.getUser(), true);
        }
    }

    /**
     * @param i indice qui parcours la lise de jour de la semaine
     * dailyResults affiche les resultats de la journée dont l'indice est passé en parametre.
     * */
    public void dailyResults( int i){
        System.out.println("Les resultats du fin de la journée: "+gameController.getSchedule().getWeekday(i));
        System.out.println("Stats perso: "+ gameController.getUser().getStats().toString());
        subjectsMastery();
    }

    /**
     * affiche le bilan final de la semaine: les stats pour chaque matieres, les stats personnels
     ainsi l'appreciation des profs.
     * */
    public void finalResults(){
        System.out.println("Vos statistiques à la fin du jeu:");
        System.out.println("Stats perso: "+ gameController.getUser().getStats().toString());
        subjectsMastery();
        profsAppreciation();

    }

    /**
     * @param question
     * @return l'entier retourné est égal à 0 lorsque la matiere
     n'est pas presente dans la liste de matiere de l'etudiant. Lorsqu'elle
     est presente l'entier retourné est l'indice de la matiere dans la meme liste.
     * @see Input.java
     * Cette methode retrouve la matiere dont on a besoin
     * */
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


    /**
     * affiche pour chaque matière son nom ainsi que la moyenne qu'a l'etudiant sur celle-ci.
     * */
    public void subjectsMastery() {
        System.out.println("Les stats dans les matières:");
        for (Matiere subject : gameController.getSubjectList()) {
            System.out.println(subject.toString());
        }
    }

    /**
     * affiche pour chaque prof son nom et le niveau d'appreciation qu'il a envers l'etudiant.
     * */
    public void profsAppreciation(){
        System.out.println("Niveau de relation avec les professeurs:");
        for (Professeur prof : gameController.getProfList()) {
            System.out.println(prof.toString());
        }
    }

}
