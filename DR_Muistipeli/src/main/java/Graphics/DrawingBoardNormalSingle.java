package Graphics;

import Player.NormalOpponentAI;
import Player.NormalPlayer;
import Tile.NormalTile;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawingBoardNormalSingle extends JPanel {

    private ArrayList<NormalTile> tiles;
    private NormalPlayer player;
    private NormalOpponentAI opponent;

    public DrawingBoardNormalSingle(ArrayList<NormalTile> tiles, NormalPlayer player, NormalOpponentAI opponent) {
        this.tiles = tiles;
        this.player = player;
        this.opponent = opponent;
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(makeImage("background.png"), 0, 0, null);
        for (NormalTile tile : tiles) {
            g2d.drawImage(tile.getImage(), tile.getX(), tile.getY(), null);
        }
        g2d.drawImage(player.getPortrait(), 15, 133, null);
        g2d.drawImage(opponent.getPortrait(), 786 + 206, 133, -206, 306, null);

        paintScore(g2d);
    }

    private void paintScore(Graphics2D g2d) {
        g2d.drawImage(makeImage("scoretext.png"), 15, 454, null);
        g2d.drawImage(makeImage("scoretext.png"), 786, 454, null);

        int playerScore = player.getNumberOfPairsScored() / 2;
        int opponentScore = opponent.getNumberOfPairsScored() / 2;

        if (playerScore < 10) {
            String psp = "score" + playerScore + ".png";
            g2d.drawImage(makeImage(psp), 124, 454, null);
        } else {
            String psp1 = "score" + playerScore / 10 + ".png";
            String psp2 = "score" + (playerScore - 10) + ".png";
            g2d.drawImage(makeImage(psp1), 124, 454, null);
            g2d.drawImage(makeImage(psp2), 143, 454, null);
        }
        if (opponentScore < 10) {
            String osp = "score" + opponentScore + ".png";
            g2d.drawImage(makeImage(osp), 895, 454, null);
        } else {
            String osp1 = "score" + opponentScore / 10 + ".png";
            String osp2 = "score" + (opponentScore - 10) + ".png";
            g2d.drawImage(makeImage(osp1), 895, 454, null);
            g2d.drawImage(makeImage(osp2), 914, 454, null);
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
