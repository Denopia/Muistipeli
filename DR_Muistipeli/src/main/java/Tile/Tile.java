package Tile;

/**
 * Sisaltaa yhden laatan kaikki tiedot
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

    /**
     * Konstruktori
     *
     * @param effect laatan efekti
     * @param blankPath piilotetun laatan kuvan polku
     * @param highlightPath korostusreunan polku
     * @param turnedPath kaannetyn laatan kuvan polku
     */
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

    /**
     * Antaa x-koordinaatin
     *
     * @return koordinaatti
     */
    public int getX() {
        return x;
    }

    /**
     * Antaa y-koordinaatin
     *
     * @return koordinaatti
     */
    public int getY() {
        return y;
    }

    /**
     * Asettaa x- ja y- koordinaatit
     *
     * @param x koordinaatti
     * @param y koordinaatti
     */
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
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

    /**
     * Laittaa laatan parilliseksi
     */
    public void pair() {
        turned = false;
        paired = true;
        currentImg = turnedPath;
    }

    /**
     * Kaantaa laatan jos ei ole jo kaannetty tai parillinen
     */
    public void turn() {
        if (paired || turned) {
            return;
        }
        unHighlight();
        turned = true;
        currentImg = turnedPath;
    }

    /**
     * Piilottaa laatan jos se ei ole parillinen
     */
    public void unTurn() {
        if (paired) {
            return;
        }
        unHighlight();
        turned = false;
        currentImg = blankPath;
    }

    /**
     * Korostaa laatan jos se ei ole parillinen tai jo kaannetty
     */
    public void highlight() {
        if (turned || paired) {
            return;
        }
        highlight = true;
    }

    /**
     * Poistaa korostuksen laatasta jos se ei ole parillinen tai jo kaannetty
     */
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

    public String getHighlightBorder() {
        return highlightPath;
    }
}
