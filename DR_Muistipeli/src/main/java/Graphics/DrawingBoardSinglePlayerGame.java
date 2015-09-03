package Graphics;

import Game.GameModes.SinglePlayerGame;
import GameCharacter.Apollo;
import GameCharacter.Gus;
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

    /**
     * Konstruktori
     *
     * @param game Yksinpeli olio jolta haetaan tietoja
     */
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
        paintExit(g2d);
    }

    private void paintPlayers(Graphics2D g2d) {
        g2d.drawImage(makeImage(game.getPlayer().getCharacter().getCurrentImage()), 18, 139, null);
        g2d.drawImage(makeImage(game.getOpponent().getCharacter().getCurrentImage()), 789 + 200, 139, -200, 300, null);
    }

    private void paintBackground(Graphics2D g2d) {
        g2d.drawImage(makeImage("background4.png"), 0, 0, null);
    }

    private void paintTiles(Graphics2D g2d) {
        for (Tile tile : game.getTController().getTiles()) {
            g2d.drawImage(makeImage(tile.getImage()), tile.getX(), tile.getY(), null);
            if (tile.getHighlight() && !game.getPlayer().getSkillSelected()) {
                g2d.drawImage(makeImage(tile.getHighlightBorder()), tile.getX(), tile.getY(), null);
            }
        }

        if (game.getPlayer().getSkillSelected()) {
            if (game.getPlayer().getCharacter().getClass() == Gus.class) {
                Image img = makeImage("skill_1_area.png");
                if (game.getHController().getHorRow() == 1) {
                    g2d.drawImage(img, 259 - 9, 185 - 38, null);
                } else if (game.getHController().getHorRow() == 2) {
                    g2d.drawImage(img, 259 - 9, 270 - 38, null);
                } else if (game.getHController().getHorRow() == 3) {
                    g2d.drawImage(img, 259 - 9, 355 - 38, null);
                } else if (game.getHController().getHorRow() == 4) {
                    g2d.drawImage(img, 259 - 9, 440 - 38, null);
                } else if (game.getHController().getHorRow() == 5) {
                    g2d.drawImage(img, 259 - 9, 525 - 38, null);
                } else if (game.getHController().getHorRow() == 6) {
                    g2d.drawImage(img, 259 - 9, 610 - 38, null);
                }
            } else if (game.getPlayer().getCharacter().getClass() == Apollo.class) {
                Image img = makeImage("skill_2_area.png");
                if (game.getHController().getVerRow() == 1) {
                    g2d.drawImage(img, 259 - 9, 185 - 38, null);
                } else if (game.getHController().getVerRow() == 2) {
                    g2d.drawImage(img, 344 - 9, 185 - 38, null);
                } else if (game.getHController().getVerRow() == 3) {
                    g2d.drawImage(img, 429 - 9, 185 - 38, null);
                } else if (game.getHController().getVerRow() == 4) {
                    g2d.drawImage(img, 429 + 85 - 9, 185 - 38, null);
                } else if (game.getHController().getVerRow() == 5) {
                    g2d.drawImage(img, 429 + 85 + 85 - 9, 185 - 38, null);
                } else if (game.getHController().getVerRow() == 6) {
                    g2d.drawImage(img, 429 + 85 + 85 + 85 - 9, 185 - 38, null);
                }
            }
        }
    }

    private void paintFrames(Graphics2D g2d) {
        g2d.drawImage(makeImage("character_frame.png"), 783, 133, null);
        g2d.drawImage(makeImage("character_frame.png"), 12, 133, null);
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

        if (game.getHController().getHitH()) {
            g2d.drawImage(makeImage("hit_face_button_highlight.png"), 67, 512, null);
        } else {
            g2d.drawImage(makeImage("hit_face_button.png"), 67, 512, null);
        }
    }

    private void paintSkillButtons(Graphics2D g2d) {
        g2d.drawImage(makeImage("hit_face_button.png"), 838, 512, null);
        g2d.drawImage(makeImage("skill_1_button.png"), 838, 572, null);

        if (game.getHController().getHitH()) {
            g2d.drawImage(makeImage("hit_face_button_highlight.png"), 67, 512, null);
        } else {
            g2d.drawImage(makeImage("hit_face_button.png"), 67, 512, null);
        }
        if (game.getPlayer().getSkillSelected()) {
            g2d.drawImage(makeImage("skill_1_button_selected.png"), 67, 572, null);
        } else if (game.getHController().getSkillH()) {
            g2d.drawImage(makeImage("skill_1_button_highlight.png"), 67, 572, null);
        } else {
            g2d.drawImage(makeImage("skill_1_button.png"), 67, 572, null);
        }
    }

    private Image makeImage(String path) {
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

    private void paintExit(Graphics2D g2d) {
        if (game.getHController().getExitH()) {
            g2d.drawImage(makeImage("give_up_highlight.png"), 450, 711 - 38, null);
        } else {
            g2d.drawImage(makeImage("give_up.png"), 450, 711 - 38, null);
        }
    }
}
