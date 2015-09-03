package UserInterface.MouseListener;

import Game.MainMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Kuuntelee MainMenu olion piirtoalustalla osoittimen liiketta
 */
public class MouseListenerMainMenu extends MouseAdapter {

    private MainMenu menu;

    /**
     * Konstruktori
     *
     * @param menu Valikko jota manipuloidaan
     */
    public MouseListenerMainMenu(MainMenu menu) {
        this.menu = menu;
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        menu.getHController().unHighlightAll();
        if ((me.getX()) >= (418 - 9)
                && (me.getX()) <= (605 - 9)
                && (me.getY()) >= (309 - 38)
                && (me.getY()) <= (366 - 38)) {
            menu.getHController().highlightSPG();
        } else if ((me.getX()) >= (476 - 9)
                && (me.getX()) <= (548 - 9)
                && (me.getY()) >= (498 - 38)
                && (me.getY()) <= (531 - 38)) {
            menu.getHController().highlightIns();
        } else if ((me.getX()) >= (476 - 9)
                && (me.getX()) <= (548 - 9)
                && (me.getY()) >= (598 - 38)
                && (me.getY()) <= (631 - 38)) {
            menu.getHController().highlightExit();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == 1) {
            if ((me.getX()) >= (418 - 9)
                    && (me.getX()) <= (605 - 9)
                    && (me.getY()) >= (309 - 38)
                    && (me.getY()) <= (366 - 38)) {
                menu.startPreparationScreen(1);
            } else if ((me.getX()) >= (476 - 9)
                    && (me.getX()) <= (548 - 9)
                    && (me.getY()) >= (498 - 38)
                    && (me.getY()) <= (531 - 38)) {
                menu.showInstructions();
            } else if ((me.getX()) >= (476 - 9)
                    && (me.getX()) <= (548 - 9)
                    && (me.getY()) >= (598 - 38)
                    && (me.getY()) <= (631 - 38)) {
                menu.closeGame();
            }
        }
    }
}
