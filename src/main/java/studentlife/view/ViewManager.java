package studentlife.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import studentlife.controller.GameController;
import studentlife.core.gui.SWSimSubScene;
import studentlife.core.gui.StudyWeekSimSubscene;
import studentlife.core.gui.utils.SWSimButton;
import studentlife.core.gui.WelcomeScene;
import studentlife.core.gui.utils.StudyWeekSimButton;
import studentlife.core.gui.utils.commencerButton;
import studentlife.view.console.ConsoleGame;

import java.util.ArrayList;
import java.util.Stack;

public class ViewManager {

    private static final int MENU_BUTTON_START_X = 100;
    private static final int MENU_BUTTON_START_Y = 100;
    private static final int HEIGHT = 600;
    private static final int WIDTH = 600;
    private AnchorPane anchorPane;
    private Scene mainScene;
    private Stage mainStage;
    private ConsoleGame game;
    private GameController gameController;
    private TextField nom;
    private TextField prenom;
    public ArrayList<Button> menuButtons;
    private StudyWeekSimSubscene sceneToHide;

    public ViewManager(){
        menuButtons = new ArrayList<Button>();
        anchorPane = new AnchorPane();
        mainScene = new Scene(anchorPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        nom = new TextField();
        prenom = new TextField();
        createElements();
        /*createEverything(anchorPane);
        //game = new ConsoleGame(new GameController());*/


    }

    public Stage getMainStage(){
        return mainStage;
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

        /*SWSimButton button = new commencerButton("commencer", game, nom, prenom);
        vBox.getChildren().add(button);*/

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
    }

    public void createHBoxElements(HBox hBox, String str, TextField inputText){
        Label text = createLabel(str);

        hBox.getChildren().add(text);
        hBox.getChildren().add(inputText);

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
    }

    public Label createLabel(String str){
        return new Label(str);
    }

    //V2
    private void createElements() {
        createTextFields();
        createButtons();
    }

    private void createButtons() {
        createCommencerBtn();
        createMenuBtn();
    }
    private void createMenuBtn() {
        Button menu = new Button("menu");
        anchorPane.getChildren().add(menu);
        menu.setLayoutX(200);
        menu.setLayoutY(200);

        menu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StudyWeekSimSubscene subscene = new StudyWeekSimSubscene();
                AnchorPane subAnchorPane = new AnchorPane();
                createMenuButtons();
                Label menuTxt = new Label("Menu");

                subAnchorPane.getChildren().add(menuTxt);

                for(Button b : menuButtons){
                    subAnchorPane.getChildren().add(b);
                }
                showSubScene(subscene);
                //anchorPane.getChildren().add(subscene);
            }
        });
    }

    private void showSubScene(StudyWeekSimSubscene subScene) {
        if (sceneToHide != null) {
            sceneToHide.moveSubScene();
        }
        subScene.moveSubScene();
        sceneToHide = subScene;
    }

    private void addMenuButton(StudyWeekSimButton b) {
        b.setLayoutX(MENU_BUTTON_START_X);
        b.setLayoutY((MENU_BUTTON_START_Y + menuButtons.size()* 50));

        menuButtons.add(b);
    }

    private void createCommencerBtn() {
        StudyWeekSimButton commencer  = new StudyWeekSimButton("commencer");
        anchorPane.getChildren().add(commencer);
        commencer.setLayoutX(150);
        commencer.setLayoutY(150);

        commencer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.getController().initGame(nom.getText(), prenom.getText());
            }
        });

    }

    private void createTextFields() {
        nom = new TextField();
        prenom = new TextField();

        anchorPane.getChildren().add(nom);
        nom.setLayoutX(10);
        nom.setLayoutY(10);

        anchorPane.getChildren().add(prenom);
        prenom.setLayoutX(10);
        prenom.setLayoutY(40);

    }

    private void createMenuButtons(){
        createContinuerBtn();
        createStatsBtn();
        createParamBtn();
        createQuitBtn();
    }

    private void createContinuerBtn() {
        StudyWeekSimButton continuer = new StudyWeekSimButton("continuer");
        addMenuButton(continuer);
        continuer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

    }

    private void createParamBtn() {
        StudyWeekSimButton parametres = new StudyWeekSimButton("parametres");
        addMenuButton(parametres);
        parametres.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

    }

    private void createStatsBtn() {
        StudyWeekSimButton statistiques = new StudyWeekSimButton("statistiques");
        addMenuButton(statistiques);
        statistiques.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

    }

    private void createQuitBtn() {
        StudyWeekSimButton quitter = new StudyWeekSimButton("quitter");
        addMenuButton(quitter);
        quitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

    }

}
