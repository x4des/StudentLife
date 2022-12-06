package studentlife.view;

import studentlife.controller.GameController;

/**
 * La classe abstraite Game implemente la classe Runnable qui elle possede
 une methode (public void run()).
 La Game de l'implementera pas direcetement mais via sa sous classe GUIGame.
 Elle est aussi a super classe de CosoleGame
 * @see studentlife.view.ui.GUIGame
 * @see studentlife.view.console.ConsoleGame
 Cette classe nous permet de demarrer la simulation.
 * */
public abstract class Game implements Runnable {

    private final GameController gameController;

    /**
     * @param gameController
     * constructeur de la classe Game
     * */
    public Game(GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * getter qui permet d'acceder à l'attribut gameController de l'objet
     * */
    protected GameController getController() {
        return gameController;
    }

}
