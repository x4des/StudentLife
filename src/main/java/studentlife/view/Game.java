/** Ce package contient la classe Game, ConsoleGame et Input*/
package studentlife.view;

import studentlife.controller.GameController;

/**
 * La classe abstraite Game implémente la classe Runnable qui elle possède
 une methode (public void run()).
 La Game ne l'implémentera pas directement mais via sa sous classe GUIGame.
 Elle est aussi à super classe de ConsoleGame
 * @see studentlife.view.ui.GUIGame
 * @see studentlife.view.console.ConsoleGame
 Cette classe nous permet de demarrer la simulation.
 * */
public abstract class Game implements Runnable {

    /**le gameController*/
    private final GameController gameController;

    /**
     * @param gameController un gameController
     * constructeur de la classe Game
     * */
    public Game(GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * @return retourne un GameController
     * getter qui permet d'accéder à l'attribut gameController de l'objet
     * */
    protected GameController getController() {
        return gameController;
    }

}
