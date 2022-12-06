package studentlife.view.console;

import studentlife.controller.GameController;
import studentlife.core.Day;
import studentlife.core.Matiere;
import studentlife.core.characters.Professeur;
import studentlife.core.events.*;
import studentlife.view.Game;

import java.util.Scanner;

//pub, protec, priv

/**
 * La classe Game est la classe dans laquelle on initialise le jeu
 et où on met en place le scenario qui le scenario qui le fait tourner.
 * */
public class ConsoleGame extends Game {

    /**
     * @param controller
     * Le constructeur de la classe Game
     * */

    private int weekDay;
    private int eventActuel;
    public ConsoleGame(GameController controller) {
        super(controller);
        weekDay = 0;
        eventActuel = 0;
    }

    /**
     * Initialisation de la simulation. On prend les informations souhaitées de l'utilisateur
     et on affiche toutes les infos quil aura besoin pour commencer la simulation
     * @see GameController
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

        getController().initGame(lastName, firstName);//initialise le jeu avec les informations d'utilisateur

        //message de bienvenue avec les stats initiales
        System.out.println("Welcome " + getController().getUser().getNom() + " " + getController().getUser().getPrenom());
        System.out.println(getController().getUser().getStats().toString());
    }

    private void menuPrincipal(){

        Input question = new Input("Menu Principal        "+ "Etudiant(e): " + getController().getUser().toString()
        );
        question.addAnswer("Poursuivre le jeu");//0
        question.addAnswer("Statistiques");//1
        question.addAnswer("Paramètres");
        question.addAnswer("Quitter le jeu");
        String rep = question.resolve();

        if (rep.equals("Poursuivre le jeu")){
            lookForEvent();
        }

        if(rep.equals("Statistiques")) {
            menuStatistiques();
        }

        if (rep.equals("Paramètres")){
            parametres();
        }

        if (rep.equals("Quitter le jeu")){
            endGame();

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

    public void parametres(){
        Input question = new Input("Modifier vos informations personnelles");
        question.addAnswer("Oui");
        question.addAnswer("Non, revenir dans le Menu Principal");
        String res = question.resolve();

        if (res.equals("Oui")) {
            resetInfoPerso();
            revenirDansLeMenu();
        }else{
            menuPrincipal();
        }
    }


    public void resetInfoPerso(){
        Input question = new Input("Entrez votre prénom");
        String res = question.resolve();
        getController().getUser().setPrenom(res);
        question = new Input("Entrez votre nom");
        res = question.resolve();
        getController().getUser().setNom(res);
        System.out.println("Informations personnelles changées avec success");
    }

    public void menuStatistiques(){
        Input question = new Input("Statistiques");
        question.addAnswer("Personnelles");
        question.addAnswer("Matières");
        question.addAnswer("Professeurs");
        String res = question.resolve();

        if (res.equals("Personnelles")){
            System.out.println(getController().getUser().toString());
            System.out.println(getController().getUser().getStats().toString());
            revenirDansLeMenu();
        }

        if (res.equals("Matières")){
            subjectsMastery();
            revenirDansLeMenu();

        }

        if (res.equals("Professeurs")){
            profsAppreciation();
            revenirDansLeMenu();
        }
    }

    public void revenirDansLeMenu(){
        Input question = new Input("Faites une saisie pour revenir dans le menu principal");
        question.resolve();
        menuPrincipal();
    }

    public void checkValidEvent(){
            System.out.println("La semaine est terminée");
            //afficher moyenne
            revenirDansLeMenu();
    }
    public void lookForEvent(){
        if (weekDay>=getController().getSchedule().getWeek().size()){
            checkValidEvent();
        }else {
            manageEvent(getController().getSchedule().getWeek().get(weekDay).getEvenements().get(eventActuel));
        }

    }

    public void updateEvent(){
        eventActuel++;


        if (eventActuel >= getController().getSchedule().getWeek().get(weekDay).getEvenements().size()){
            eventActuel = 0;
            dailyResults(weekDay);
            weekDay++;
        }
    }

    public void boucleDeSimulation(){

        for (int i = weekDay; i<getController().getSchedule().getWeek().size(); i++) {//pour chaque jour dans la semaine
            if (eventActuel >= getController().getSchedule().getWeek().get(i).getEvenements().size()){
                eventActuel = 0;
                dailyResults(weekDay);
                weekDay++;
            }else {
                for (int j = eventActuel; j < getController().getSchedule().getWeek().get(i).getEvenements().size(); j++) {//pour chaque évènement dans la journée
                    manageEvent(getController().getSchedule().getWeek().get(i).getEvenements().get(j)); //gérer les actions possibles liées à un type d'évènement

                }

            }

        }
    }

    /**
     * la methode run() permet de faire une boucle pour la simulation, ainsi, le jeu continue.
     * */
    public void run() {//boucle-scenario du jeu
        // LANCER LE JEU :)
        initGameView();//recueil des informations d'utilisateur
        menuPrincipal();


    }

    /**
     * détecte le type d'évènement en cours et fait appel à une méthode appropriée.
     On a 2 types d'évènements possibles; cours ou pause.
     * */
    private void manageEvent(Evenement event) {
        if(event instanceof Cours) {
            manageCours((Cours) event);
        } else {
            managePause((Pause) event);
        }
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
        question.addAnswer("Revenir dans le Menu Principal");//2
        String res = question.resolve();
        if(res.equals("Oui")){//si oui
            clearScreen();
            System.out.println(cours.getNom() + " de " + cours.getMatiere().getNom());
            System.out.println("\b");

            System.out.println("Petit quiz pour vérifier vos connaissances");
            cours.finaliserEvenement(getController().getUser(), true);
            updateEvent();
            lookForEvent();
        }

        if(res.equals("Non, je veux faire une pause")){
            clearScreen();
            cours.finaliserEvenement(getController().getUser(), false);
            setPause();
            updateEvent();
            lookForEvent();
        }

        if (res.equals("Revenir dans le Menu Principal")){
            menuPrincipal();
        }



    }

    /**
     * @param pause l'etudiant a une pause
     * appel la methode setPause()
     * */
    public void managePause(Pause pause) {
        System.out.println("Y a une pause a gérer");
        setPause();
        updateEvent();
        lookForEvent();
    }

    public void endGame(){
        finalResults();
        System.exit(0);
    }

    /**
     * continuerLeJeu demande a l'utilisateur s'il veut continuer la simu ou pas.
     * */
    public void continuerLeJeu(){
        Input question = new Input("Voulez-vous continuer le jeu?");
        question.addAnswer("Oui");//0
        question.addAnswer("Non");//1
        question.addAnswer("Menu Principal");//1

        if(question.resolve().equals("Oui")){
            clearScreen();
        }

        if (question.resolve().equals("Non")){
            finalResults();
            System.exit(0);
        }

        if (question.resolve().equals("Menu Principal")){
            menuPrincipal();
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
            System.out.println("Vous avez choisi: " + getController().getSubjectList().get(subject).getNom());

            Pause revision = new Pause(PauseType.REVISION, getController().getSubjectList().get(subject));
            revision.finaliserEvenement(getController().getUser(), true);
        }

        if (rep.equals("Manger")){
            Pause repas = new Pause(PauseType.REPAS);
            repas.finaliserEvenement(getController().getUser(), true);

        }

        if (rep.equals("Se reposer")){
            Pause repos = new Pause(PauseType.REPOS);
            repos.finaliserEvenement(getController().getUser(), true);
        }
    }

    /**
     * @param i indice qui parcours la lise de jour de la semaine
     * dailyResults affiche les resultats de la journée dont l'indice est passé en parametre.
     * */
    public void dailyResults( int i){
        System.out.println("Les resultats du fin de la journée: "+getController().getSchedule().getWeekday(i));
        System.out.println("Stats perso: "+ getController().getUser().getStats().toString());
        subjectsMastery();
    }

    /**
     * affiche le bilan final de la semaine: les stats pour chaque matieres, les stats personnels
     ainsi l'appreciation des profs.
     * */
    public void finalResults(){
        System.out.println("Vos statistiques à la fin du jeu:");
        System.out.println("Stats perso: "+ getController().getUser().getStats().toString());
        subjectsMastery();
        profsAppreciation();

    }



    /**
     * @param question
     * @return l'entier retourné est égal à 0 lorsque la matière
    n'est pas présente dans la liste de matière de l'étudiant. Lorsqu'elle
    est présente l'entier retourné est l'indice de la matière dans la meme liste.
     * @see Input
     * Cette methode retrouve la matiere dont on a besoin
     * */
    private int selectSubject(String question) {
        Input request = new Input(question);
        for(Matiere subject : getController().getSubjectList()) {
            request.addAnswer(subject.getNom());
        }
        String res = request.resolve();

        int n = 0;

        for(int i = 0; i < getController().getSubjectList().size(); i++) {
            if(getController().getSubjectList().get(i).getNom().equals(res))
                n = i;
        }

        return n;
    }


    /**
     * affiche pour chaque matière son nom ainsi que la moyenne qu'a l'étudiant sur celle-ci.
     * */
    public void subjectsMastery() {
        System.out.println("Les stats dans les matières:");
        for (Matiere subject : getController().getSubjectList()) {
            System.out.println(subject.toString());
        }
    }


    /**
     * affiche pour chaque prof son nom et le niveau d'appréciation qu'il a envers l'étudiant.
     * */
    public void profsAppreciation(){
        System.out.println("Niveau de relation avec les professeurs:");
        for (Professeur prof : getController().getProfList()) {
            System.out.println(prof.toString());
        }
    }

}