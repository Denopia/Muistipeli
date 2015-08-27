package Tile;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Sisaltaa yhden laatan kaikki tiedot ja voi palauttaa sen arvoja tai muutella
 * niita
 *
 */
public class Tile {

    private int id;
    private int placement;
    private int x;
    private int y;
    private boolean turned;
    private boolean highlight;
    private boolean paired;
    private String blankPath;
    private String highlightPath;
    private String turnedPath;
    private Image currentImg;

    public Tile(int p, String blankPath, String highlightPath, String turnedPath) {
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
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getTurned() {
        return turned;
    }

    public boolean getHighlight() {
        return highlight;
    }

    public int getId() {
        return id;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int i) {
        placement = i;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void pair() {
        turned = false;
        paired = true;
        currentImg = createImage(turnedPath);
    }

    public void turn() {
        if (paired || turned) {
            return;
        }
        unHighlight();
        turned = true;
        currentImg = createImage(turnedPath);
    }

    public void unTurn() {
        if (paired) {
            return;
        }
        unHighlight();
        turned = false;
        currentImg = createImage(blankPath);
    }

    public void highlight() {
        if (turned || paired) {
            return;
        }
        highlight = true;
    }

    public void unHighlight() {
        if (turned || paired) {
            return;
        }
        highlight = false;
    }

    public Image getImage() {
        return currentImg;
    }

    public boolean getPaired() {
        return paired;
    }

    public Image getHighlightImage() {
        return createImage(highlightPath);
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
}
