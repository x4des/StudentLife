package studentlife.view.console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * La classe Input interagit que avec la console.
 * Elle permet la création de questions et réponses possibles
 * et permet de gérer la réponse fournie par l'utilisateur.
 * */

public class Input {

    /**une question*/
    private final String question;

    /**une liste de réponses*/
    private final ArrayList<String> answers = new ArrayList<>();


    /**
     * constructeur de la classe Input
     * @param question une question qui est posée a l'utilisateur
     * */
    public Input(String question) {
        this.question = question;
    }


    /**
     * Methode qui ajoute une réponse dans la liste de réponses.
     * @param answer La réponse éventuelle a une question.
     * */
    public void addAnswer(String answer) {
        answers.add(answer);
    }


    /**Methode qui ajoute une liste de réponses dans la liste de réponses.
     * @param reponses La liste de réponses.
     * */
    public void addAnswers(ArrayList<String> reponses){
        answers.addAll(reponses);
    }


    /**
     * Methode qui affiche la question et les réponses possibles à l'utilisateur,
     * puis retourne la réponse choisie.
     * Si la liste de réponses est vide, elle imite une pause dans le jeu
     * qui permet à l'utilisateur d'avoir le temps de lire les informations présentes dans la console
     * @return réponse choisie par l'utilisateur
     * */
    public String resolve() {
        boolean stop = false;

        //ce cas est utilisé dans la méthode continuerJeu
        //ici on attend juste une saisie d'utilisateur pour continuer la simulation
        //pas des réponses "définis"
        if (answers.size() == 0) {
            System.out.println(question);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }

        //affiche la question
        System.out.println(question);

        //affiche les réponses possibles
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i + 1 + ") " + answers.get(i));
        }

        //demande d'une saisie de l'utilisateur
        System.out.println("Donnez l'indice de votre réponse");
        Scanner scanner = new Scanner(System.in);
        int res=-1;
        while (!stop) {
            try {
                res = scanner.nextInt(); //on prend l'indice saisi
                res--; //on le décrémente car les réponses sont numérotées à partir de 0

                while (res < 0 || res >= answers.size()) { //on vérifie que l'indice est bien valide
                    System.out.println("Donnez un indice correct s'il vous plaît");
                    res = scanner.nextInt();
                    res--;
                }

                stop = true;
            } catch (InputMismatchException e) { //si l'utilisateur avait pas saisi un chiffre
                System.out.println("Merci d'entrer un indice");
                scanner.next();
            }

        }
        return answers.get(res);
    }


    /**
     * Methode qui permet d'avoir la liste des réponses possibles
     * @return liste de réponses
     * */
    public ArrayList<String> getAnswers() {
        return answers;
    }
}
