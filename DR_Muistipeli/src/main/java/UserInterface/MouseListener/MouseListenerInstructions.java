package UserInterface.MouseListener;

import Game.Instructions;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListenerInstructions extends MouseAdapter {

    Instructions ins;

    public MouseListenerInstructions(Instructions ins) {
        this.ins = ins;
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        if ((me.getX()) >= (35)
                && (me.getX()) <= (210)
                && (me.getY()) >= (63)
                && (me.getY()) <= (116)) {
            ins.getHController().highlightMenu();
        } else {
            ins.getHController().unHighlightMenu();
        }
        ins.refresh();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == 1 && (me.getX()) >= (35)
                && (me.getX()) <= (210)
                && (me.getY()) >= (63)
                && (me.getY()) <= (116)) {
            ins.backToMenu();
        }
    }
}
