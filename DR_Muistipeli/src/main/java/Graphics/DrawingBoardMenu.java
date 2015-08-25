package Graphics;

import Game.MainMenu;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Piirtää valikkoruudun
 *
 */
public class DrawingBoardMenu extends JPanel {

    private MainMenu menu;
    private final String[] pictures = {"mainmenu/main_menu_blank.png",
        "mainmenu/only_single_player_button_highlight.png",
        "mainmenu/only_single_player_button.png",
        "mainmenu/instructions_button_highlight.png", "mainmenu/instructions_button.png",
        "mainmenu/exit_button_highlight.png", "mainmenu/exit_button.png"};

    public DrawingBoardMenu(MainMenu menu) {
        this.menu = menu;
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(makeImage(pictures[0]), 0, 0, null);
        paintButtons(g);
    }

    public void paintButtons(Graphics g2d) {
        if (menu.getSPG()) {
            g2d.drawImage(makeImage(pictures[1]), 406, 234, null);
        } else {
            g2d.drawImage(makeImage(pictures[2]), 406, 234, null);
        }
        if (menu.getIns()) {
            g2d.drawImage(makeImage(pictures[3]), 464, 457, null);
        } else {
            g2d.drawImage(makeImage(pictures[4]), 464, 457, null);
        }
        if (menu.getExit()) {
            g2d.drawImage(makeImage(pictures[5]), 464, 557, null);
        } else {
            g2d.drawImage(makeImage(pictures[6]), 464, 557, null);
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
