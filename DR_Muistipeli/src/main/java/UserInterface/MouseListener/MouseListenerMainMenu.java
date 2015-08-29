package UserInterface.MouseListener;

import Game.MainMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Kuuntelee hiiren liikettä ja klikkauksia. Suorittaa metodeja niiden
 * perusteella.
 *
 */
public class MouseListenerMainMenu extends MouseAdapter {

    private final MainMenu menu;

    public MouseListenerMainMenu(MainMenu menu) {
        this.menu = menu;
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        if ((me.getX()) >= (418)
                && (me.getX()) <= (605)
                && (me.getY()) >= (309)
                && (me.getY()) <= (366)) {
            menu.getHController().highlightSPG();
        } else if ((me.getX()) >= (476)
                && (me.getX()) <= (548)
                && (me.getY()) >= (498)
                && (me.getY()) <= (531)) {
            menu.getHController().highlightIns();
        } else if ((me.getX()) >= (476)
                && (me.getX()) <= (548)
                && (me.getY()) >= (598)
                && (me.getY()) <= (631)) {
            menu.getHController().highlightExit();
        } else {
            menu.unHighlightAllAndDraw();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == 1) {
            if ((me.getX()) >= (418)
                    && (me.getX()) <= (605)
                    && (me.getY()) >= (309)
                    && (me.getY()) <= (366)) {
                menu.startPreparationScreen(1);
            } else if ((me.getX()) >= (476)
                    && (me.getX()) <= (548)
                    && (me.getY()) >= (498)
                    && (me.getY()) <= (531)) {
                menu.showInstructions();
            } else if ((me.getX()) >= (476)
                    && (me.getX()) <= (548)
                    && (me.getY()) >= (598)
                    && (me.getY()) <= (631)) {
                menu.closeGame();
            }
        }
    }
}
