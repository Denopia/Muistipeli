package UserInterface.MouseListener;

import Game.Instructions;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Kuuntelee Instructions olion piirtoalustalla osoittimen liiketta
 */
public class MouseListenerInstructions extends MouseAdapter {

    Instructions ins;

    /**
     * Konstruktori
     *
     * @param ins Ohje olio jota manipuloidaan
     */
    public MouseListenerInstructions(Instructions ins) {
        this.ins = ins;
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        if ((me.getX()) >= (35 - 9)
                && (me.getX()) <= (210 - 9)
                && (me.getY()) >= (63 - 38 - 7)
                && (me.getY()) <= (116 - 38 - 7)) {
            ins.getHController().highlightMenu();
        } else {
            ins.getHController().unHighlightMenu();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == 1 && (me.getX()) >= (35 - 9)
                && (me.getX()) <= (210 - 9)
                && (me.getY()) >= (63 - 38 - 7)
                && (me.getY()) <= (116 - 38 - 7)) {
            ins.backToMenu();
        }
    }
}
