package studentlife.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    }

    public Stage getMainStage(){
        return mainStage;
    }
}
