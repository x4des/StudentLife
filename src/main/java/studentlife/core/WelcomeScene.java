package studentlife.core;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WelcomeScene {

    private AnchorPane anchorPane;
    private Scene scene;

    private Stage stage;

    public WelcomeScene() {
        anchorPane = new AnchorPane();
        scene = new Scene(anchorPane, 600, 600);
    }

    public Scene getScene() {
        return scene;
    }
}
