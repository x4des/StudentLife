package studentlife.view.console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * La classe Input permet la création de questions et réponses possibles
 * et permet de gérer la réponse fournie par l'utilisateur.
 * */

public class Input {

    /**une question*/
    private final String question;

    /**une liste de réponses*/
    private final ArrayList<String> answers = new ArrayList<>();

    /**
     * @param question une question qui est posée a l'utilisateur
     * constructeur de la classe Input
     * */
    public Input(String question) {
        this.question = question;
    }

    /**
     * @param answer La réponse éventuelle a une question.
     * addAnswer ajoute une reponse dans la liste de reponse.
     * */
    public void addAnswer(String answer) {
        answers.add(answer);
    }

    /**ajoute une réponse dans la liste de réponse*/
    public void addAnswers(ArrayList<String> reponses){
        answers.addAll(reponses);
    }


    /**
     * @return Retourne null s'il n'y a pas de reponse. Sinon, affiche toutes les
    réponses possibles et retourne la reponse choisi par l'utilisateur.
     * */
    public String resolve() {
        boolean stop = false;

        if (answers.size() == 0) {
            System.out.println(question);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }

        // Print the question and the answers:
        System.out.println(question);

        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i + 1 + ") " + answers.get(i));
        }


        System.out.println("Donnez l'indice de votre réponse");
        Scanner scanner = new Scanner(System.in);
        int res=-1;
        while (!stop) {
            try {

                res = scanner.nextInt();
                res--;

                while (res < 0 || res >= answers.size()) {
                    System.out.println("Donnez un indice correct s'il vous plaît");
                    res = scanner.nextInt();
                    res--;
                }

                stop = true;
            } catch (InputMismatchException e) {
                System.out.println("Merci d'entrer un indice");
                scanner.next();
            }

        }
        return answers.get(res);

    }

    /**@return retourne la liste de réponses*/
    public ArrayList<String> getAnswers() {
        return answers;
    }
}
