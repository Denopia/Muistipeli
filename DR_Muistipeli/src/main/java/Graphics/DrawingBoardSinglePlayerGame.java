package Graphics;

import Game.GameModes.SinglePlayerGame;
import Tile.Tile;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Piirtää peliruudun
 *
 */
public class DrawingBoardSinglePlayerGame extends JPanel {

    private SinglePlayerGame game;

    public DrawingBoardSinglePlayerGame(SinglePlayerGame game) {
        this.game = game;
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        paintBackground(g2d);
        paintFrames(g2d);
        paintPlayers(g2d);
        paintStats(g2d);
        paintTiles(g2d);
    }
    
    public void paintPlayers(Graphics2D g2d){
        g2d.drawImage(game.getPlayer().getPortrait(), 18, 139, null);
        g2d.drawImage(game.getOpponent().getPortrait(), 789 + 200, 139, -200, 300, null);
    }

    public void paintBackground(Graphics2D g2d) {
         g2d.drawImage(makeImage("background.png"), 0, 0, null);
    }

    private void paintTiles(Graphics2D g2d) {
        for (Tile tile : game.getTiles()) {
            g2d.drawImage(tile.getImage(), tile.getX(), tile.getY(), null);
            if (tile.getHighlight() && !game.getPlayer().getSkill1Selected()) {
                g2d.drawImage(tile.getHighlightImage(), tile.getX(), tile.getY(), null);
            }
        }
        
        if (game.getPlayer().getSkill1Selected()) {
            Image img = makeImage("skill_1_area.png");
            if (game.getHorRow() == 1) {
                g2d.drawImage(img, 259 - 9, 185 - 38, null);
            } else if (game.getHorRow() == 2) {
                g2d.drawImage(img, 259 - 9, 270 - 38, null);
            } else if (game.getHorRow() == 3) {
                g2d.drawImage(img, 259 - 9, 355 - 38, null);
            } else if (game.getHorRow() == 4) {
                g2d.drawImage(img, 259 - 9, 440 - 38, null);
            } else if (game.getHorRow() == 5) {
                g2d.drawImage(img, 259 - 9, 525 - 38, null);
            } else if (game.getHorRow() == 6) {
                g2d.drawImage(img, 259 - 9, 610 - 38, null);
            }
        }
    }

    private void paintFrames(Graphics2D g2d) {
//        if (BSPG.isPlayersTurn()) {
//            g2d.drawImage(makeImage("character_frame_light.png"), 12, 133, null);
        g2d.drawImage(makeImage("character_frame.png"), 783, 133, null);
//        } else {
        g2d.drawImage(makeImage("character_frame.png"), 12, 133, null);
//            g2d.drawImage(makeImage("character_frame_light.png"), 783, 133, null);
//        }
    }

    private void paintStats(Graphics2D g2d) {
        paintContainers(g2d);
        paintHp(g2d);
        paintEnergy(g2d);
        paintAttackButtons(g2d);
        paintSkillButtons(g2d);
    }

    private void paintHp(Graphics2D g2d) {
        int p = game.getOpponent().getCharacter().getHp();
        for (int i = 0; i < 30; i++) {
            if (i < p) {
                g2d.drawImage(makeImage("bar_life.png"), 798 + 6 * i, 454, null);
            } else {
                g2d.drawImage(makeImage("bar_empty.png"), 798 + 6 * i, 454, null);
            }
        }
        p = game.getPlayer().getCharacter().getHp();
        for (int i = 0; i < 30; i++) {
            if (i < p) {
                g2d.drawImage(makeImage("bar_life.png"), 27 + 6 * i, 454, null);
            } else {
                g2d.drawImage(makeImage("bar_empty.png"), 27 + 6 * i, 454, null);
            }
        }
    }

    private void paintEnergy(Graphics2D g2d) {
        int p = game.getOpponent().getCharacter().getEnergy();
        for (int i = 0; i < 30; i++) {
            if (i < p) {
                g2d.drawImage(makeImage("bar_energy.png"), 798 + 6 * i, 483, null);
            } else {
                g2d.drawImage(makeImage("bar_empty.png"), 798 + 6 * i, 483, null);
            }
        }
        p = game.getPlayer().getCharacter().getEnergy();
        for (int i = 0; i < 30; i++) {
            if (i < p) {
                g2d.drawImage(makeImage("bar_energy.png"), 27 + 6 * i, 483, null);
            } else {
                g2d.drawImage(makeImage("bar_empty.png"), 27 + 6 * i, 483, null);
            }
        }
    }

    private void paintContainers(Graphics2D g2d) {
        g2d.drawImage(makeImage("container_end.png"), 786, 453, null);
        g2d.drawImage(makeImage("container_end.png"), 786, 482, null);
        g2d.drawImage(makeImage("container_end.png"), 978 + 12, 453, -12, 16, null);
        g2d.drawImage(makeImage("container_end.png"), 978 + 12, 482, -12, 16, null);

        g2d.drawImage(makeImage("container_end.png"), 15, 453, null);
        g2d.drawImage(makeImage("container_end.png"), 15, 482, null);
        g2d.drawImage(makeImage("container_end.png"), 207 + 12, 453, -12, 16, null);
        g2d.drawImage(makeImage("container_end.png"), 207 + 12, 482, -12, 16, null);
    }

    private void paintAttackButtons(Graphics2D g2d) {
        g2d.drawImage(makeImage("hit_face_button.png"), 838, 512, null);

        if (game.getHitH()) {
            g2d.drawImage(makeImage("hit_face_button_highlight.png"), 67, 512, null);
        } else {
            g2d.drawImage(makeImage("hit_face_button.png"), 67, 512, null);
        }
    }

    private void paintSkillButtons(Graphics2D g2d) {
        g2d.drawImage(makeImage("hit_face_button.png"), 838, 512, null);
        g2d.drawImage(makeImage("skill_1_button.png"), 838, 572, null);

        if (game.getHitH()) {
            g2d.drawImage(makeImage("hit_face_button_highlight.png"), 67, 512, null);
        } else {
            g2d.drawImage(makeImage("hit_face_button.png"), 67, 512, null);
        }
        if (game.getPlayer().getSkill1Selected()) {
            g2d.drawImage(makeImage("skill_1_button_selected.png"), 67, 572, null);
        } else if (game.getSkill1H()) {
            g2d.drawImage(makeImage("skill_1_button_highlight.png"), 67, 572, null);
        } else {
            g2d.drawImage(makeImage("skill_1_button.png"), 67, 572, null);
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
