package Controller;

/**
 * Pitaa vain ylla mitka elementit pelin paavalikossa ovat korostettuna
 */
public class MainMenuHighlightController {

    private boolean mouseOnSPG;
    private boolean mouseOnIns;
    private boolean mouseOnExit;

    public MainMenuHighlightController() {
        unHighlightAll();
    }

    public void highlightSPG() {
        mouseOnSPG = true;
    }

    public void highlightIns() {
        mouseOnIns = true;
    }

    public void highlightExit() {
        mouseOnExit = true;
    }

    public boolean getIns() {
        return mouseOnIns;
    }

    public boolean getExit() {
        return mouseOnExit;
    }

    public boolean getSPG() {
        return mouseOnSPG;
    }

    public final void unHighlightAll() {
        mouseOnExit = false;
        mouseOnIns = false;
        mouseOnSPG = false;
    }
}
