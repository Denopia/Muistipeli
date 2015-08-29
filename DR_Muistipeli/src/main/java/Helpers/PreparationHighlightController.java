package Helpers;

/**
 * Pitaa vain ylla mitka elementit pelin valmisteluruudulla ovat korostettuna
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

    public PreparationHighlightController() {
        unHighlightAll();
    }

    /**
     * Laittaa kaikkien nappuloiden korostusarvoksi false
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
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightA1() {
        mouseOnArrow1 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightA2() {
        mouseOnArrow2 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightA3() {
        mouseOnArrow3 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightA4() {
        mouseOnArrow4 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightD1() {
        mouseOnDifficulty1 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightD2() {
        mouseOnDifficulty2 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightD3() {
        mouseOnDifficulty3 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightD4() {
        mouseOnDifficulty4 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightMenu() {
        mouseOnMenu = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightStart() {
        mouseOnStart = true;
    }

    public boolean getA1() {
        return mouseOnArrow1;
    }

    public boolean getA2() {
        return mouseOnArrow2;
    }

    public boolean getA3() {
        return mouseOnArrow3;
    }

    public boolean getA4() {
        return mouseOnArrow4;
    }

    public boolean getD1() {
        return mouseOnDifficulty1;
    }

    public boolean getD2() {
        return mouseOnDifficulty2;
    }

    public boolean getD3() {
        return mouseOnDifficulty3;
    }

    public boolean getD4() {
        return mouseOnDifficulty4;
    }

    public boolean getMenu() {
        return mouseOnMenu;
    }

    public boolean getStart() {
        return mouseOnStart;
    }

}
