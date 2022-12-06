package studentlife.core;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Window;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SWSimButton extends Button {

    private final String FONT_PATH = "";
    private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('studentlife/core/resources/brown.png');";
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/studentlife/core/resources/brown_pressed.png');";


    public SWSimButton(String text){
        setText(text);
        setButtonFont();
        setPrefHeight(48);
        setPrefHeight(48);
        //setStyle(BUTTON_STYLE);
        initializeListeners();
    }

    private void setButtonFont(){
        try{
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
        }catch (FileNotFoundException e){
            setFont(Font.font("Calibri", 23));
        }
    }

    public void setButtonStyle(){
        //setStyle(BUTTON_STYLE);
        setPrefHeight(50);
        setLayoutY(getLayoutY() - 4);
    }

    public void setButtonPressedStyle(){
        //setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }

    public void initializeListeners(){
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setButtonPressedStyle();
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
