package studentlife.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocController implements Initializable {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;

    @FXML
    private  Button commencerButton;
    @FXML
    private Label nomPrenom;
    @FXML
    private void commencer (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
        stage = (Stage) commencerButton.getScene().getWindow();
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        root = FXMLLoader.load(getClass().getResource("welcomeScreenView.fxml"));
        Scene scene = new Scene(root);
        nomPrenom.setText(nom + prenom);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
