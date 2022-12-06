package studentlife.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import studentlife.controller.GameController;
import studentlife.core.SWSimButton;
import studentlife.core.WelcomeScene;
import studentlife.core.commencerButton;
import studentlife.view.console.ConsoleGame;

import java.util.Stack;

public class ViewManager {

    private static final int HEIGHT = 600;
    private static final int WIDTH = 600;
    private AnchorPane anchorPane;
    private Scene mainScene;
    private Stage mainStage;
    private ConsoleGame game;
    private GameController gameController;
    private TextField nom;
    private TextField prenom;

    public ViewManager(){
        anchorPane = new AnchorPane();
        mainScene = new Scene(anchorPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        /*createButtons();*/
        createEverything(anchorPane);
        game = new ConsoleGame(new GameController());
    }

    public Stage getMainStage(){
        return mainStage;
    }

    public void createButtons(Pane pane){

        SWSimButton button = new SWSimButton("commencer");
        pane.getChildren().add(button);
    }

    public void createEverything(AnchorPane anchorPane) {
        StackPane mainPageStackPane = createStackPaneElements();
        anchorPane.getChildren().add(mainPageStackPane);
    }

    public StackPane createStackPaneElements(){
        StackPane stackPane = new StackPane();
        VBox vbox1 = new VBox();

        createVBoxElements(vbox1);

        stackPane.getChildren().add(vbox1);
        return stackPane;
    }

    public void createVBoxElements(VBox vBox){
        HBox hBoxPrenom = new HBox();
        HBox hBoxNom = new HBox();

        createHBoxElements(hBoxPrenom, "Prenom", prenom);
        vBox.getChildren().add(hBoxPrenom);

        createHBoxElements(hBoxNom, "     Nom", nom);
        vBox.getChildren().add(hBoxNom);

        SWSimButton button = new commencerButton("commencer", game, nom, prenom);
        vBox.getChildren().add(button);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
    }

    public void createHBoxElements(HBox hBox, String str, TextField inputText){
        Label text = createLabel(str);
        TextField textField = new TextField();
        hBox.getChildren().add(text);
        hBox.getChildren().add(textField);
        inputText = textField;
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
    }

    public Label createLabel(String str){
        return new Label(str);
    }

}
