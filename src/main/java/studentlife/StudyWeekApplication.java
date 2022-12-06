package studentlife;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import studentlife.controller.GameController;
import studentlife.view.Game;
import studentlife.view.ViewManager;

public class StudyWeekApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //StackPane root = new StackPane();
        ViewManager viewManager = new ViewManager();
        primaryStage = viewManager.getMainStage();
        primaryStage.setResizable(false);
        primaryStage.show();

    }/*
    Game game = new Game(new GameController());
    @FXML
    protected Label StartBtn;
    @FXML
    public void onStartButtonClick(ActionEvent actionEvent) {
        actionEvent.consume();
        this.game.run();
    }*/
}
