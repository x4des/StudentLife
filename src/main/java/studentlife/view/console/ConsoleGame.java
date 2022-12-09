package studentlife.view.console;

import studentlife.controller.GameController;
import studentlife.core.Matiere;
import studentlife.core.characters.Professeur;
import studentlife.core.events.*;
import studentlife.view.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static studentlife.Config.POINTS_REVISION;


/**
 * La classe ConsoleGame est la classe dans laquelle on initialise le jeu
 et où on crée la console et le scenario de la simulation.
 C'est la sous-classe de la classe abstraite Game
 *@see Game
 * */
public class ConsoleGame extends Game {

    /** le jour de la semaine en cours*/
    private int weekDay;

    /** l'évènement actuel */
    private int eventActuel;


    /**
     * Le constructeur de la classe Game
     * @param controller Le contrôleur qui est le coeur de cette simulation
     * */
    public ConsoleGame(GameController controller) {
        super(controller); //affectation via le constructeur de la super-classe
        weekDay = 0; // on se positionne en début de la semaine
        eventActuel = 0; // en commençant avec le premier évènement du jour
    }


    /**
     * Initialisation de la simulation. On prend les informations de l'utilisateur
     * nécessaires pour commencer le jeu
     * */
    private void initGameView() {
        System.out.println("Welcome to the StudentWeek simulator!");
        System.out.println("Pour commencer le jeu, entrez votre nom et prénom");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom:");
        String firstName = scanner.nextLine();
        System.out.println("Prénom:");
        String lastName = scanner.nextLine();
        clearScreen(); //on clear l'affichage dans la console
        getController().initGame(lastName, firstName);//initialise le jeu avec les informations d'utilisateur
    }


    /**
     * Cette methode créé les éléments du menu principal
     * et gère le choix de l'utilisateur
     * */
    private void menuPrincipal(){
        clearScreen();
        Input question = new Input("Menu Principal          "+ ">Etudiant(e): " + getController().getUser().toString());
        //les rubriques possibles
        question.addAnswer("Poursuivre le jeu");
        question.addAnswer("Consulter l'EDT");
        question.addAnswer("Statistiques");
        question.addAnswer("Paramètres");
        question.addAnswer("Quitter le jeu");
        String rep = question.resolve();

        if (rep.equals("Poursuivre le jeu")){ //nous remet dans la simulation
            lookForEvent();
            return;
        }

        if(rep.equals("Consulter l'EDT")){
            menuEDT();
            return;
        }

        if(rep.equals("Statistiques")) {
            menuStatistiques();
            return;
        }

        if (rep.equals("Paramètres")){
            parametres();
            return;
        }

        if (rep.equals("Quitter le jeu")){
            endGame();
        }
    }


    /**
     * Cette methode imite la fonction clear de la console.
     * */
    private static void clearScreen() {
        for(int clear = 0; clear < 100; clear++)
        {
            System.out.println("\b") ;
        }
    }


    /** Cette methode crée et affiche les elements du menu lorsque
     l'utilisateur a choisi de consulter son emploi du temps.
     L'utilisateur pourra consulter son EDT en choisissant le jour souhaité
     */
    private void menuEDT(){
        Input question = new Input("Ici vous pouvez consulter votre Emploi du Temps\nChoisissez le jour souhaité");
        question.addAnswers(getController().getSchedule().getWeekDaysAsList()); //on ajoute les noms des jours
        String res = question.resolve(); //prend le jour choisi par l'utilisateur
        int i = question.getAnswers().indexOf(res);//on a besoin de l'indice de la réponse pour retrouver le jour
        System.out.println(res + " vous avez:");
        System.out.println(getController().getSchedule().getWeek().get(i).toString()); //affiche la list d'évènements
        revenirDansLeMenu();
    }


    /** Cette méthode permet, dans la rubrique paramètres, de demander à l'utilisateur s'il veut modifier
     ses infos personnelles, c'est-à-dire, son nom et prénom */
    private void parametres(){
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


    /** Cette méthode permet de modifier les informations personnelles de l'utilisateur*/
    private void resetInfoPerso(){
        Input question = new Input("Entrez votre nouveau prénom");
        String res = question.resolve();
        getController().getUser().setPrenom(res);
        question = new Input("Entrez votre nouveau nom");
        res = question.resolve();
        getController().getUser().setNom(res);
        System.out.println("Informations personnelles changées avec success");
    }


    /**Cette méthode permet, lorsque l'utilisateur est dans la rubrique statistiques,
     de choisir quelles données il veut consulter.*/
    private void menuStatistiques(){
        Input question = new Input("Statistiques");
        question.addAnswer("Personnelles");
        question.addAnswer("Matières");
        question.addAnswer("Professeurs");
        String res = question.resolve();

        if (res.equals("Personnelles")){
            System.out.println(getController().getUser().toString()); //nom/prénom
            System.out.println(getController().getUser().getStats().toString()); //Stats perso
            revenirDansLeMenu();
            return;
        }

        if (res.equals("Matières")){
            subjectsMastery();
            revenirDansLeMenu();
            return;
        }

        if (res.equals("Professeurs")){
            profsAppreciation();
            revenirDansLeMenu();
        }
    }


    /**
     * Cette méthode permet de revenir dans le menu principal à partir de n'importe quelle rubrique.
     */
    private void revenirDansLeMenu(){
        Input question = new Input("\nFaites une saisie pour revenir dans le menu principal");
        question.resolve(); //saisie quelconque d'utilisateur
        menuPrincipal();
    }


     /**
     * Cette méthode permet de mettre la simulation en "pause" le temps que l'utilisateur
     * lit les informations présentes dans la console.
     * Elle attend une saisie quelconque d'utilisateur pour reprendre la simulation.
     */
    private void continuerJeu(){
        System.out.println();
        Input question = new Input("Faites une saisie pour continuer le jeu");
        question.resolve();
    }


    /** Cette méthode vérifie si on est arrivé au dernier jour de la semaine.
     * Si oui, la semaine est terminée, donc la simulation aussi.
     * Si non, on passe à l'évènement suivant.
     */
    private void lookForEvent(){
        if (weekDay>=getController().getSchedule().getWeek().size()){
            endOfWeek();
        }else {
            manageEvent(getController().getSchedule().getWeek().get(weekDay).getEvenements().get(eventActuel));
        }

    }

    /** Cette méthode, lorsque l'EDT est terminé, avertit l'utilisateur et fait revenir
     la simulation vers le menu principal.*/
    private void endOfWeek(){
        System.out.println("La semaine est terminée\nVous pouvez consulter vos résultats dans le menu principal");
        revenirDansLeMenu();
    }


    /** Incrémente le numéro de l'évènement en cours
     * et vérifie si on a atteint la fin de la journée
     */
    private void updateEvent(){
        eventActuel++;
        if (eventActuel >= getController().getSchedule().getWeek().get(weekDay).getEvenements().size()){
            eventActuel = 0;
            dailyResults(weekDay);
            weekDay++; //on passe au suivant jour si on a atteint la fin de la journée
        }
    }


    /**
     * Détecte le type d'évènement en cours et fait appel à une méthode qui va le gérer.
     * On a 2 types d'évènements possibles: cours ou pause.
     * @param event Un évènement.
     * */
    private void manageEvent(Evenement event) {
        clearScreen();
        if(event instanceof Cours) {
            manageCours((Cours) event);
        } else {
            managePause();
        }
    }


    /**
     * Cette méthode demande à l'utilisateur s'il veut assister à un cours.
     * Si non, l'utilisateur a le choix de faire une pause ou revenir dans le menu
     * finaliserEvenement changera des stats selon son choix.
     * @param cours Le cours auquel l'étudiant doit assister.
     * @see Cours
     * */
    private void manageCours(Cours cours) {
        System.out.println("Vous avez un " + cours.getShortType()+ " de " + cours.getMatiere().getNom());

        //Creation de la possibilité de choisir si l'utilisateur veut ou non assister au cours
        Input question = new Input("Voulez-vous y assister?");
        question.addAnswer("Oui");//0
        question.addAnswer("Non, je veux faire une pause");//1
        question.addAnswer("Revenir dans le Menu Principal");//2
        String res = question.resolve();
        if(res.equals("Oui")){
            clearScreen();
            System.out.println(cours.getType() + " de " + cours.getMatiere().getNom());
            System.out.println("\b");

            System.out.println("Petit quiz pour vérifier vos connaissances");
            cours.finaliserEvenement(getController().getUser(), true);
            continuerJeu();

            updateEvent();
            lookForEvent();
            return;
        }

        if(res.equals("Non, je veux faire une pause")){
            clearScreen();
            cours.finaliserEvenement(getController().getUser(), false);
            setPause(); //on lance une pause
            updateEvent();
            lookForEvent();
            return;
        }

        if (res.equals("Revenir dans le Menu Principal")){
            menuPrincipal();
        }

    }

    /**
     * Lorsque l'étudiant à une pause dans son EDT.
     * */
    private void managePause() {
        System.out.println("Actuellement vous n'avez pas de cours.");
        if (setPause()) {
            updateEvent();
            lookForEvent();
        }
    }

    /**fin du jeu, affichage du bilan de la semaine.*/
    private void endGame(){
        finalResults();
        System.exit(0);
    }



    /**
     * setPause gère les stat de l'utilisateur lorsqu'il décide de prendre une pause.
     En fonction du type de pause qu'il a choisi de prendre ses stats seront modifiés.
     @return retourne un booléen qui indique si une pause a été géré ou non.
     * */
    private boolean setPause(){
        Input question = new Input("Que allez vous faire pendant la pause?");
        question.addAnswer("Reviser");//0
        question.addAnswer("Manger");//1
        question.addAnswer("Se reposer");//2
        question.addAnswer("Revenir dans le Menu Principal");//3
        String rep = question.resolve();
        clearScreen();
        if (rep.equals("Reviser")){

            int subject = selectSubject();
            System.out.println("Vous avez choisi: " + getController().getSubjectList().get(subject).getNom());

            Pause revision = new Pause(PauseType.REVISION, getController().getSubjectList().get(subject));
            revision.finaliserEvenement(getController().getUser(), true);
            System.out.println("Votre maitrise de la matière a augmentée de " +POINTS_REVISION);
            System.out.println("Maitrise actuelle: "+ getController().getSubjectList().get(subject).toString());
            continuerJeu();
            return true;
        }

        if (rep.equals("Manger")){
            Pause repas = new Pause(PauseType.REPAS);
            repas.finaliserEvenement(getController().getUser(), true);
            Input plat = new Input("Entrez le nom du plat que vous désirez manger: ");
            String choix = plat.resolve();
            System.out.println("\""+choix+" a soulagé(e) votre faim!");
            etatActuel();
            continuerJeu();
            return true;

        }

        if (rep.equals("Se reposer")){
            Pause repos = new Pause(PauseType.REPOS);
            repos.finaliserEvenement(getController().getUser(), true);
            System.out.println("C'est bien de se reposer, tant que ce n'est pas la seule chose que vous faites");
            System.out.println("Maintenant vous êtes moins fatigué(e) et plus attentif(ve)!\n");
            etatActuel();
            continuerJeu();
            return true;

        }

        if(rep.equals("Revenir dans le Menu Principal")){
            menuPrincipal();
            return false;
        }
        return false;
    }

    /** Etat personnel de l'utilisateur*/
    public void etatActuel(){
        System.out.println("Etat personnel actuel: "+ getController().getUser().getStats().toString());
    }

    /**
     * @param i indice qui parcourt la liste de jour de la semaine
     * dailyResults affiche les résultats de la journée dont l'indice est passé en paramètre.
     * */
    private void dailyResults( int i){
        System.out.println("Les résultats du fin de la journée: "+getController().getSchedule().getWeekday(i));
        System.out.println("Stats perso: "+ getController().getUser().getStats().toString());
        subjectsMastery();
    }

    /**
     * affiche le bilan final de la semaine : les stats pour chaque matière, les stats personnels
     ainsi l'appréciation des profs.
     * */
    private void finalResults(){
        System.out.println("Vos statistiques à la fin du jeu:");
        System.out.println("Stats perso: "+ getController().getUser().getStats().toString());
        subjectsMastery();
        profsAppreciation();

    }



    /**
     * @return L'entier retourné est égal à 0 lorsque la matière
    n'est pas présente dans la liste de matière de l'étudiant. Lorsqu'elle
    est présente l'entier retourné est l'indice de la matière dans la meme liste.
     * @see Input
     * Cette methode retrouve la matiere dont on a besoin
     * */
    private int selectSubject() {
        Input request = new Input("Quelle matière voulez vous réviser?");
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
     * affiche pour chaque matière son nom ainsi que la moyenne que l'étudiant a dans celle-ci.
     * */
    private void subjectsMastery() {
        System.out.println("Les stats dans les matières:");
        for (Matiere subject : getController().getSubjectList()) {
            System.out.println(subject.toString());
        }
    }


    /**
     * affiche pour chaque prof son nom et le niveau d'appréciation qu'il a envers l'étudiant.
     * */
    private void profsAppreciation(){
        System.out.println("Niveau de relation avec les professeurs:");
        for (Professeur prof : getController().getProfList()) {
            System.out.println(prof.toString());
        }
    }

    /**
     * La methode run() permet de lancer le jeu.
     * */
    public void run() {//boucle-scenario du jeu
        // LANCER LE JEU :)
        clearScreen();
        initGameView();//recueil des informations d'utilisateur
        menuPrincipal();

    }
}
