/**
 * Contient la classe Quiz
 * */
package studentlife.core.actions;
import studentlife.core.Matiere;

import java.util.*;
/**
 * la classe Quiz est une classe qui permet de créer et lancer un quiz.
 * */
public class Quiz {
    private final String question;
    private final ArrayList<String> reponses; //réponses possibles (sauf la réponse correcte)
    private final String reponseCorrecte;
    private final Matiere matiere; //matière concernée par le quizz

    /**
     * @param question une question qui est posée
     * @param matiere la matiere dont les questions sont concernées
     * @param reponseCorrecte la reponse correcte à la question posée, fait partie des reponses proposées
     * @param r2 reponse proposée
     * @param r3 reponse proposée
     * @param r4 reponse proposée
     * constructeur d'un quizz avec 4 propositions de réponses
     * */
    public Quiz(String question, String reponseCorrecte, Matiere matiere, String r2, String r3, String r4){
        this.question = question;
        this.reponses = new ArrayList<>();
        this.reponses.add(r2);
        this.reponses.add(r3);
        this.reponses.add(r4);
        this.reponseCorrecte = reponseCorrecte;
        this.matiere = matiere;
    }

    /**
     * @param question une question qui est posée
     * @param reponseCorrecte la réponse correcte
     * @param matiere la matière dont les questions sont concernées
     * @param r2 réponse proposée
     * constructeur d'un quizz avec 2 propositions de réponses
     * */
    public Quiz(String question, String reponseCorrecte, Matiere matiere, String r2){
        this.question = question;
        this.reponses = new ArrayList<>();
        this.reponses.add(r2);
        this.reponseCorrecte = reponseCorrecte;
        this.matiere = matiere;
    }

    /**
     * @param question une question qui est posée
     * @param reponseCorrecte
     * @param matiere
     * @param r2
     * @param r3
     * constructeur d'un quizz avec 3 propositions de réponses
     * */
    public Quiz(String question, String reponseCorrecte, Matiere matiere, String r2, String r3){
        this.question = question;
        this.reponses = new ArrayList<>();
        this.reponses.add(r2);
        this.reponses.add(r3);
        this.reponseCorrecte = reponseCorrecte;
        this.matiere = matiere;
    }



    /**
     * @return insère la réponse correcte dans la liste de réponses possibles d'une manière aléatoire
     retourne la liste des toutes les réponses possibles
     * */

    public ArrayList<String> getReponses() {

        try {
            if(this.reponses.size() > 0) {
                Random random = new Random();

                int reponseCorrecteIndice = random.nextInt(reponses.size()+1); //un int random entre 0 et taille(reponses)
                this.reponses.add(reponseCorrecteIndice, reponseCorrecte);

            }else {
                throw new Exception("Il n'y a pas de reponses affectées à la question");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return this.reponses;
    }

    /**
     *realise le quizz
     demande la saisie de l'utilisateur et vérifie si sa réponse est bien correcte
     gère les exceptions si la saisie d'utilisateur n'est pas conforme au format demandé
     * */
    public void realiserQuiz() {
        System.out.println(System.lineSeparator() + this.question);//affichage de la question
        int i = 0;
        for (String rep : this.getReponses()) {//affichage des réponses possibles
            i++;
            System.out.println(i + ") " + rep);
        }

        Scanner scanner = new Scanner(System.in); //scanner qui prendra la saisie de l'utilisateur
        System.out.println(System.lineSeparator() + "Donnez l'indice de votre réponse");
        int reponse;
        boolean stop = false; //condition d'arrêt de la boucle
        while (!stop) {
            try {
                reponse = scanner.nextInt(); //scan de la réponse d'utilisateur
                while (reponse < 1 || reponse > reponses.size()) { //verification que l'indice donné est correct
                    System.out.println("Donnez l'indice correct");
                    reponse = scanner.nextInt();
                }

                if ((reponse-1) == reponses.indexOf(reponseCorrecte)) { //verification si la réponse d'utilisateur est correcte
                    System.out.println("Votre réponse est correcte");
                    matiere.getMastery().updateValue(10); //changements des stats dans la matière concernée
                } else {
                    System.out.println("Votre réponse est fausse");
                    matiere.getMastery().updateValue(-10);
                    System.out.println("la réponse correcte est: " + (reponses.indexOf(reponseCorrecte)+1));
                }
                stop = true;

            } catch (InputMismatchException e) { //si la réponse saisie n'est pas un entier
                System.out.println("Merci d'entrer un indice");
                scanner.next();
            }
        }
    }
}
