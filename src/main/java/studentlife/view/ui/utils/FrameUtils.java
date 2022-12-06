package studentlife.view.ui.utils;

import javax.swing.*;
import java.awt.*;

public class FrameUtils {

    // This method takes a JFrame and sets its position in the center of the screen depending on the resolution
    public static void setFrameCenter(JFrame jf) {
        if (jf == null) return;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = (screen.width - jf.getWidth()) / 2;
        int y = (screen.height - jf.getHeight()) / 2;
        jf.setLocation(x, y);
    }

    // This method takes a JFrame and sets its size depending on the screen resolution
    public static void setFrameSizeFromScreenResolution(JFrame jf) {
        if (jf == null) return;
        Dimension dim = getDimension();

        jf.setBounds(0, 0, dim.width, dim.height);
    }

    public static Dimension getDimension() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Width is approx 4/6 of the actual screen resolution and height is 2/3
        return new Dimension((screenSize.width / 6) * 2, (screenSize.height / 4) * 3);
    }

    public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public static ImageIcon resizeIconPercentage(ImageIcon icon, double resizedWidth, double resizedHeight) {
        Image img = icon.getImage();

        return (ImageIcon) resizeIcon(new ImageIcon(img),
                (int) (img.getWidth(null) * resizedWidth),
                (int) (img.getHeight(null) * resizedHeight));
    }

    public static JButton createButton(String path, double size) {

        ImageIcon buttonIcon = resizeIconPercentage(new ImageIcon(path), size, size);
        JButton button = new JButton(buttonIcon);

        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);

        return button;
    }

    public static void setFrameImgBg(JFrame jf, String name) {

        jf.setContentPane(new JPanel() {

            @Override
            protected void paintComponent(Graphics g){

                try {
                    Image img = getToolkit().getImage(name);

                    if(img != null){
                        g.drawImage(img, 0, 0, jf.getWidth(), jf.getHeight(), jf);
                    }

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
