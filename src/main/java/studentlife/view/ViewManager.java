package studentlife.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import studentlife.core.SWSimButton;

public class ViewManager {

    private static final int HEIGHT = 600;
    private static final int WIDTH = 600;
    private AnchorPane anchorPane;
    private Scene mainScene;
    private Stage mainStage;

    public ViewManager(){
        anchorPane = new AnchorPane();
        mainScene = new Scene(anchorPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButtons();
    }

    public Stage getMainStage(){
        return mainStage;
    }

    public void createButtons(){
        SWSimButton button = new SWSimButton("commencer");
        anchorPane.getChildren().add(button);
    }
}
