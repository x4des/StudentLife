import java.util.ArrayList;
import java.util.Random;

public class Quiz {
    private String question;
    private ArrayList<String> reponses;
    private String reponseCorrecte;

    public Quiz(String question, String reponseCorrecte){
        this.question = question;
        this.reponses = new ArrayList<String>();
        this.reponseCorrecte = reponseCorrecte;
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
    
    //retourne les reponses correctes ou incorrectes
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
}
