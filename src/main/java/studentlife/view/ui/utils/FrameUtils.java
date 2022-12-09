package studentlife.view.ui.utils;

import javax.swing.*;
import java.awt.*;

/**
 * La classe FrameUtils nous permet d'implémenter les méthodes et de créer
 toutes les composantes de l'interface graphique
 * */
public class FrameUtils {

    /**
     * @param jf un jframe
     * Cette methode prend un JFrame en paramètre
     * et defini une position au centre de l'écran selon la résolution.
     * */
    public static void setFrameCenter(JFrame jf) {
        if (jf == null) return;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = (screen.width - jf.getWidth()) / 2;
        int y = (screen.height - jf.getHeight()) / 2;
        jf.setLocation(x, y);
    }

    /**
     * @param jf un jframe
     * Cette methode prend un JFrame en paramètre et
     définit sa taille en fonction de la résolution de l'écran.
     * */
    public static void setFrameSizeFromScreenResolution(JFrame jf) {
        if (jf == null) return;
        Dimension dim = getDimension();

        jf.setBounds(0, 0, dim.width, dim.height);
    }

    /**
     * @return retourne la résolution de l'écran actuel
     * La largeur sera de 3/6 de la taille de l'écran et la hauteur de 3/4.
     * */
    public static Dimension getDimension() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new Dimension((screenSize.width / 6) * 3, (screenSize.height / 4) * 3);
    }

    /**
     * @param icon l'image de fond à remplacer
     * @param resizedWidth la valeur de la largeur à remplacer
     * @param resizedHeight la valeur de la longueur à remplacer
     * @return Cette methode retourne un nouveau cadre graphique, avec
     un nouvel image et une nouvelle dimension
     * */
    public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    /**
     * @param icon nouveau fond d'écran
     * @param resizedWidth nouvelle largeur
     * @param resizedHeight nouvelle longueur
     * @return cette methode retourne comme resizeIcon() un nouveau cadre pour la simulation
     cependant les valeurs misent en paramètre sont des pourcentages qui permettront
     d'augmenter ou diminuer la dimension.
     * */
    public static ImageIcon resizeIconPercentage(ImageIcon icon, double resizedWidth, double resizedHeight) {
        Image img = icon.getImage();

        return (ImageIcon) resizeIcon(new ImageIcon(img),
                (int) (img.getWidth(null) * resizedWidth),
                (int) (img.getHeight(null) * resizedHeight));
    }

    /**
     * @param path chemin du fichier où l'image se trouve
     * @param size dimensions
     * @return Cette methode crée un bouton JButton et le retourne
     * */
    public static JButton createButton(String path, double size) {

        ImageIcon buttonIcon = resizeIconPercentage(new ImageIcon(path), size, size);
        JButton button = new JButton(buttonIcon);

        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);

        return button;
    }

    /**
     * @param jf un JFrame
     * @param name chemin du fichier
     * Défini un cadre par une image.
     * */
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
