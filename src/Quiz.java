import java.util.ArrayList;

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

    public ArrayList<String> getReponses() {
        return reponses;
    }

    public void setReponses(ArrayList<String> reponses) {
        this.reponses = reponses;
    }

    public String getReponseCorrecte() {
        return this.reponseCorrecte;
    }
}
