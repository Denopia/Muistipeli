package Graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawingBoardMenu extends JPanel {

    private final String[] pictures = {"mainmenublank.png", "mainmenuspg.png", "mainmenuins.png", "mainmenuexit.png"};
    private String currentPicture;

    public DrawingBoardMenu() {
        this.currentPicture = pictures[0];
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(makeImage(currentPicture), 0, 0, null);
    }

    public Image makeImage(String path) {
        ImageIcon icon = null;
        java.net.URL imgURL = getClass().getClassLoader().getResource(path);
        if (imgURL != null) {
            icon = new ImageIcon(imgURL);
        } else {
            System.err.println("Picture " + path + " not found");
        }
        Image img = icon.getImage();
        return img;
    }

    public void setImage(int state) {
        currentPicture = pictures[state];
    }

}
