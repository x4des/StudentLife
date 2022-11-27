package studentlife.core.actions;

import studentlife.core.Matiere;

import java.util.*;

public class Quiz {
    private final String question;
    private final ArrayList<String> reponses;
    private final String reponseCorrecte;
    private int reponseUser;

    public Quiz(String question, String reponseCorrecte){
        this.question = question;
        this.reponses = new ArrayList<String>();
        this.reponseCorrecte = reponseCorrecte;
        this.reponseUser = 0;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getReponseCorrecte() {
        return this.reponseCorrecte;
    }

    //On aura 3 reponses fausse a ajouter
    public void setUneReponse(String reponse) {
        if(this.reponses.size() < 3) {
            this.reponses.add(reponse);
        };
    }
    
    //retourne les reponses correctes et incorrectes
    public ArrayList<String> getReponses() {

        try {
            if(this.reponses.size() > 0) {

                Random random = new Random();

                int reponseCorrecteIndice = random.nextInt(4); //4 car je suppose que c'est un choix entre 4 reponses
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

    public void realiserQuiz(Matiere matiere){

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
                    //TODO: Modifier les stats dans cette matiere
                    //matiere.updateNiveau(10);
                }else{
                    System.out.println(" est fausse" + System.lineSeparator());
                    //matiere.updateNiveau(-10);
                }
                lRep.add("Quiz DONE");

            }catch (InputMismatchException e){
                System.out.println("Merci d'entrer un entier [1..4]");
                scanner.next();
            }
        }while (lRep.size() == 4);

    }
}
