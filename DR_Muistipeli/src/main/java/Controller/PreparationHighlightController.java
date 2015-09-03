package Controller;

/**
 * Pitaa muistissa mika elementti pelin valmisteluruudulla on korostettuna, eli
 * minka nappulan paalla osoitin on
 */
public class PreparationHighlightController {

    private boolean mouseOnArrow1;
    private boolean mouseOnArrow2;
    private boolean mouseOnArrow3;
    private boolean mouseOnArrow4;
    private boolean mouseOnDifficulty1;
    private boolean mouseOnDifficulty2;
    private boolean mouseOnDifficulty3;
    private boolean mouseOnDifficulty4;
    private boolean mouseOnStart;
    private boolean mouseOnMenu;

    /**
     * Konstruktori, asettaa kaikki arvot epatodeksi
     */
    public PreparationHighlightController() {
        unHighlightAll();
    }

    /**
     * Laittaa kaikkien nappuloiden korostuksen totuussarvoksi epatosi
     */
    public final void unHighlightAll() {
        mouseOnArrow1 = false;
        mouseOnArrow2 = false;
        mouseOnArrow3 = false;
        mouseOnArrow4 = false;
        mouseOnDifficulty1 = false;
        mouseOnDifficulty2 = false;
        mouseOnDifficulty3 = false;
        mouseOnDifficulty4 = false;
        mouseOnStart = false;
        mouseOnMenu = false;
    }

    /**
     * Laittaa taman nappulan korostetuksi
     */
    public void highlightA1() {
        mouseOnArrow1 = true;
    }

    /**
     * Laittaa taman nappulan korostetuksi
     */
    public void highlightA2() {
        mouseOnArrow2 = true;
    }

    /**
     * Laittaa taman nappulan korostetuksi
     */
    public void highlightA3() {
        mouseOnArrow3 = true;
    }

    /**
     * Laittaa taman nappulan korostetuksi
     */
    public void highlightA4() {
        mouseOnArrow4 = true;
    }

    /**
     * Laittaa taman nappulan korostetuksi
     */
    public void highlightD1() {
        mouseOnDifficulty1 = true;
    }

    /**
     * Laittaa taman nappulan korostetuksi
     */
    public void highlightD2() {
        mouseOnDifficulty2 = true;
    }

    /**
     * Laittaa taman nappulan korostetuksi
     */
    public void highlightD3() {
        mouseOnDifficulty3 = true;
    }

    /**
     * Laittaa taman nappulan korostetuksi
     */
    public void highlightD4() {
        mouseOnDifficulty4 = true;
    }

    /**
     * Laittaa taman nappulan korostetuksi
     */
    public void highlightMenu() {
        mouseOnMenu = true;
    }

    /**
     * Laittaa taman nappulan korostetuksi
     */
    public void highlightStart() {
        mouseOnStart = true;
    }

    /**
     * Palauttaa taman nappulan korostuksen totuusarvon
     *
     * @return Korostuksen totuusarvo
     */
    public boolean getA1() {
        return mouseOnArrow1;
    }

    /**
     * Palauttaa taman nappulan korostuksen totuusarvon
     *
     * @return Korostuksen totuusarvo
     */
    public boolean getA2() {
        return mouseOnArrow2;
    }

    /**
     * Palauttaa taman nappulan korostuksen totuusarvon
     *
     * @return Korostuksen totuusarvo
     */
    public boolean getA3() {
        return mouseOnArrow3;
    }

    /**
     * Palauttaa taman nappulan korostuksen totuusarvon
     *
     * @return Korostuksen totuusarvo
     */
    public boolean getA4() {
        return mouseOnArrow4;
    }

    /**
     * Palauttaa taman nappulan korostuksen totuusarvon
     *
     * @return Korostuksen totuusarvo
     */
    public boolean getD1() {
        return mouseOnDifficulty1;
    }

    /**
     * Palauttaa taman nappulan korostuksen totuusarvon
     *
     * @return Korostuksen totuusarvo
     */
    public boolean getD2() {
        return mouseOnDifficulty2;
    }

    /**
     * Palauttaa taman nappulan korostuksen totuusarvon
     *
     * @return Korostuksen totuusarvo
     */
    public boolean getD3() {
        return mouseOnDifficulty3;
    }

    /**
     * Palauttaa taman nappulan korostuksen totuusarvon
     *
     * @return Korostuksen totuusarvo
     */
    public boolean getD4() {
        return mouseOnDifficulty4;
    }

    /**
     * Palauttaa taman nappulan korostuksen totuusarvon
     *
     * @return Korostuksen totuusarvo
     */
    public boolean getMenu() {
        return mouseOnMenu;
    }

    /**
     * Palauttaa taman nappulan korostuksen totuusarvon
     *
     * @return Korostuksen totuusarvo
     */
    public boolean getStart() {
        return mouseOnStart;
    }

}
