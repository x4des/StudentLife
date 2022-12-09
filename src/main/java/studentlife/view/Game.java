package studentlife.view;

import studentlife.controller.GameController;

/**
 * La classe abstraite Game implémente la classe Runnable qui elle possède
 une methode (public void run()).
 La Game ne l'implémentera pas directement, mais via sa sous classe GUIGame ou ConsoleGame.
 * @see studentlife.view.ui.GUIGame
 * @see studentlife.view.console.ConsoleGame
 * */
public abstract class Game implements Runnable {

    /**le gameController*/
    private final GameController gameController;

    /**
     * constructeur de la classe Game
     * @param gameController un gameController
     * */
    public Game(GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * Getter qui permet d'accéder à l'attribut gameController
     * @return retourne un GameController
     * */
    protected GameController getController() {
        return gameController;
    }

}
