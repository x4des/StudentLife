package studentlife.view.console;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe Input lit les réponses choisies par l'utilisateur
 * */

public class Input {

    private final String question;

    private final ArrayList<String> answers = new ArrayList<>();

    /**
     * @param question un question qui est posée a l'utilisateur
     * constructeur de la classe Input
     * */
    public Input(String question) {
        this.question = question;
    }

    /**
     * @param answer la reponse eventuelle a une question.
     * addAnswer ajoute une reponse dans la liste de reponse.
     * */
    public void addAnswer(String answer) {
        answers.add(answer);
    }

    /**
     * @return resolve() retourne null s'il n'y a pas de reponse. Sinon, affiche toute les
     reponses possibles et retourne la reponse choisi par l'utilisateur.
     * */
    public String resolve() {

        if(answers.size() == 0) {
            System.out.println(question);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }


        // Print the question and the answers:
        System.out.println(question);

        for(int i = 0; i < answers.size(); i++) {
            System.out.println(i + 1 + ") " + answers.get(i));
        }

        Scanner scanner = new Scanner(System.in);

        int res = -1;

        while (res < 0 || res >= answers.size())
        {
             System.out.println("Donnez l'indice de votre réponse\"");
             res = scanner.nextInt();
             res--;
        }

        return answers.get(res);
    }

}
