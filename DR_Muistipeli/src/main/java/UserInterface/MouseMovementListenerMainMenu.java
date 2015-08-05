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
        if ((me.getX() - 9) >= (236)
                && (me.getX() - 9) <= (534 + 236)
                && (me.getY() - 38) >= (179)
                && (me.getY() - 38) <= (100 + 179)) {
            menu.highlightSPG();
        } else if ((me.getX() - 9) >= (236)
                && (me.getX() - 9) <= (534 + 236)
                && (me.getY() - 38) >= (339)
                && (me.getY() - 38) <= (100 + 339)) {
            menu.highlightIns();
        } else if ((me.getX() - 9) >= (884)
                && (me.getX() - 9) <= (884 + 94)
                && (me.getY() - 38) >= (647)
                && (me.getY() - 38) <= (42 + 647)) {
            menu.highlightExit();
        } else {
            menu.unHighlightAll();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if ((me.getX() - 9) >= (236)
                && (me.getX() - 9) <= (534 + 236)
                && (me.getY() - 38) >= (179)
                && (me.getY() - 38) <= (100 + 179)) {
            menu.startSinglePlayerGame();
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
