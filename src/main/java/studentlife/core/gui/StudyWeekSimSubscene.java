package studentlife.core.gui;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class StudyWeekSimSubscene extends SubScene {
    private boolean isHidden = true;

    public StudyWeekSimSubscene() {
        super(new AnchorPane(), 600, 400);
        prefWidth(600);
        prefHeight(400);

        AnchorPane root2 = (AnchorPane) this.getRoot();

        setLayoutX(1024);
        setLayoutY(180);
    }

    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.5));
        transition.setNode(this);
        if(isHidden) {
            transition.setToX(-676);
            isHidden = false;
        } else {
            transition.setToX(0);
            isHidden = true;
        }
        transition.play();
    }
    public AnchorPane getPane() {
        return (AnchorPane) this.getRoot();
    }
}
