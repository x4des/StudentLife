package studentlife.core.actions;
import studentlife.core.Matiere;

import java.util.*;

public class Quiz {
    private final String question;
    private final ArrayList<String> reponses;
    private final String reponseCorrecte;
    private int reponseUser;
    private Matiere matiere;

    public Quiz(Matiere matiere, String question, String reponseCorrecte, String r2, String r3, String r4){
        this.question = question;
        this.reponses = new ArrayList<String>();
        this.reponses.add(r2);
        this.reponses.add(r3);
        this.reponses.add(r4);
        this.reponseCorrecte = reponseCorrecte;
        this.reponseUser = 0;
        this.matiere = matiere;
    }

    public Quiz(String question, String reponseCorrecte, Matiere matiere, String r2){
        this.question = question;
        this.reponses = new ArrayList<String>();
        this.reponses.add(r2);
        this.reponseCorrecte = reponseCorrecte;
        this.reponseUser = 0;
        this.matiere = matiere;
    }

    public Quiz(String question, String reponseCorrecte, Matiere matiere, String r2, String r3){
        this.question = question;
        this.reponses = new ArrayList<String>();
        this.reponses.add(r2);
        this.reponses.add(r3);
        this.reponseCorrecte = reponseCorrecte;
        this.reponseUser = 0;
        this.matiere = matiere;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getReponseCorrecte() {
        return this.reponseCorrecte;
    }

    //retourne les reponses correctes et incorrectes
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

    public void setReponseUser(int reponseUser) {
        this.reponseUser = reponseUser;
    }

    public int getReponseUser() {
        return reponseUser;
    }

    public Matiere getMatiere(){
        return this.matiere;
    }



    public void realiserQuiz() {
        System.out.println(System.lineSeparator() + this.question);
        int i = 0;
        for (String rep : this.getReponses()) {
            i++;
            System.out.println(i + ") " + rep);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Donnez votre réponse");
        int reponse = 0;
        boolean stop = false;
        while (!stop) {
            try {
                reponse = scanner.nextInt();
                while (reponse < 1 || reponse > reponses.size()) {
                    System.out.println("Donnez indice correcte");
                    reponse = scanner.nextInt();
                }

                System.out.println("Votre réponse " + reponse);
                if ((reponse-1) == reponses.indexOf(reponseCorrecte)) {
                System.out.println(" est correcte");
                matiere.getMastery().updateValue(10);
                } else {
                System.out.println(" est fausse" + System.lineSeparator());
                matiere.getMastery().updateValue(-10);
                }
                stop = true;

            } catch (InputMismatchException e) {
                System.out.println("Merci d'entrer un indice");
                scanner.next();
            }
        }
    }

    /*
    public void realiserQ(){

        ArrayList<String> lRep = this.getReponses();

        //affichage: qst et reponses possibles
        System.out.println(this.question + System.lineSeparator());
        int i = 0;
        for(String rep: lRep){
            i++;
            System.out.println(i + ") " + rep + System.lineSeparator());
        }

        //entree utilisateur
        Scanner scanner = new Scanner(System.in);
        do{
            try {

                this.reponseUser = scanner.nextInt(); //input : 1
                System.out.println("Votre reponse: " + this.reponseUser);

                //verifie l'input, recommence si input invalide
                if(this.reponseUser < 1 || this.reponseUser > 4){
                    System.out.println("Veuillez entrer: 1, 2, 3 ou 4");
                    continue;
                }

                if((this.reponseUser-1) == lRep.indexOf(reponseCorrecte)){
                    System.out.println(" est correcte");

                    matiere.getMastery().updateValue(10);
                }else{
                    System.out.println(" est fausse" + System.lineSeparator());
                    matiere.getMastery().updateValue(-10);
                }
                lRep.add("Quiz DONE");

            }catch (InputMismatchException e){
                System.out.println("Merci d'entrer un entier [1..4]");
                scanner.next();
            }
        }while (lRep.size() == 4);



    }

     */
}
