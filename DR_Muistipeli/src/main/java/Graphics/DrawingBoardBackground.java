package Graphics;

import Player.Player;
import Tile.Tile;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawingBoardBackground extends JPanel {

    private ArrayList<Tile> tiles;
    private Player player;

    public DrawingBoardBackground(ArrayList<Tile> tiles, Player player) {
        this.tiles = tiles;
        this.player = player;
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(makeImage("background.png"), 0, 0, null);
        for (Tile tile : tiles) {
            g2d.drawImage(tile.getImage(), tile.getX(), tile.getY(), null);
        }
        g2d.drawImage(player.getPortrait(), 15, 133, null);
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
