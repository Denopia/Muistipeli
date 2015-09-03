package Controller;

/**
 * Pitaa muistissa totuusarvolla onko osoitin valikko-nappulan paalla
 * ohjeruudussa.
 *
 * @author Miika
 */
public class InstructionsHighlightController {

    private boolean mouseOnMenu;

    /**
     * Konstruktori, asettaa oletusarvon epatodeksi
     */
    public InstructionsHighlightController() {
        mouseOnMenu = false;
    }

    /**
     * Asettaa totuusarvon todeksi
     */
    public void highlightMenu() {
        mouseOnMenu = true;
    }

    /**
     * Asettaa totuusarvon epatodeksi
     */
    public void unHighlightMenu() {
        mouseOnMenu = false;
    }

    /**
     * Palauttaa totuusarvon
     *
     * @return Onko osoitin valikko-nappulan paalla
     */
    public boolean getMenuH() {
        return mouseOnMenu;
    }

}
