package Tile;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tile {

    private int id;
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

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void pair() {
        this.turned = false;
        this.paired = true;
        this.currentImg = createImage(turnedPath);
    }

    public void turn() {
        if (paired || turned) {
            return;
        }
        this.turned = true;
        this.currentImg = createImage(turnedPath);
    }

    public void unTurn() {
        if(paired){
            return;
        }
        this.turned = false;
        this.currentImg = createImage(blankPath);
    }

    public void highlight() {
        if (turned || paired) {
            return;
        }
        this.highlight = true;
        this.currentImg = createImage(highlightPath);
    }

    public void unHighlight() {
        if (turned || paired) {
            return;
        }
        this.highlight = false;
        this.currentImg = createImage(blankPath);
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

}
