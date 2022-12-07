package studentlife.core.gui;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.net.URL;

public class SWSimSubScene extends SubScene {

    private boolean isHidden = true;

    //private final String BG_IMAGE;

    public SWSimSubScene() {
        super(new AnchorPane(), 600, 400);
        prefWidth(600);
        prefHeight(400);
        /*BackgroundImage image = new BackgroundImage(new Image("file:///comptes/E21B584U/2022-2023/oop/projet/poo22_384j_c/src/main/java/studentlife/core/resources/sws_background.png", 600, 400, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(image));*/
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
