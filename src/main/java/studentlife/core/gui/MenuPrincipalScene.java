package studentlife.core.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import studentlife.controller.GameController;
import studentlife.view.console.ConsoleGame;

public class MenuPrincipalScene {
    private AnchorPane anchorPane;
    private Scene scene;

    private Stage stage;
    private ConsoleGame game;

    public MenuPrincipalScene(ConsoleGame consoleGame) {
        this.game = consoleGame;
        anchorPane = new AnchorPane();
        scene = new Scene(anchorPane, 600, 600);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(createButtons());
        SWSimSubScene swSimSubScene = new SWSimSubScene();
        swSimSubScene.setLayoutX(100);
        swSimSubScene.setLayoutY(100);
        anchorPane.getChildren().add(swSimSubScene);
        anchorPane.getChildren().add(stackPane);
    }

    private HBox createButtons() {
        HBox hBox = new  HBox();
        hBox.getChildren().addAll(
                createPoursuivreBtn(),
                createStatsBtn(),
                createParametresBtn(),
                createQuitterBtn());
        return hBox;
    }

    private Button createPoursuivreBtn() {
        return new Button("Poursuivre");
    }

    private Button createStatsBtn() {
        return new Button("Statistiques");
    }

    private Button createParametresBtn() {
        return new Button("Parametres");
    }

    private Button createQuitterBtn() {
        return new Button("Quitter");
    }
}
