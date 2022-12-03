package studentlife;


import studentlife.controller.GameController;
import studentlife.view.Game;
import studentlife.view.Input;


public class Main {
    public static void main(String[] args) {

        Game game = new Game(new GameController());


        game.run();

    }
}
