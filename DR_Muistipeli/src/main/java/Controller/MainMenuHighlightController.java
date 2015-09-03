package Controller;

/**
 * Pitaa muistissa mika elementti pelin paavalikossa on korostettuna
 */
public class MainMenuHighlightController {

    private boolean mouseOnSPG;
    private boolean mouseOnIns;
    private boolean mouseOnExit;

    /**
     * Konstruktori, asettaa kaikki totuusarvot oletuksena epatodeksi
     */
    public MainMenuHighlightController() {
        unHighlightAll();
    }

    /**
     * Asettaa yksinpeli-nappulan korostetuksi
     */
    public void highlightSPG() {
        mouseOnSPG = true;
    }

    /**
     * Asettaa ohje-nappulan korostetuksi
     */
    public void highlightIns() {
        mouseOnIns = true;
    }

    /**
     * Asettaa lopeta-nappulan korostetuksi
     */
    public void highlightExit() {
        mouseOnExit = true;
    }

    /**
     * Palauttaa ohje-nappulan korostuksen totuusarvon
     *
     * @return Onko nappula korostettu
     */
    public boolean getIns() {
        return mouseOnIns;
    }

    /**
     * Palauttaa lopeta-nappulan korostuksen totuusarvon
     *
     * @return Onko nappula korostettu
     */
    public boolean getExit() {
        return mouseOnExit;
    }

    /**
     * Palauttaa yksinpeli-nappulan korostuksen totuusarvon
     *
     * @return Onko nappula korostettu
     */
    public boolean getSPG() {
        return mouseOnSPG;
    }

    /**
     * Asettaa kaikki arvot epatodeksi
     */
    public final void unHighlightAll() {
        mouseOnExit = false;
        mouseOnIns = false;
        mouseOnSPG = false;
    }
}
