package studentlife;

import studentlife.controller.GameController;
import studentlife.view.console.Input;

import studentlife.view.Game;
import studentlife.view.console.ConsoleGame;
import studentlife.view.ui.GUIGame;

/**
 * La classe main nous permet d'exécuter tout le programme
 * */
public class Main {
    public static void main(String[] args) {

        Input input = new Input("Comment voulez vous jouer ?");
        input.addAnswer("Console");
        input.addAnswer("Graphical UI");

        Game game;

        if(input.resolve().equals("Console"))
            game = new ConsoleGame(new GameController());
        else
            game = new GUIGame(new GameController());

        game.run();
    }
}
