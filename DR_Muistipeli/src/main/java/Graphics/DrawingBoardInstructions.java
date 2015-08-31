package Graphics;

import Game.Instructions;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawingBoardInstructions extends JPanel {

    private Instructions ins;

    public DrawingBoardInstructions(Instructions ins) {
        setOpaque(false);
        this.ins = ins;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        paintBackGround(g2d);
        paintButtons(g2d);
    }

    private void paintBackGround(Graphics2D g2d) {
        g2d.drawImage(makeImage("instructions_screen.png"), 0, 0, null);
    }

    private void paintButtons(Graphics2D g2d) {
        if (ins.getHController().getMenuH()) {
            g2d.drawImage(makeImage("menu_arrow_highlight.png"), 26, 25, null);
        } else {
            g2d.drawImage(makeImage("menu_arrow.png"), 26, 25, null);
        }
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
}
