/**
 * Contient FrameUtils qui permet de créer les elements d'une console graphique.
 * */
package studentlife.view.ui.utils;

import javax.swing.*;
import java.awt.*;

/**
 * La classe FrameUtils nous permet d'implémenter les méthodes de créer
 toutes les composantes de l'interface graphique
 * */
public class FrameUtils {

    /**
     * @param jf
     * Cette methode prend un JFrame en paramètre
     * et defini une position au centre de l'écran selon la résoltion.
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
     * @param jf
     * Cette methode prend un JFrame en paramètre et
     defini sa taille en fonction de la resolution de l'écran.
     * */
    public static void setFrameSizeFromScreenResolution(JFrame jf) {
        if (jf == null) return;
        Dimension dim = getDimension();

        jf.setBounds(0, 0, dim.width, dim.height);
    }

    /**
<<<<<<< HEAD
     * @return retourne la dimension de l'écran graphique
     * La longueur sera d'environ 4/6 de la taille de l'écran et la largeur 2/3.
=======
     * @return retourne la dimension de l'ecran graphique
     * La largeur sera d'environ 3/6 de la taille de l'ecran et la hauteur 3/4.
>>>>>>> 1f3c61658d6c572a758e386059c08dcffdc3cde5
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
     * @return cette methode retourne comme resizeIcon() un nouvel cadre pour la simu
     cependant les valeurs misent en paramètre sont des pourcentages qui permettront de
     d'augmenter ou diminuer la dimension.
     * */
    public static ImageIcon resizeIconPercentage(ImageIcon icon, double resizedWidth, double resizedHeight) {
        Image img = icon.getImage();

        return (ImageIcon) resizeIcon(new ImageIcon(img),
                (int) (img.getWidth(null) * resizedWidth),
                (int) (img.getHeight(null) * resizedHeight));
    }

    /**
     * @param path chemin d'un fichier où est l'image
     * @param size dimensions
     * @return Cette methode retourne un JButton qui est un bouton créer à partir
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
     * @param jf un jframe
     * @param name nom de fichier
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
