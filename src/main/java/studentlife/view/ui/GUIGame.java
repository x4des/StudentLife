
/**
 * Contient la classe GUIGame qui creer une fenetre de jeu.
 * */
package studentlife.view.ui;

import studentlife.controller.GameController;
import studentlife.view.Game;
import studentlife.view.ui.utils.FrameUtils;

import javax.swing.*;
import java.awt.*;

/**
 * La classe GUIGame est la sous classe de Game qui implémente l'interface Runnable
 * @see Game
 * */
public class GUIGame extends Game {

    /**un JFrame */
    private final JFrame mainFrame = new JFrame();

    /**
     * @param controller
     * constructeur de la sous classe
     * */
    public GUIGame(GameController controller) {
        super(controller);
    }

    /**
     * La methode run() de l'interface Runnable.
     Elle permet de lancer la simulation avec une interface graphique.
     * */
    @Override
    public void run() {
        //titre de jeu (de la fenêtre)
        mainFrame.setTitle("Student Life Simulator");
        // Set the propriety of default close
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the window according to the screen resolution
        FrameUtils.setFrameSizeFromScreenResolution(mainFrame);
        // user cannot resize the window
        mainFrame.setResizable(false);
        // Set the frame to the screen center
        FrameUtils.setFrameCenter(mainFrame);
        // Set the background image of the loader
        FrameUtils.setFrameImgBg(mainFrame, "assets/bg.jpg");
        // Set a layout for the frame
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
    }


}
