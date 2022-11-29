package studentlife.view;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private final String question;

    private final ArrayList<String> answers = new ArrayList<>();

    public Input(String question) {
        this.question = question;
    }

    public void addAnswer(String answer) {
        answers.add(answer);
    }

    public String resolve() {

        if(answers.size() <= 0)
            return null;

        // Print the question and the answers:
        System.out.println(question);

        for(int i = 0; i < answers.size(); i++) {
            System.out.println(i + 1 + ") " + answers.get(i));
        }

        Scanner scanner = new Scanner(System.in);

        int res = -1;

        while (res < 0 || res >= answers.size())
        {
             System.out.println("Please pick an answer: ");
             res = scanner.nextInt();
             res--;
        }

        return answers.get(res);
    }


}
