package Tile;

import java.awt.Image;

/**
 * Sisaltaa yhden laatan kaikki tiedot ja voi palauttaa sen arvoja tai muutella
 * niita
 *
 */
public class Tile {

    private String effect;
    private int placement;
    private int x;
    private int y;
    private boolean turned;
    private boolean highlight;
    private boolean paired;
    private String blankPath;
    private String highlightPath;
    private String turnedPath;
    private String currentImg;

    public Tile(String effect, String blankPath, String highlightPath, String turnedPath) {
        this.effect = effect;
        this.blankPath = blankPath;
        this.highlightPath = highlightPath;
        this.turnedPath = turnedPath;
        this.turned = false;
        this.highlight = false;
        this.paired = false;
        this.currentImg = blankPath;
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

    public String getEffect() {
        return effect;
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
        currentImg = turnedPath;
    }

    public void turn() {
        if (paired || turned) {
            return;
        }
        unHighlight();
        turned = true;
        currentImg = turnedPath;
    }

    public void unTurn() {
        if (paired) {
            return;
        }
        unHighlight();
        turned = false;
        currentImg = blankPath;
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

    public String getImage() {
        return currentImg;
    }

    public boolean getPaired() {
        return paired;
    }

    public String getHighlightImage() {
        return highlightPath;
    }
}
