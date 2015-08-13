package UserInterface;

import Game.MainMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseMovementListenerMainMenu extends MouseAdapter {

    private final MainMenu menu;

    public MouseMovementListenerMainMenu(MainMenu menu) {
        this.menu = menu;
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        if ((me.getX()) >= (421)
                && (me.getX()) <= (421 + 188)
                && (me.getY()) >= (224)
                && (me.getY()) <= (224 + 59)) {
            menu.highlightNSPG();
        } else if ((me.getX()) >= (421)
                && (me.getX()) <= (421 + 188)
                && (me.getY()) >= (285)
                && (me.getY()) <= (285 + 59)) {
            menu.highlightNMPG();
        } else if ((me.getX()) >= (421)
                && (me.getX()) <= (421 + 188)
                && (me.getY()) >= (416)
                && (me.getY()) <= (416 + 59)) {
            menu.highlightBSPG();
        } else if ((me.getX()) >= (421)
                && (me.getX()) <= (421 + 188)
                && (me.getY()) >= (476)
                && (me.getY()) <= (476 + 59)) {
            menu.highlightBMPG();
        } else if ((me.getX()) >= (475)
                && (me.getX()) <= (475 + 73)
                && (me.getY()) >= (600)
                && (me.getY()) <= (600 + 34)) {
            menu.highlightIns();
        } else {
            menu.unHighlightAllAndDraw();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if ((me.getX() - 9) >= (236)
                && (me.getX() - 9) <= (534 + 236)
                && (me.getY() - 38) >= (179)
                && (me.getY() - 38) <= (100 + 179)) {
            menu.startNormalSinglePlayerGame();
        } else if ((me.getX() - 9) >= (236)
                && (me.getX() - 9) <= (534 + 236)
                && (me.getY() - 38) >= (339)
                && (me.getY() - 38) <= (100 + 339)) {
            menu.showInstructions();
        } else if ((me.getX() - 9) >= (884)
                && (me.getX() - 9) <= (884 + 94)
                && (me.getY() - 38) >= (647)
                && (me.getY() - 38) <= (42 + 647)) {
            menu.closeGame();
        }
    }
}
