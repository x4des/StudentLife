package studentlife.core;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import studentlife.controller.GameController;
import studentlife.view.console.ConsoleGame;
import studentlife.view.console.Input;

public class WelcomeScene implements Runnable{

    private AnchorPane anchorPane;
    private Scene scene;

    private Stage stage;
    private ConsoleGame game;
    private String nom;
    private String prenom;

    public WelcomeScene(String nom, String prenom, ConsoleGame consoleGame) {
        anchorPane = new AnchorPane();
        scene = new Scene(anchorPane, 600, 600);
        StackPane stackPane = new StackPane();

        this.nom = nom;
        this.prenom = prenom;

        Label nomPrenom = new Label("Bonjour et bienvenue " + this.nom + " " + this.prenom);
        stackPane.getChildren().add(nomPrenom);
        anchorPane.getChildren().add(stackPane);
        game = new ConsoleGame(new GameController());
        run();
    }

    public Scene getScene() {
        return scene;
    }

    @Override
    public void run() {
        this.game.getController().initGame(nom, prenom);
    }

    //TODO: Change game methods behavior to create Scenes instead of printing lines
    private void menuPrincipal(){

        Input question = new Input("Menu Principal        "+ "Etudiant(e): " + game.getController().getUser().toString()
        );
        question.addAnswer("Poursuivre le jeu");//0
        question.addAnswer("Statistiques");//1
        question.addAnswer("Paramètres");
        question.addAnswer("Quitter le jeu");
        String rep = question.resolve();

        if (rep.equals("Poursuivre le jeu")){
            game.lookForEvent();
        }

        if(rep.equals("Statistiques")) {
            game.menuStatistiques();
        }

        if (rep.equals("Paramètres")){
            game.parametres();
        }

        if (rep.equals("Quitter le jeu")){
            game.endGame();

        }


    }

}
