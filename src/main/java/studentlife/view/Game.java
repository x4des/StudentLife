package studentlife.view;

import studentlife.controller.GameController;


public abstract class Game implements Runnable {


    private final GameController gameController;

    public Game(GameController gameController) {
        this.gameController = gameController;
    }

    public GameController getController() {
        return gameController;
    }

}
