import java.util.*;

public class Quiz {
    private final String question;
    private final ArrayList<String> reponses;
    private final String reponseCorrecte;
    private String reponseUser;

    public Quiz(String question, String reponseCorrecte){
        this.question = question;
        this.reponses = new ArrayList<String>();
        this.reponseCorrecte = reponseCorrecte;
        this.reponseUser = "";
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

    public void setReponseUser(String reponseUser) {
        this.reponseUser = reponseUser;
    }

    public String getReponseUser() {
        return reponseUser;
    }

    public void realiserQuiz(Matiere matiere){

        ArrayList<String> lRep = this.getReponses();

        //affichage: qst et reponses possibles
        System.out.println(this.question + System.lineSeparator());
        for(String rep: lRep){
            System.out.println(rep + System.lineSeparator());
        }

        //entree utilisateur
        Scanner scanner = new Scanner(System.in);
        do{
            try {

                this.reponseUser = scanner.nextLine();
                System.out.println("Votre reponse: " + this.reponseUser);

                if(this.reponseUser.equals(this.reponseCorrecte)){
                    System.out.println(" est correcte");
                    //FIXME: Matiere a besoin de updateNiveau au niveau de la dev branch
                    //matiere.updateNiveau(10);
                }else{
                    System.out.println(" est fausse" + System.lineSeparator());
                    //matiere.updateNiveau(-10);
                }

            }catch (InputMismatchException e){
                System.out.println("Merci d'entrer une chaine de caracteres");
            }
        }while (!(lRep.contains(this.reponseUser)));

    }
}
