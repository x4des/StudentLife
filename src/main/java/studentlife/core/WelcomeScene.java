package studentlife.core;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WelcomeScene {

    private AnchorPane anchorPane;
    private Scene scene;

    private Stage stage;

    public WelcomeScene(String nom, String prenom) {
        anchorPane = new AnchorPane();
        scene = new Scene(anchorPane, 600, 600);
        StackPane stackPane = new StackPane();
        Label nomPrenom = new Label("Bonjour et bienvenue " + nom + " " + prenom);
        stackPane.getChildren().add(nomPrenom);
        anchorPane.getChildren().add(stackPane);

    }

    public Scene getScene() {
        return scene;
    }
}
