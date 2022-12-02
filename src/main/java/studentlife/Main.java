package studentlife;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import studentlife.controller.GameController;
import studentlife.view.Game;
import studentlife.view.Input;

public class Main extends Application {
    public static void main(String[] args) {

        /*Game game = new Game(new GameController());*/

        launch();
        //game.run();


         /*
         Etudiant etudiant = new Etudiant("Gosling", "Ryan");

        //affichage de ses infos de depart
        System.out.print("\f");
        System.out.println(etudiant.getNomPrenom());
        etudiant.afficherStatsPerso();


        //creation des profs
        Professeur prof1 = new Professeur("Rooney", "Wayne");
        Professeur prof2 = new Professeur("Darko", "Donnie");
        Professeur prof3 = new Professeur("Snow", "Jon");
        Professeur prof4 = new Professeur("Austen", "Jane");
        Professeur prof5 = new Professeur("Lovelace", "Ada");
        Professeur prof6 = new Professeur("Corleone", "Vito");
        Professeur prof7 = new Professeur("Ventura", "Ace");


        System.out.println(prof1.getNomPrenom());
        System.out.println(prof1.getAffection() + "/100");

        //creation des matières
        Matiere ISI = new Matiere("Introduction aux systemes d'information", prof1);
        Matiere CDE = new Matiere("Connaissance de l'entreprise", prof6);
        Matiere POO = new Matiere("Programmation orientée objet", prof2);
        Matiere IF = new Matiere("Informatique fondamentale", prof3);
        Matiere MI = new Matiere("Mathématiques pour l'informatique", prof7);
        Matiere ASD = new Matiere("Algorithmique et structure de données", prof5);
        Matiere Ang = new Matiere("Anglais scientifique général", prof4);

        //ajout de liste de cours possibles pour chaque matière
        ISI.addCours(Type.CM, Type.TD, Type.TP);
        CDE.addCours(Type.TD);
        POO.addCours(Type.CM, Type.TD, Type.TP);
        IF.addCours(Type.CM, Type.TD, Type.TP);
        MI.addCours(Type.CM, Type.TD);
         */
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //StackPane root = new StackPane();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
        primaryStage.setTitle("StudentLife Sim");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    Game game = new Game(new GameController());
    @FXML
    protected Label StartBtn;
    @FXML
    public void onStartButtonClick(ActionEvent actionEvent) {
        actionEvent.consume();
        this.game.run();
    }
}
