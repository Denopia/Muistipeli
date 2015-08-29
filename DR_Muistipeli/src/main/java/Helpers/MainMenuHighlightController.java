package Helpers;

import Game.MainMenu;

/**
 * Pitaa vain ylla mitka elementit pelin paavalikossa ovat korostettuna
 */
public class MainMenuHighlightController {

    private boolean mouseOnSPG;
    private boolean mouseOnIns;
    private boolean mouseOnExit;
    private MainMenu menu;

    public MainMenuHighlightController(MainMenu menu) {
        this.menu = menu;
        unHighlightAll();
    }

    public void highlightSPG() {
        if (!mouseOnSPG) {
            unHighlightAll();
            mouseOnSPG = true;
            menu.refresh();
        }
    }

    public void highlightIns() {
        if (!mouseOnIns) {
            unHighlightAll();
            mouseOnIns = true;
            menu.refresh();
        }
    }

    public void highlightExit() {
        if (!mouseOnExit) {
            unHighlightAll();
            mouseOnExit = true;
            menu.refresh();
        }
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
