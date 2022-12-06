package studentlife.core;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import studentlife.controller.GameController;
import studentlife.view.console.ConsoleGame;

import java.util.Scanner;

public class commencerButton extends SWSimButton{

    private TextField nom;
    private TextField prenom;
    private ConsoleGame consoleGame;

    public commencerButton(String text, ConsoleGame consoleGame, TextField nom, TextField prenom) {
        super(text);
        this.consoleGame =  consoleGame;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return this.nom.getText();
    }
    public String getPrenom() {
        return this.prenom.getText();
    }

    @Override
    public void initializeListeners(){
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setButtonPressedStyle();
                    WelcomeScene welcomeScene = new WelcomeScene(getPrenom(), getNom(), consoleGame);
                    Stage s = (Stage) commencerButton.super.getScene().getWindow();
                    s.setScene(welcomeScene.getScene());
                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setButtonStyle();
                }
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(new DropShadow());
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(null);
            }
        });
    }

}
