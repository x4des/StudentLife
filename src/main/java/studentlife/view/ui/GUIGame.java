package studentlife.view.ui;

import studentlife.controller.GameController;
import studentlife.view.Game;
import studentlife.view.ui.utils.FrameUtils;

import javax.swing.*;
import java.awt.*;

public class GUIGame extends Game {

    private final JFrame mainFrame = new JFrame();

    public GUIGame(GameController controller) {
        super(controller);
    }

    @Override
    public void run() {

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
