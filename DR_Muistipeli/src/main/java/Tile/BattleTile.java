package Tile;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Pelilaatta. Sillä on kuva ja sijainti
 *
 */
public class BattleTile {

    private int id;
    private int placement;
    private int x;
    private int y;
    private boolean turned;
    private boolean highlight;
    private boolean readyToBepaired;
    private boolean paired;
    private String blankPath;
    private String highlightPath;
    private String turnedPath;
    private Image currentImg;

    public BattleTile(int p, String blankPath, String highlightPath, String turnedPath) {
        this.readyToBepaired = false;
        this.id = p;
        this.blankPath = blankPath;
        this.highlightPath = highlightPath;
        this.turnedPath = turnedPath;
        this.turned = false;
        this.highlight = false;
        this.paired = false;
        this.currentImg = createImage(blankPath);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getTurned() {
        return this.turned;
    }

    public boolean getHighlight() {
        return this.highlight;
    }

    public int getId() {
        return this.id;
    }

    public int getPlacement() {
        return this.placement;
    }

    public void setPlacement(int i) {
        this.placement = i;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void pair() {
        this.readyToBepaired = false;
        this.turned = false;
        this.paired = true;
        this.currentImg = createImage(turnedPath);
    }

    public boolean getReadyToBePaired() {
        return this.readyToBepaired;
    }

    public void setReadyToBePaired() {
        this.readyToBepaired = true;
    }

    public void setNotReadyToBePaired() {
        this.readyToBepaired = false;
    }

    public void turn() {
        if (paired || turned) {
            return;
        }
        unHighlight();
        this.turned = true;
        this.currentImg = createImage(turnedPath);
    }

    public void unTurn() {
        if (paired) {
            return;
        }
        unHighlight();
        this.readyToBepaired = false;
        this.turned = false;
        this.currentImg = createImage(blankPath);
    }

    public void highlight() {
        if (turned || paired) {
            return;
        }
        this.highlight = true;
    }

    public void unHighlight() {
        if (turned || paired) {
            return;
        }
        this.highlight = false;
    }

    public Image getImage() {
        return currentImg;
    }

    private Image createImage(String path) {
        ImageIcon icon = null;
        java.net.URL imgURL = getClass().getClassLoader().getResource(path);
        if (imgURL != null) {
            icon = new ImageIcon(imgURL);
        } else {
            System.err.println("Picture " + path + " not found");
        }
        Image kuva = icon.getImage();
        return kuva;
    }

    public boolean getPaired() {
        return this.paired;
    }

    public String getHighlightPath() {
        return this.blankPath;
    }

    public Image getHighlightImage() {
        return createImage(highlightPath);
    }

}
