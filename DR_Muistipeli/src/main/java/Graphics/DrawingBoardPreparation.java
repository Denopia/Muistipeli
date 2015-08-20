package Graphics;

import Game.GamePreparation;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Piirtää pelin valmisteluruudun
 * 
 */
public class DrawingBoardPreparation extends JPanel {

    private GamePreparation gp;

    public DrawingBoardPreparation(GamePreparation gp) {
        setOpaque(false);
        this.gp = gp;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(makeImage("game_prep_screen.png"), 0, 0, null);
        paintMode(g2d);
        paintCharacterFrames(g2d);
        paintPlayer(g2d);
        paintOpponent(g2d);
        paintDifficulty(g2d);
        paintMenu(g2d);
        paintStart(g2d);

        paintArrows(g2d);
    }

    public void paintMode(Graphics2D g2d) {
        Image mode = makeImage("battle_title.png");
        if (gp.getMode() == 1) {
            mode = makeImage("");
        } else if (gp.getMode() == 2) {
            mode = makeImage("battle_title.png");
        }
        g2d.drawImage(mode, 324, 59, null);
    }

    public void paintDifficulty(Graphics2D g2d) {
        g2d.drawImage(makeImage("difficulty_block.png"), 262, 605, null);
        if (gp.getD1() == true || gp.getDifficulty() == 1) {
            g2d.drawImage(makeImage("difficulty_0_highlight.png"), 262, 642, null);
        } else {
            g2d.drawImage(makeImage("difficulty_0.png"), 262, 642, null);
        }
        if (gp.getD2() == true || gp.getDifficulty() == 2) {
            g2d.drawImage(makeImage("difficulty_1_highlight.png"), 381, 642, null);
        } else {
            g2d.drawImage(makeImage("difficulty_1.png"), 381, 642, null);
        }
        if (gp.getD3() == true || gp.getDifficulty() == 3) {
            g2d.drawImage(makeImage("difficulty_2_highlight.png"), 500, 642, null);
        } else {
            g2d.drawImage(makeImage("difficulty_2.png"), 500, 642, null);
        }
        if (gp.getD4() == true || gp.getDifficulty() == 4) {
            g2d.drawImage(makeImage("difficulty_3_highlight.png"), 619, 642, null);
        } else {
            g2d.drawImage(makeImage("difficulty_3.png"), 619, 642, null);
        }
    }

    public void paintMenu(Graphics2D g2d) {
        if (gp.getMenu() == true) {
            g2d.drawImage(makeImage("menu_arrow_highlight.png"), 35, 618, null);
        } else {
            g2d.drawImage(makeImage("menu_arrow.png"), 35, 618, null);
        }
    }

    public void paintStart(Graphics2D g2d) {
        if (gp.getStart() == true) {
            g2d.drawImage(makeImage("start_arrow_highlight.png"), 795, 618, null);
        } else {
            g2d.drawImage(makeImage("start_arrow.png"), 795, 618, null);
        }
    }

    public void paintCharacterFrames(Graphics2D g2d) {
        g2d.drawImage(makeImage("character_frame.png"), 639, 156, null);
        g2d.drawImage(makeImage("character_frame.png"), 155, 156, null);
    }

    public void paintPlayer(Graphics2D g2d) {
        if (gp.getPlayerCharacter() == 1) {
            g2d.drawImage(makeImage("gus_neutral.png"), 161, 162, null);
        } else if (gp.getPlayerCharacter() == 2) {
            g2d.drawImage(makeImage("apollo_neutral.png"), 161, 162, null);
        } else if (gp.getPlayerCharacter() == 3) {
            g2d.drawImage(makeImage("ROBO.png"), 161, 162, null);
        }
    }

    public void paintOpponent(Graphics2D g2d) {
        if (gp.getOpponentCharacter() == 1) {
            g2d.drawImage(makeImage("gus_neutral.png"), 645 + 200, 162, -200, 300, null);
        } else if (gp.getOpponentCharacter() == 2) {
            g2d.drawImage(makeImage("apollo_neutral.png"), 645 + 200, 162, -200, 300, null);
        } else if (gp.getOpponentCharacter() == 3) {
            g2d.drawImage(makeImage("ROBO.png"), 645 + 200, 162, -200, 300, null);
        }
    }

    public void paintArrows(Graphics2D g2d) {
        if (gp.getA1() == true) {
            g2d.drawImage(makeImage("arrow_highlight.png"), 119 + 26, 287, -26, 50, null);
        } else {
            g2d.drawImage(makeImage("arrow.png"), 119 + 26, 287, -26, 50, null);
        }
        if (gp.getA2() == true) {
            g2d.drawImage(makeImage("arrow_highlight.png"), 377, 287, null);
        } else {
            g2d.drawImage(makeImage("arrow.png"), 377, 287, null);
        }
        if (gp.getA3() == true) {
            g2d.drawImage(makeImage("arrow_highlight.png"), 603 + 26, 287, -26, 50, null);
        } else {
            g2d.drawImage(makeImage("arrow.png"), 603 + 26, 287, -26, 50, null);
        }
        if (gp.getA4() == true) {
            g2d.drawImage(makeImage("arrow_highlight.png"), 861, 287, null);
        } else {
            g2d.drawImage(makeImage("arrow.png"), 861, 287, null);
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