package studentlife;

import studentlife.controller.GameController;
import studentlife.view.console.Input;
import studentlife.view.Game;
import studentlife.view.console.ConsoleGame;
import studentlife.view.ui.GUIGame;

/**
 * La classe Main nous permet d'exécuter tout le programme
 * L'utilisateur à la possibilité de choisir l'affichage du jeu souhaité.
 * */
public class Main {


    public static void main(String[] args) {

        Input input = new Input("Comment voulez vous jouer ?");
        input.addAnswer("Console");
        input.addAnswer("Graphical UI");

        Game game; //déclaration du jeu

        if(input.resolve().equals("Console"))
            game = new ConsoleGame(new GameController()); //on initialise le jeu en mode console
        else
            game = new GUIGame(new GameController()); //on initialise le jeu en mode GUI

        game.run(); //execution du jeu
    }
}
